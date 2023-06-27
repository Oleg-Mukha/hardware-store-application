package com.example.hardware_store_app.screens.cart

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.example.hardware_store_app.OnItemClick
import com.example.hardware_store_app.R
import com.example.hardware_store_app.adapters.CartAdapter
import com.example.hardware_store_app.databinding.FragmentCartBinding
import com.example.hardware_store_app.screens.favorites.FavoritesFragmentDirections
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
        var orderPrice = 0.0
        binding.apply {
            cartAdapter = CartAdapter(mutableListOf(), object : OnItemClick {
                override fun onItemClick(id: String) {
                    viewModel.deleteProductFromCart(id.toInt())
                }
            })

            viewModel.cartList.observe(viewLifecycleOwner) {

                it.forEach { cart -> orderPrice += cart.price ?: 0.0 }
                tvCartPrice.text = "₴${"%.2f".format(orderPrice)}"

                if (it.isEmpty()) {
                    Glide.with(requireActivity()).load(R.drawable.cart_gif).into(ivCartGif)
                    ivCartGif.visibility = View.VISIBLE
                    tvCartGuide.visibility = View.VISIBLE
                    dividerCart1.visibility = View.INVISIBLE
                    tvCartTotal.visibility = View.INVISIBLE
                    tvCartPrice.visibility = View.INVISIBLE
                    tvCartShipping.visibility = View.INVISIBLE
                    btnCreateOrder.visibility = View.INVISIBLE
                } else {
                    cartAdapter.updateList(it)
                    rvCartItems.adapter = cartAdapter
                    rvCartItems.layoutManager = LinearLayoutManager(requireContext())
                }
            }

            btnCreateOrder.setOnClickListener {

                viewModel.deleteAllProductsFromCart()

                findNavController().navigate(
                    CartFragmentDirections.actionCartFragmentToOrderFragment()
                )
            }
        }
    }
}