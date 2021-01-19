package com.hvn.usuario.data.di

import com.hvn.usuario.data.repositories.UsuarioRepositoryImpl
import com.hvn.usuario.domain.interfaces.UsuarioRepository
import org.koin.dsl.module

val repositoryModule = module {
    single<UsuarioRepository> {
        UsuarioRepositoryImpl(
            remoteSource = get()
        )
    }
}

val dataModulesUsuarios =
    listOf(dataRemoteModuleUsuario, repositoryModule)