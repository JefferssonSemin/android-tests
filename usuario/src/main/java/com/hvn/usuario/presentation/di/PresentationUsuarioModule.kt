package com.hvn.usuario.presentation.di

import com.hvn.usuario.presentation.viewModels.UsuarioViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModels = module {
    viewModel { UsuarioViewModel(usuarioUseCase = get()) }
}

val presentationUsuarioModule = listOf(viewModels)

