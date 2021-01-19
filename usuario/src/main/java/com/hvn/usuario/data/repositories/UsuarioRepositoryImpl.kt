package com.hvn.usuario.data.repositories

import com.hvn.usuario.data.remote.UsuarioRemoteSourceImpl
import com.hvn.usuario.domain.interfaces.UsuarioRepository

class UsuarioRepositoryImpl(private val usuarioRemoteSource: UsuarioRemoteSourceImpl) :
    UsuarioRepository {

    override fun buscarUsuario(nome: String) =
        usuarioRemoteSource.buscarUsuario(nome)
}