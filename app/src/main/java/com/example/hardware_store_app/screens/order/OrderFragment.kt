package com.example.hardware_store_app.screens.order

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import com.example.hardware_store_app.R
import com.example.hardware_store_app.databinding.FragmentOrderBinding
import com.example.hardware_store_app.screens.cart.CartFragmentDirections
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class OrderFragment : Fragment() {

    private lateinit var binding: FragmentOrderBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentOrderBinding.inflate(layoutInflater)

        initViews()

        return binding.root
    }

    private fun initViews() {
        binding.apply {
            Glide.with(requireActivity()).load(R.drawable.order_gif).into(ivOrderGif)

            lifecycleScope.launch {
                delay(6000L)
                findNavController().navigate(
                    OrderFragmentDirections.actionOrderFragmentToHomeFragment()
                )
            }
        }
    }
}