package com.hvn.usuario.domain.interfaces

import com.hvn.usuario.data.dataModels.ResponseData
import com.hvn.usuario.data.dataModels.UsuarioData

interface UsuarioUseCase {
    suspend fun buscarUsuario(nome: String): ResponseData<UsuarioData>
}