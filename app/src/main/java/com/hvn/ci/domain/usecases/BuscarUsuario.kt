package com.hvn.ci.domain.usecases

import com.hvn.ci.domain.repositories.UserRepository
import javax.inject.Inject

class BuscarUsuario @Inject constructor(
    private val userRepository: UserRepository
) {
    suspend operator fun invoke(nome: String) = userRepository.buscarDadosUsuario(nome)
}