package com.hvn.ci.data.di

import com.hvn.ci.data.remote.UserRemoteSource
import com.hvn.ci.domain.repositories.UserRepository
import dagger.Component

@Component(modules = [UserModule::class])
interface CoreComponent {
    fun userRepository(): UserRepository
    fun UserRemoteSource(): UserRemoteSource
}