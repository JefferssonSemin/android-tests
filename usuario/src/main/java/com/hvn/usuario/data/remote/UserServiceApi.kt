package com.hvn.usuario.data.remote

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class UserServiceApi {

    fun getUsuarioService(): UsuarioService {

        val retrofit = Retrofit.Builder()
            .baseUrl("https://api.github.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        return retrofit.create(UsuarioService::class.java)
    }
}