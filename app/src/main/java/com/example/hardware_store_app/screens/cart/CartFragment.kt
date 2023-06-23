package com.example.hardware_store_app.screens.cart

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.hardware_store_app.OnItemClick
import com.example.hardware_store_app.R
import com.example.hardware_store_app.adapters.CartAdapter
import com.example.hardware_store_app.databinding.FragmentCartBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CartFragment : Fragment() {
    private lateinit var binding: FragmentCartBinding
    private val viewModel by viewModels<CartViewModel>()
    private lateinit var cartAdapter: CartAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCartBinding.inflate(inflater, container, false)

        viewModel.getProductsFromCart()

        initObservers()

        return binding.root
    }

    private fun initObservers() {
        cartAdapter = CartAdapter(mutableListOf(), object : OnItemClick {
            override fun onItemClick(id: String) {
                viewModel.deleteProductFromCart(id.toInt())
            }

        })

        binding.apply {
            viewModel.cartList.observe(viewLifecycleOwner) {
                var orderPrice = 0.0

                it.forEach { cart -> orderPrice += cart.price ?: 0.0 }
                tvCartPrice.text = "$${"%.2f".format(orderPrice)}"

                cartAdapter.updateList(it)
                rvCartItems.adapter = cartAdapter
                rvCartItems.layoutManager = LinearLayoutManager(requireContext())
            }
        }
    }
}