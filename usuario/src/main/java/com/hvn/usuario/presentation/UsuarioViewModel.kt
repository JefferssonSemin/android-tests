package com.hvn.usuario.presentation

import androidx.lifecycle.ViewModel
import com.hvn.usuario.data.remote.UsuarioData
import com.hvn.usuario.domain.interfaces.UsuarioUseCase

class UsuarioViewModel(private val usuarioUseCase: UsuarioUseCase) : ViewModel() {

    fun buscarUsuario(nome: String): UsuarioData {
        return usuarioUseCase.buscarUsuario(nome)

    }
}