package com.hvn.usuario.data.remote

import com.hvn.usuario.data.dataModels.UsuarioData
import retrofit2.http.GET
import retrofit2.http.Path

interface UsuarioService {

    @GET("/users/{nome}")
    suspend fun buscarUsuario(@Path("nome") nome: String): UsuarioData
}