package com.hvn.usuario.presentation

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.*
import data.repositories.UserRepositoryImpl
import domain.entities.Usuario
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import utils.validaUsuario

class UsuarioViewModel @ViewModelInject constructor(
    private val repository: UserRepositoryImpl
) : ViewModel() {

    private val _usuario = MutableLiveData<Usuario>()
    val usuario: LiveData<Usuario> = _usuario

    fun buscaTodos(): LiveData<List<Usuario>> {
        return repository.buscaTodos()
    }

    fun buscaUsuario(nome: String) {
        if (validaUsuario(nome)) {
            viewModelScope.launch {
                val response =
                    withContext(Dispatchers.Default) {
                        repository.buscaUsuario(nome)
                    }


                if (response != null)
                    _usuario.value = response
            }
        }
    }


}
