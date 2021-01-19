package com.hvn.usuario.domain.interfaces

import com.hvn.usuario.data.remote.UsuarioData

interface UsuarioUseCase {
    fun buscarUsuario(nome: String): UsuarioData
}