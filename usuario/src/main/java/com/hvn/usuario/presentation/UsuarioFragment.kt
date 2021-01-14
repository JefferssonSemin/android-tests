package com.hvn.usuario.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.hvn.usuario.R
import com.hvn.usuario.databinding.UsuarioFragmentBinding


class UsuarioFragment : Fragment() {

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
            binding.textTextoCentral.text = nome
        }

        binding.buttonLimpar.setOnClickListener {
            binding.imageViewUsuario.setImageResource(0)
            binding.textTextoCentral.text = ""
            binding.editNovoTexto.setText("")
        }

        binding.buttonDetalhesUsuario.setOnClickListener {
            Navigation.findNavController(it)
                .navigate(R.id.action_usuarioFragment_to_detalhesUsuarioFragment)
        }
    }
}
