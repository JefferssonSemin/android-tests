package com.hvn.usuario.presentation.fragments

import android.app.Activity.RESULT_OK
import android.content.ContentValues
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.net.toUri
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import com.hvn.usuario.R
import com.hvn.usuario.data.dataModels.ResponseData
import com.hvn.usuario.data.dataModels.UsuarioData
import com.hvn.usuario.data.room.DataManager
import com.hvn.usuario.data.room.DatabaseHelper
import com.hvn.usuario.data.room.UsuarioDbContract
import com.hvn.usuario.databinding.UsuarioFragmentBinding
import com.hvn.usuario.domain.entities.Usuario
import com.hvn.usuario.presentation.adapters.HistoricoListAdapter
import com.hvn.usuario.presentation.viewModels.UsuarioViewModel
import es.dmoral.toasty.Toasty
import org.koin.androidx.viewmodel.ext.android.viewModel


class UsuarioFragment() : Fragment() {

    private val usuarioViewModel: UsuarioViewModel by viewModel()
    private lateinit var databaseHelper: DatabaseHelper
    private lateinit var adaptador: HistoricoListAdapter

    private lateinit var binding: UsuarioFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        databaseHelper = DatabaseHelper(requireContext())
        binding = UsuarioFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.buttonAlteraNome.setOnClickListener {
            val nome = binding.editNovoTexto.text.toString()
            if (!nome.isNullOrEmpty())
                buscarUsuarios(nome)
            else
                Toasty.warning(
                    requireContext(),
                    "Digite um username válido.",
                    Toast.LENGTH_SHORT,
                    true
                ).show();

        }

        binding.buttonLimpar.setOnClickListener {
            limpaCampos()
        }

        binding.buttonHistoricoUsuario.setOnClickListener {
            findNavController()
                .navigate(R.id.action_usuarioFragment_to_historicoFragment)
        }
    }


    private fun buscarUsuarios(nome: String) {
        usuarioViewModel.buscarUsuario(nome)
        usuarioViewModel.usuario.observe(viewLifecycleOwner, Observer {
            carregaCampos(it)
        })
    }

    private fun carregaCampos(responseData: ResponseData<UsuarioData>) {
        if (responseData.sucesso) {
            val modelo = responseData.modelo!!
            binding.textTextoCentral.text = modelo.name
            binding.textTextoLocalizacao.text = modelo.location
            Glide.with(this).load(modelo.avatar_url.toUri()).into(binding.imageViewUsuario)

            salvaUsuarioSqlite(usuarioViewModel.mapUsuario(modelo))

        } else
            Toasty.error(
                requireContext(),
                responseData.mensagem,
                Toast.LENGTH_SHORT,
                true
            ).show()
    }

    private fun salvaUsuarioSqlite(usuario: Usuario) {
        val db = databaseHelper.writableDatabase

        val values = ContentValues()
        with(values) {
            put(UsuarioDbContract.UsuarioEntry.COLUMN_NAME, usuario.name)
            put(UsuarioDbContract.UsuarioEntry.COLUMN_LOCATION, usuario.localization)
            put(UsuarioDbContract.UsuarioEntry.COLUMN_URL, usuario.url)
        }

        val result = db.insert(UsuarioDbContract.UsuarioEntry.TABLE_NAME, null, values)
        activity?.setResult(RESULT_OK, Intent())

        if (result > 0)
            Toasty.success(
                requireContext(),
                "Histórico salvo com sucesso",
                Toast.LENGTH_SHORT,
                true
            ).show()
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (resultCode == RESULT_OK) {
            adaptador = HistoricoListAdapter(DataManager.buscaTodosUsuarios(databaseHelper))
        }
    }


    private fun limpaCampos() {
        binding.imageViewUsuario.setImageResource(R.drawable.ic_launcher_foreground)
        binding.textTextoCentral.text = "Name"
        binding.textTextoLocalizacao.text = "Localization"
        binding.editNovoTexto.setText("")
    }
}
