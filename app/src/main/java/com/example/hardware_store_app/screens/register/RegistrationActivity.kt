package com.example.hardware_store_app.screens.register

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.hardware_store_app.R
import com.example.hardware_store_app.databinding.ActivityRegistrationBinding
import com.example.hardware_store_app.screens.login.LoginActivity
import com.google.firebase.auth.FirebaseAuth
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RegistrationActivity : AppCompatActivity() {
    private lateinit var binding: ActivityRegistrationBinding
    private val auth = FirebaseAuth.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegistrationBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initViews()
    }

    private fun initViews() {
        binding.apply {
            btnRegister.setOnClickListener {
                val email = etRegisterEmail.text!!.toString()
                val password = etRegisterPassword.text!!.toString()
                auth.createUserWithEmailAndPassword(email, password).addOnCompleteListener {
                    if (it.isSuccessful) {
                        Toast.makeText(this@RegistrationActivity, "Account has been successfully created!", Toast.LENGTH_SHORT).show()
                        startActivity(Intent(this@RegistrationActivity, LoginActivity::class.java))
                    } else {
                        Log.w("FirebaseAuth", "Email/password sign up failed")
                    }
                }
            }

            btnSwitchToLogin.setOnClickListener{
                startActivity(Intent(this@RegistrationActivity, LoginActivity::class.java))
            }
        }
    }
}