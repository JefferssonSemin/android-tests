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
import com.hvn.usuario.databinding.UsuarioFragmentBinding
import com.hvn.usuario.domain.entities.Usuario
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
                Toast.makeText(
                    requireContext(),
                    "Insira um username válido",
                    Toast.LENGTH_LONG
                ).show()

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

    private fun carregaCampos(usuario: Usuario) {
        binding.textTextoCentral.text = usuario.name
        Glide.with(this).load(usuario.avatar_url.toUri()).into(binding.imageViewUsuario);
    }

    private fun limpaCampos() {
        binding.imageViewUsuario.setImageResource(0)
        binding.textTextoCentral.text = ""
        binding.editNovoTexto.setText("")
    }
}
