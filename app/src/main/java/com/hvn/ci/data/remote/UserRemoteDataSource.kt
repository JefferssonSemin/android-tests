package com.hvn.ci.data.remote

import javax.inject.Inject

class UserRemoteDataSource @Inject constructor(
    private val userService: UserService
) : BaseDataSource() {

    suspend fun buscaUsuario(nome: String) = getResult { userService.buscaUsuario(nome) }
}
