package com.hvn.usuario.data.repositories

import com.hvn.usuario.data.remote.UsuarioData
import com.hvn.usuario.data.remote.UsuarioRemoteSource
import com.hvn.usuario.data.remote.UsuarioRemoteSourceImpl
import com.hvn.usuario.domain.interfaces.UsuarioRepository

class UsuarioRepositoryImpl(private val remoteSource: UsuarioRemoteSource) :
    UsuarioRepository {

    override fun buscarUsuario(nome: String) =
        remoteSource.buscarUsuario(nome)
}