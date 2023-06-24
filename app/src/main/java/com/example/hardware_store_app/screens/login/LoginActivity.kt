package com.example.hardware_store_app.screens.login

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import com.example.hardware_store_app.MainActivity
import com.example.hardware_store_app.R
import com.example.hardware_store_app.databinding.ActivityLoginBinding
import com.example.hardware_store_app.screens.splash.SplashActivity
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.api.ApiException
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.GoogleAuthProvider
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding
    private val auth = FirebaseAuth.getInstance()
    private lateinit var gso: GoogleSignInOptions
    private lateinit var client: GoogleSignInClient

    @Inject
    lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initViews()
    }

    private fun initViews() {
        gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestIdToken(getString(R.string.default_web_client_id))
            .requestEmail()
            .build()

        client = GoogleSignIn.getClient(this@LoginActivity, gso)

        binding.apply {
            val signInWithLoginAndPassword =
                registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
                    val email = etLoginEmail.text!!.toString()
                    val password = etLoginPassword.text!!.toString()

                    auth.signInWithEmailAndPassword(email, password)
                        .addOnCompleteListener(this@LoginActivity) {
                            checkAuthorization(it)
                        }
                }

            val signInWithGoogle =
                registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
                    val task = GoogleSignIn.getSignedInAccountFromIntent(result.data)
                    val account = task.getResult(ApiException::class.java)!!
                    val credential = GoogleAuthProvider.getCredential(account.idToken, null)

                    auth.signInWithCredential(credential)
                        .addOnCompleteListener(this@LoginActivity) {
                            checkAuthorization(it)
                        }
                }

            btnLogin.setOnClickListener {
                signInWithLoginAndPassword.launch(client.signInIntent)
            }

            btnGoogle.setOnClickListener {
                signInWithGoogle.launch(client.signInIntent)
            }
        }
    }

    private fun checkAuthorization(it: Task<AuthResult>) {
        if (it.isSuccessful) {
            sharedPreferences.edit().putBoolean(SplashActivity.ACCOUNT_STATUS, true).apply()
            Toast.makeText(this@LoginActivity, "Authorization successfully!", Toast.LENGTH_SHORT)
                .show()
            startActivity(Intent(this@LoginActivity, MainActivity::class.java))
            finish()
        } else {
            Log.w("Authentication", "Sign-in failed")
        }
    }
}