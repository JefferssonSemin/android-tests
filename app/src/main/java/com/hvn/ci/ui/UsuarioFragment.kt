package com.hvn.ci.ui

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.hvn.ci.R
import javax.inject.Inject

class UsuarioFragment : BaseFragment<UsuarioViewModel>() {
    @Inject
    lateinit var factory: UsuarioViewModel.Factory

    override val viewModel: UsuarioViewModel by viewModels(factoryProducer = { factory })
    override val layout: Int = R.layout.activity_main

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.substituiValor()

        viewModel.usuario.observe(viewLifecycleOwner, Observer {
            val usuario = it
        })
    }


}
