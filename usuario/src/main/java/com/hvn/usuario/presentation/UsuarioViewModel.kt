package com.hvn.usuario.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hvn.usuario.data.dataModels.ResponseData
import com.hvn.usuario.data.dataModels.UsuarioData
import com.hvn.usuario.data.room.DatabaseHelper
import com.hvn.usuario.domain.entities.Usuario
import com.hvn.usuario.domain.interfaces.UsuarioUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class UsuarioViewModel(private val usuarioUseCase: UsuarioUseCase) : ViewModel() {

    private val _usuario = MutableLiveData<ResponseData<UsuarioData>>()
    val usuario: LiveData<ResponseData<UsuarioData>> = _usuario



    fun buscarUsuario(nome: String) {

        viewModelScope.launch {
            val response =
                withContext(Dispatchers.Default) {
                    usuarioUseCase.buscarUsuario(nome)
                }

            _usuario.value = response
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