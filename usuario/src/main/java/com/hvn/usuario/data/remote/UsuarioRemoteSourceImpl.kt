package com.hvn.usuario.data.remote

class UsuarioRemoteSourceImpl(private val usuarioService: UsuarioService) : UsuarioRemoteSource {

    override suspend fun buscarUsuario(nome: String) = usuarioService.buscarUsuario(nome)

}
