package com.hvn.usuario.data.remote

import com.hvn.usuario.domain.entities.Usuario

interface UsuarioRemoteSource {

    suspend fun buscarUsuario(nome: String): UsuarioData
}