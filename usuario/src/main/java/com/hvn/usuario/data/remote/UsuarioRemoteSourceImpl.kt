package com.hvn.usuario.data.remote

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class UsuarioRemoteSourceImpl(private val usuarioService: UsuarioService) : UsuarioRemoteSource {

    override fun buscarUsuario(nome: String): UsuarioData {
        CoroutineScope(Dispatchers.IO).launch {

            val response = usuarioService.buscarUsuario(nome)
            val data = response
        }
        return UsuarioData("", "aaaa", "", "")
    }
}
