package com.hvn.usuario.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hvn.usuario.data.remote.UsuarioData
import com.hvn.usuario.domain.entities.Usuario
import com.hvn.usuario.domain.interfaces.UsuarioUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class UsuarioViewModel(private val usuarioUseCase: UsuarioUseCase) : ViewModel() {

    private val _usuario = MutableLiveData<Usuario>()
    val usuario: LiveData<Usuario> = _usuario

    fun buscarUsuario(nome: String) {

        viewModelScope.launch {
            val response =
                withContext(Dispatchers.Default) {
                    usuarioUseCase.buscarUsuario(nome)
                }

            _usuario.value = mapUsuario(response)
        }

    }

    fun mapUsuario(usuarioData: UsuarioData): Usuario {
        return Usuario(
            usuarioData.name,
            usuarioData.url,
            usuarioData.avatar_url
        )
    }

}