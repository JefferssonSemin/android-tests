package com.hvn.usuario.data.remote

import com.hvn.usuario.data.dataModels.ResponseData
import com.hvn.usuario.data.dataModels.UsuarioData

interface UsuarioRemoteSource {

    suspend fun buscarUsuario(nome: String): ResponseData<UsuarioData>
}