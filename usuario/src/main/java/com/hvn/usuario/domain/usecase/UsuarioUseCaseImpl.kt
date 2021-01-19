package com.hvn.usuario.domain.usecase

import com.hvn.usuario.data.remote.UsuarioData
import com.hvn.usuario.domain.interfaces.UsuarioRepository
import com.hvn.usuario.domain.interfaces.UsuarioUseCase

class UsuarioUseCaseImpl(private val repo: UsuarioRepository) : UsuarioUseCase {
    override fun buscarUsuario(nome: String): UsuarioData {
        return repo.buscarUsuario(nome)
    }
}