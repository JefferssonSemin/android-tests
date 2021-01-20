package com.hvn.usuario.presentation.fragments

import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.hvn.usuario.databinding.DetalhesUsuarioFragmentBinding

class DetalhesUsuarioFragment : Fragment() {

    private lateinit var binding: DetalhesUsuarioFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        super.onCreateView(inflater, container, savedInstanceState)
        binding = DetalhesUsuarioFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        arguments?.let {
            val safeArgs = DetalhesUsuarioFragmentArgs.fromBundle(it)
            val args = safeArgs.argsDeep
            binding.textViewTitulo.text = args.toString()
        }

        binding.buttonDetalhesUsuario.setOnClickListener {
            val uri = Uri.parse("myApp://tecnologiasFragment/teste")
            findNavController().navigate(uri)
        }
    }
}