package com.hvn.ci.data.repositories

import androidx.lifecycle.LiveData
import com.hvn.ci.data.remote.UserRemoteDataSource
import com.hvn.ci.domain.entities.Usuario
import javax.inject.Inject

class UserRepositoryImpl @Inject constructor(
    private val remoteSource: UserRemoteDataSource
) {

    suspend fun buscaUsuario(nome: String): Usuario? {
        return remoteSource.buscaUsuario(nome).data
    }

    fun buscaTodos(): LiveData<List<Usuario>> {
        TODO("Not yet implemented")
    }

    fun totalCount(): LiveData<Int> {
        TODO("Not yet implemented")
    }
}