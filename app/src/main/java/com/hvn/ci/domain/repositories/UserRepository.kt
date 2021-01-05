package com.hvn.ci.domain.repositories

import com.hvn.ci.domain.entities.Usuario

interface UserRepository {
    suspend fun buscarDadosUsuario(nome: String): Usuario
}