package com.example.hardware_store_app.screens.settings

import android.content.Intent
import android.content.SharedPreferences
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.example.hardware_store_app.MainActivity
import com.example.hardware_store_app.R
import com.example.hardware_store_app.databinding.FragmentSettingsBinding
import com.example.hardware_store_app.screens.register.RegistrationActivity
import com.example.hardware_store_app.screens.splash.SplashActivity
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class SettingsFragment : Fragment() {
    private lateinit var binding: FragmentSettingsBinding
    private lateinit var gso: GoogleSignInOptions
    private lateinit var client: GoogleSignInClient

    @Inject
    lateinit var sharedPreferences: SharedPreferences

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSettingsBinding.inflate(layoutInflater)

        initViews()

        return binding.root
    }

    private fun initViews() {
        binding.apply {
            gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken(getString(R.string.default_web_client_id))
                .requestEmail()
                .build()

            client = GoogleSignIn.getClient(requireActivity(), gso)

            val account = GoogleSignIn.getLastSignedInAccount(requireActivity())

            Glide.with(requireActivity()).load(account?.photoUrl).into(ivUserAvatar)
            tvUserName.text = account?.displayName
            tvUserEmail.text = account?.email

            btnUserLogout.setOnClickListener {
                client.signOut().addOnSuccessListener {
                    sharedPreferences.edit().putBoolean(SplashActivity.ACCOUNT_STATUS, false)
                        .apply()
                    startActivity(Intent(requireActivity(), RegistrationActivity::class.java))
                }
            }
        }
    }
}