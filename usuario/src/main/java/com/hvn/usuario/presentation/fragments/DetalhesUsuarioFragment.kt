package com.hvn.usuario.presentation.fragments

import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.net.toUri
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import com.hvn.usuario.R
import com.hvn.usuario.data.room.DataManager
import com.hvn.usuario.data.room.DatabaseHelper
import com.hvn.usuario.databinding.DetalhesUsuarioFragmentBinding
import com.hvn.usuario.domain.entities.Usuario

class DetalhesUsuarioFragment : Fragment() {

    private lateinit var binding: DetalhesUsuarioFragmentBinding
    private lateinit var databaseHelper: DatabaseHelper
    private lateinit var usuario: Usuario

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        databaseHelper = DatabaseHelper(requireContext())
        super.onCreateView(inflater, container, savedInstanceState)
        binding = DetalhesUsuarioFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        arguments?.let {
            val safeArgs = DetalhesUsuarioFragmentArgs.fromBundle(it)
            usuario = safeArgs.usuario!!
        }

        carregaData()

        binding.buttonExcluirUsuario.setOnClickListener {

            DataManager.deletaUsuario(
                databaseHelper, usuario.id.toString()
            )

            findNavController()
                .navigate(R.id.action_detalhesUsuarioFragment_to_usuarioFragment)

        }
    }

    private fun carregaData() {
        binding.textViewName.text = usuario.name
        binding.textViewLocation.text = usuario.localization
        binding.textViewUrl.text = usuario.url
        Glide.with(this).load(usuario.url.toUri()).into(binding.imageViewUsuario)
    }
}