package com.hvn.usuario.domain.usecase

import com.hvn.usuario.domain.interfaces.UsuarioRepository
import com.hvn.usuario.domain.interfaces.UsuarioUseCase

class UsuarioUseCaseImpl(private val usuarioRepository: UsuarioRepository) : UsuarioUseCase {
    override suspend fun buscarUsuario(nome: String) = usuarioRepository.buscarUsuario(nome)
}