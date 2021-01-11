package com.hvn.ci.data.remote

import com.hvn.ci.domain.entities.Usuario
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface UserService {
    @GET("usuario/{nome}")
    suspend fun buscaUsuario(@Path("nome") nome: String): Response<Usuario>
}