package com.hvn.ci.data.repositories

import com.hvn.ci.data.remote.UserRemoteDataSource
import javax.inject.Inject

class UserRepositoryImpl @Inject constructor(
    private val remoteSource: UserRemoteDataSource
) {

    suspend fun buscaUsuario(nome: String) {
        remoteSource.buscaUsuario(nome)
    }
}