package com.hvn.ci.data.remote

import com.hvn.ci.domain.entities.Usuario

interface UserRemoteSource {
    suspend fun buscarDadosUsuario(nome: String): Usuario
}