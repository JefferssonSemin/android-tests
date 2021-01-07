package com.hvn.ci.ui.di

import com.hvn.ci.domain.usecases.BuscarUsuario
import com.hvn.ci.ui.UsuarioViewModel
import dagger.Module
import dagger.Provides

/**
 * Copyright 2019, Kurt Renzo Acosta, All rights reserved.
 *
 * @author Kurt Renzo Acosta
 * @since 08/13/2019
 */
@Module
class UsuarioModule(private val nome : String) {
    @Provides
    fun provideUsuarioViewModelFactory(
        buscarUsuario: BuscarUsuario
    ) = UsuarioViewModel.Factory(nome, buscarUsuario)
}
