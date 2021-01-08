package com.hvn.ci.ui.di

import com.hvn.ci.ui.UsuarioFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class FragmentModule {

    @ContributesAndroidInjector(modules = [(UsuarioModule::class)])
    abstract fun contributeMainFragment(): UsuarioFragment

}