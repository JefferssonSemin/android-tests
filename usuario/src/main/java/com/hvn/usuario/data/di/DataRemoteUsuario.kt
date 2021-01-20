package com.hvn.usuario.data.di

import com.hvn.usuario.data.remote.UsuarioRemoteSource
import com.hvn.usuario.data.remote.UsuarioRemoteSourceImpl
import com.hvn.usuario.data.remote.UsuarioService
import okhttp3.OkHttpClient
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

val dataRemoteModuleUsuario = module {

    factory { providesOkHttpClient() }

    single {
        createWebService<UsuarioService>(
            okHttpClient = get()
        )
    }

    single<UsuarioRemoteSource> {
        UsuarioRemoteSourceImpl(
            usuarioService = get()
        )
    }
}

fun providesOkHttpClient(): OkHttpClient {
    return OkHttpClient.Builder()
        .connectTimeout(30, TimeUnit.SECONDS)
        .readTimeout(30, TimeUnit.SECONDS)
        .writeTimeout(30, TimeUnit.SECONDS)
        .build()
}

inline fun <reified T> createWebService(okHttpClient: OkHttpClient): T {
    return Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .baseUrl("https://api.github.com")
        .client(okHttpClient)
        .build()
        .create(T::class.java)
}