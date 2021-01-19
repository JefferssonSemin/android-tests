package com.hvn.ci.app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.appcompat.widget.Toolbar
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.hvn.ci.R


class MainActivity : AppCompatActivity() {
    private val appBarConfiguration: AppBarConfiguration by lazy {
        AppBarConfiguration.Builder(
            setOf(
                R.id.homeFragment,
                R.id.usuarioFragment
            )
        ).build()
    }


    private val navController: NavController by lazy { findNavController(R.id.fragment_nav_host) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val tlbMain = findViewById<Toolbar>(R.id.tlb_main)
        setSupportActionBar(tlbMain)

        val btmNavMain = findViewById<BottomNavigationView>(R.id.btm_nav_main)

        btmNavMain.setupWithNavController(navController)
        setupActionBarWithNavController(navController, appBarConfiguration)

        navController.addOnDestinationChangedListener { _, destination, _ ->
            when (destination.id) {
                R.id.homeFragment, R.id.usuarioFragment -> btmNavMain.visibility =
                    View.VISIBLE
                else -> btmNavMain.visibility = View.GONE
            }
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp() || super.onSupportNavigateUp()
    }
}