package com.hvn.ci.data

import com.hvn.ci.domain.entities.Usuario
import retrofit2.http.GET
import retrofit2.http.Path

interface UserApi {

    @GET("user/{nome}")
    suspend fun buscarDadosUsuario(@Path("nome") nome: String): Usuario
}