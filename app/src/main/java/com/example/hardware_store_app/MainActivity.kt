package com.example.hardware_store_app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.hardware_store_app.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    private fun setBottomNavigation() {
        binding.apply {
            val bottomNavigationView = binding.bottomNavigation
            bottomNavigationView.setOnItemSelectedListener { menuItem ->
                when (menuItem.itemId) {
                    R.id.home_item -> {
                        true
                    }
                    R.id.favorites_item -> {
                        true
                    }
                    R.id.cart_item -> {
                        true
                    }
                    R.id.settings_item -> {
                        true
                    }
                    else -> false
                }
            }

        }
    }
}