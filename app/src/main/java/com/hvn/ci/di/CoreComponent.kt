package com.hvn.ci.di

import com.hvn.ci.data.remote.UserRemoteSource
import com.hvn.ci.domain.repositories.UserRepository
import dagger.Component

/**
 * Copyright 2019, Kurt Renzo Acosta, All rights reserved.
 *
 * @author Kurt Renzo Acosta
 * @since 08/06/2019
 */
@Component(modules = [UserModule::class])
interface CoreComponent {
    fun providerUserRepository(): UserRepository
    fun providerUserRemoteSource(): UserRemoteSource
}