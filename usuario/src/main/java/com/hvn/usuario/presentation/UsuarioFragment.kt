package com.hvn.usuario.presentation

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
import com.hvn.usuario.databinding.UsuarioFragmentBinding
import es.dmoral.toasty.Toasty
import org.koin.androidx.viewmodel.ext.android.viewModel


class UsuarioFragment() : Fragment() {

    // Lazy Inject ViewModel
    private val usuarioViewModel: UsuarioViewModel by viewModel()

    private lateinit var binding: UsuarioFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

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

        binding.buttonDetalhesUsuario.setOnClickListener {
            findNavController()
                .navigate(R.id.action_usuarioFragment_to_detalhesUsuarioFragment)
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
        } else
            Toasty.error(
                requireContext(),
                responseData.mensagem,
                Toast.LENGTH_SHORT,
                true
            ).show()
    }

    private fun limpaCampos() {
        binding.imageViewUsuario.setImageResource(0)
        binding.textTextoCentral.text = ""
        binding.editNovoTexto.setText("")
    }
}
