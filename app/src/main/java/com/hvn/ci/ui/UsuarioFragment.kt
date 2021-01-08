package com.hvn.ci.ui

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.hvn.ci.R
import com.hvn.ci.databinding.UsuarioFragmentBinding
import com.hvn.ci.app.coreComponent
import com.hvn.ci.ui.di.DaggerUsuarioComponent
import com.hvn.ci.ui.di.UsuarioModule
import dagger.android.support.AndroidSupportInjection
import javax.inject.Inject

class UsuarioFragment(override val viewModel: UsuarioViewModel, override val layout: Int) : BaseFragment<UsuarioViewModel>() {

    private lateinit var binding: UsuarioFragmentBinding

    @Inject
    lateinit var usuarioViewModel: UsuarioViewModel

    override fun onAttach(context: Context) {
        AndroidSupportInjection.inject(this)
        super.onAttach(context)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {


        binding = UsuarioFragmentBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        usuarioViewModel.substituiValor()
    }
}
