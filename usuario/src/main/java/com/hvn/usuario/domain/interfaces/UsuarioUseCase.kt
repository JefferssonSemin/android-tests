package com.hvn.usuario.domain.interfaces

import com.hvn.usuario.data.remote.UsuarioData
import io.reactivex.Single

interface UsuarioUseCase {
    fun buscarUsuario(nome: String): UsuarioData
}