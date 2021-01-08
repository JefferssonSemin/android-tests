package com.hvn.ci.app.di

import com.hvn.ci.app.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivitiesModule {
    @ContributesAndroidInjector(modules = [(MainActivityModule::class)])
    abstract fun contributeActivityAndroidInjector(): MainActivity
}