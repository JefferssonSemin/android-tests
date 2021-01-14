package com.hvn.ci.util

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import usuario.data.interfaceRepositories.UserRepository
import com.hvn.ci.domain.entities.Usuario

class TodoTestRepository(private val nomes: ArrayList<com.hvn.ci.domain.entities.Usuario>) : UserRepository {
    override suspend fun buscaUsuario(nome: String): com.hvn.ci.domain.entities.Usuario? {
        TODO("Not yet implemented")
    }

    override fun buscaTodos(): LiveData<List<com.hvn.ci.domain.entities.Usuario>> {
        return MutableLiveData(nomes)
    }

    override fun totalCount(): LiveData<Int> {
        val count = nomes.count()

        return MutableLiveData<Int>(count)
    }

}