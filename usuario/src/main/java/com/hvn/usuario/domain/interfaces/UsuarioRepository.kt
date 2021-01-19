package com.hvn.usuario.domain.interfaces

import com.hvn.usuario.data.dataModels.ResponseData
import com.hvn.usuario.data.dataModels.UsuarioData

interface UsuarioRepository {

    suspend fun buscarUsuario(nome: String): ResponseData<UsuarioData>

}