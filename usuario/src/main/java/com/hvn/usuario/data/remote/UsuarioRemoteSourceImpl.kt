package com.hvn.usuario.data.remote

import com.hvn.usuario.data.dataModels.ResponseData
import com.hvn.usuario.data.dataModels.UsuarioData
import retrofit2.Response
import java.lang.Exception

class UsuarioRemoteSourceImpl(private val usuarioService: UsuarioService) : UsuarioRemoteSource {

    override suspend fun buscarUsuario(nome: String): ResponseData<UsuarioData> {
        return try {
            val modelo = usuarioService.buscarUsuario(nome)
            ResponseData(
                modelo = modelo, sucesso = true
            )

        } catch (ex: Exception) {
            ResponseData(
                mensagem = "Não foi possível encontrar o usuário", modelo = null, sucesso = false
            )
        }
    }

}
