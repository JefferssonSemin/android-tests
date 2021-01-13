package com.hvn.ci.data.interfaceRepositories

import androidx.lifecycle.LiveData
import com.hvn.ci.domain.entities.Usuario

interface UserRepository {
    suspend fun buscaUsuario(nome: String): Usuario?
    fun buscaTodos(): LiveData<List<Usuario>>
    fun totalCount(): LiveData<Int>
}