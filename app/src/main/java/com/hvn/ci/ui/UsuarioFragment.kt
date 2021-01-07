package com.hvn.ci.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.hvn.ci.R
import com.hvn.ci.databinding.UsuarioFragmentBinding
import javax.inject.Inject

class UsuarioFragment : BaseFragment<UsuarioViewModel>() {

    private lateinit var binding: UsuarioFragmentBinding

    @Inject
    lateinit var factory: UsuarioViewModel.Factory

    override val viewModel: UsuarioViewModel by viewModels(factoryProducer = { factory })
    override val layout: Int = R.layout.activity_main

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = UsuarioFragmentBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }
}
