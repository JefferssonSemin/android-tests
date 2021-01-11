package com.hvn.ci.ui

import UsuarioViewModel
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.hvn.ci.databinding.UsuarioFragmentBinding
import dagger.hilt.android.AndroidEntryPoint

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

        viewModel.buscaUsuario(binding.editNovoTexto.toString())
        viewModel.usuario.observe(viewLifecycleOwner, Observer {
            binding.editNovoTexto.setText(it.name)
        })
    }
}
