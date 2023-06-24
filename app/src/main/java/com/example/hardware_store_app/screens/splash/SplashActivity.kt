package com.example.hardware_store_app.screens.splash

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.bumptech.glide.Glide
import com.example.hardware_store_app.MainActivity
import com.example.hardware_store_app.R
import com.example.hardware_store_app.databinding.ActivitySplashBinding
import com.example.hardware_store_app.screens.register.RegistrationActivity
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class SplashActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySplashBinding
    private val viewModel by viewModels<SplashViewModel>()

    @Inject
    lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel.insertGoodsIntoDB()

        Glide.with(this).load(R.drawable.gif).into(binding.ivSplashVideo)

        val value = sharedPreferences.getBoolean(ACCOUNT_STATUS, false)

        lifecycleScope.launch {
            delay(2000L)
            if (value) {
                startActivity(Intent(this@SplashActivity, MainActivity::class.java))
            } else {
                startActivity(Intent(this@SplashActivity, RegistrationActivity::class.java))
            }
        }
    }

    companion object {
        const val ACCOUNT_STATUS = "account status"
    }
}