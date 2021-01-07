package com.hvn.ci.ui.app

import android.app.Activity
import android.app.Application
import android.app.Service
import android.content.Context
import androidx.fragment.app.Fragment
import com.hvn.ci.data.di.CoreComponent
import com.hvn.ci.data.di.DaggerCoreComponent

class CiApplication : Application() {
    private val coreComponent: CoreComponent by lazy {
        DaggerCoreComponent.create()
    }

    companion object {
        lateinit var appContext: Context

        @JvmStatic
        fun coreComponent(context: Context) =
            (context.applicationContext as CiApplication).coreComponent
    }
}

fun Activity.coreComponent() = CiApplication.coreComponent(this)
fun Fragment.coreComponent() = CiApplication.coreComponent(requireContext())
fun Service.coreComponent() = CiApplication.coreComponent(this)