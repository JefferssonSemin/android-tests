package com.hvn.ci.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.net.toUri
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.bumptech.glide.Glide
import com.hvn.ci.databinding.UsuarioFragmentBinding
import dagger.hilt.android.AndroidEntryPoint
import java.net.URI

@AndroidEntryPoint
class UsuarioFragment : Fragment() {

    private val viewModel: UsuarioViewModel by viewModels()
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
            viewModel.buscaUsuario(nome)
            viewModel.usuario.observe(viewLifecycleOwner, Observer {
                val url = it.avatar_url.toUri()
                Glide.with(this).load(url).into(binding.imageViewUsuario)
                binding.textTextoCentral.text = it.name
            })
        }

        binding.buttonLimpar.setOnClickListener {
            binding.imageViewUsuario.setImageResource(0)
            binding.textTextoCentral.text = ""
            binding.editNovoTexto.setText("")
        }
    }
}
