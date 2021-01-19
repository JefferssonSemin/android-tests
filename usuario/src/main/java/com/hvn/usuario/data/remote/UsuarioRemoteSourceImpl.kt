package com.hvn.usuario.data.remote

class UsuarioRemoteSourceImpl(private val usuarioService: UsuarioService): UsuarioRemoteSource {

    override fun buscarUsuario(nome: String): UsuarioData {
        return usuarioService.buscaUsuario(nome)
    }
}