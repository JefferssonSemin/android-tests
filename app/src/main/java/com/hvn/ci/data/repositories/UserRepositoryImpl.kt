package com.hvn.ci.data.repositories

import com.hvn.ci.data.remote.UserRemoteSource
import com.hvn.ci.domain.entities.Usuario
import com.hvn.ci.domain.repositories.UserRepository
import javax.inject.Inject

class UserRepositoryImpl @Inject constructor(
    private val remoteSource: UserRemoteSource
) : UserRepository {
    override suspend fun buscarDadosUsuario(nome: String): Usuario {
        return remoteSource.buscarDadosUsuario(nome)
    }
}