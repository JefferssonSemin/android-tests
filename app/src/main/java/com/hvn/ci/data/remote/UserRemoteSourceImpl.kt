package com.hvn.ci.data.remote

import com.hvn.ci.data.BaseApi
import com.hvn.ci.data.UserApi
import com.hvn.ci.domain.entities.Usuario
import javax.inject.Inject

class UserRemoteSourceImpl @Inject constructor() : BaseApi<UserApi>(
    UserApi::class.java
), UserRemoteSource {
    override suspend fun buscarDadosUsuario(nome: String): Usuario {
        return api.buscarDadosUsuario(nome)
    }
}
