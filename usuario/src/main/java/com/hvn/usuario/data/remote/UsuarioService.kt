package com.hvn.usuario.data.remote

import retrofit2.http.GET

interface UsuarioService {

    @GET("user/{nome}")
    fun buscaUsuario(nome: String): UsuarioData
}