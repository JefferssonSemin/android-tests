package com.hvn.ci.util

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.hvn.ci.data.interfaceRepositories.UserRepository
import com.hvn.ci.data.repositories.UserRepositoryImpl
import com.hvn.ci.domain.entities.Usuario

class TodoTestRepository(private val nomes: ArrayList<Usuario>) : UserRepository {
    override suspend fun buscaUsuario(nome: String): Usuario? {
        TODO("Not yet implemented")
    }

    override fun buscaTodos(): LiveData<List<Usuario>> {
        return MutableLiveData(nomes)
    }

    override fun totalCount(): LiveData<Int> {
        val count = nomes.count()

        return MutableLiveData<Int>(count)
    }

}