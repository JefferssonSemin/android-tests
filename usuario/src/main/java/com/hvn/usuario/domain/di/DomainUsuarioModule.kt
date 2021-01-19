package com.hvn.usuario.domain.di

import com.hvn.usuario.domain.interfaces.UsuarioUseCase
import com.hvn.usuario.domain.usecase.UsuarioUseCaseImpl
import org.koin.dsl.module


val useCasePreVenda = module {
    single<UsuarioUseCase> {
        UsuarioUseCaseImpl(
            usuarioRepository = get()
        )
    }
}

val domainUsuarioModule = listOf(useCasePreVenda)