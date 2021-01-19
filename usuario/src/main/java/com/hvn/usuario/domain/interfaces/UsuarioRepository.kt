package com.hvn.usuario.domain.interfaces

import com.hvn.usuario.data.remote.UsuarioData

interface UsuarioRepository {

   suspend fun buscarUsuario(nome: String): UsuarioData

}