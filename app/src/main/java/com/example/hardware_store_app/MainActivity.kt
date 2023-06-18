package com.example.hardware_store_app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.hardware_store_app.databinding.ActivityMainBinding
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var navController: NavController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupBottomNavigation()
    }

    private fun setupBottomNavigation() {
        binding.apply {
            val navHostFragment =
                supportFragmentManager.findFragmentById(R.id.nav_host_fragment_container) as NavHostFragment?
            navController = navHostFragment?.navController ?: throw NullPointerException()
            NavigationUI.setupWithNavController(bottomNavigation, navController)

            bottomNavigation.setOnItemSelectedListener {
                when (it.itemId) {
                    R.id.home_item -> {
                        navController.navigate(R.id.homeFragment)
                        true
                    }
                    R.id.favorites_item -> {
                        navController.navigate(R.id.favoritesFragment)
                        true
                    }
                    R.id.cart_item -> {
                        navController.navigate(R.id.cartFragment)
                        true
                    }
                    R.id.settings_item -> {
                        navController.navigate(R.id.settingsFragment)
                        true
                    }
                    else -> false
                }
            }
        }
    }
}