package com.hvn.ci.data.repositories

import androidx.lifecycle.LiveData
import com.hvn.ci.data.interfaceRepositories.UserRepository
import com.hvn.ci.data.remote.UserRemoteDataSource
import com.hvn.ci.domain.entities.Usuario
import javax.inject.Inject

class UserRepositoryImpl @Inject constructor(
    private val remoteSource: UserRemoteDataSource
) : UserRepository {

    override suspend fun buscaUsuario(nome: String): Usuario? {
        return remoteSource.buscaUsuario(nome).data
    }

    override fun buscaTodos(): LiveData<List<Usuario>> {
        TODO("Not yet implemented")
    }

    override fun totalCount(): LiveData<Int> {
        TODO("Not yet implemented")
    }
}