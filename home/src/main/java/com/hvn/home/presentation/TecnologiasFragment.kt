package com.hvn.home.presentation

import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.hvn.home.databinding.TecnologiasFragmentBinding

class TecnologiasFragment : Fragment() {

    private lateinit var binding: TecnologiasFragmentBinding
    private lateinit var viewModel: TecnologiasViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = TecnologiasFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        arguments?.let {
            val safeArgs = TecnologiasFragmentArgs.fromBundle(it)
            val tec = safeArgs.tec
            binding.textViewTecnologias.text = tec.toString()
        }

        binding.buttonDetalhesTecnologias.setOnClickListener {
            val uri = Uri.parse("myApp://detalhesUsuarioFragment/23")
            findNavController().navigate(uri)
        }
    }

}