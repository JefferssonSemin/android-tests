package com.hvn.ci.di

import android.content.Context
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.hvn.ci.data.remote.UserRemoteDataSource
import com.hvn.ci.data.remote.UserService
import com.hvn.ci.data.repositories.UserRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideRetrofit(gson: Gson): Retrofit = Retrofit.Builder()
        .baseUrl("https://api.github.com/")
        .addConverterFactory(GsonConverterFactory.create(gson))
        .build()

    @Provides
    fun provideGson(): Gson = GsonBuilder().create()

    @Provides
    fun provideCharacterService(retrofit: Retrofit): UserService =
        retrofit.create(UserService::class.java)

    @Singleton
    @Provides
    fun provideCharacterRemoteDataSource(userService: UserService) =
        UserRemoteDataSource(userService)

    @Singleton
    @Provides
    fun provideRepository(userRemoteDataSource: UserRemoteDataSource) =
        UserRepositoryImpl(userRemoteDataSource)
}