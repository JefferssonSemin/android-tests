package com.hvn.usuario.data.di

import com.hvn.usuario.data.remote.UsuarioRemoteSource
import com.hvn.usuario.data.remote.UsuarioRemoteSourceImpl
import com.hvn.usuario.data.remote.UsuarioService
import org.koin.dsl.module
import retrofit2.Retrofit

val dataRemoteModuleUsuario = module {

    single { createService(get()) }
    single<UsuarioRemoteSource> {
        UsuarioRemoteSourceImpl(
            usuarioService = get()
        )
    }
}

fun createService(retrofit: Retrofit): UsuarioService {
    return retrofit.create(UsuarioService::class.java)
}