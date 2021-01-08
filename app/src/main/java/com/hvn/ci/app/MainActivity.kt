package com.hvn.ci.app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.findNavController
import com.hvn.ci.R
import com.hvn.ci.ui.UsuarioFragment
import dagger.android.AndroidInjection
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.support.HasSupportFragmentInjector
import javax.inject.Inject


abstract class MainActivity : AppCompatActivity(), HasSupportFragmentInjector {

    private val navController: NavController by lazy { findNavController(R.id.fragment_nav_host) }

    @Inject
    lateinit var dispatchingAndroidInjector: DispatchingAndroidInjector<Fragment>

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        navController.addOnDestinationChangedListener { _, destination, _ ->
            when (destination.id) {
                R.id.usuarioFragment -> UsuarioFragment()
            }
        }
    }

    override fun supportFragmentInjector() = dispatchingAndroidInjector

}