package com.hvn.usuario.di

import com.hvn.usuario.data.di.dataModulesUsuarios
import com.hvn.usuario.domain.di.domainUsuarioModule
import com.hvn.usuario.presentation.di.presentationUsuarioModule

val usuarioModule = (dataModulesUsuarios + domainUsuarioModule + presentationUsuarioModule)