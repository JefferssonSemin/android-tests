package com.hvn.usuario.domain.usecase

import com.hvn.usuario.data.remote.UsuarioData
import com.hvn.usuario.domain.interfaces.UsuarioRepository
import com.hvn.usuario.domain.interfaces.UsuarioUseCase
import io.reactivex.Single

class UsuarioUseCaseImpl(private val usuarioRepository: UsuarioRepository) : UsuarioUseCase {
    override fun buscarUsuario(nome: String): UsuarioData = usuarioRepository.buscarUsuario(nome)
}