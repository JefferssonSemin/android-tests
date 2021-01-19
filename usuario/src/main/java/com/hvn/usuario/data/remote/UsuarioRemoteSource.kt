package com.hvn.usuario.data.remote

interface UsuarioRemoteSource {
    fun buscarUsuario(nome: String): UsuarioData
}