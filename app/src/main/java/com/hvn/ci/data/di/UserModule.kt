package com.hvn.ci.data.di

import com.hvn.ci.data.remote.UserRemoteSource
import com.hvn.ci.data.remote.UserRemoteSourceImpl
import com.hvn.ci.data.repositories.UserRepositoryImpl
import com.hvn.ci.domain.repositories.UserRepository
import dagger.Binds
import dagger.Module

@Module
abstract class UserModule {

    @Binds
    abstract fun providerUserRepository(userRepositoryImpl: UserRepositoryImpl): UserRepository

    @Binds
    abstract fun providerUserRemoteSource(userRemoteSourceImpl: UserRemoteSourceImpl): UserRemoteSource
}