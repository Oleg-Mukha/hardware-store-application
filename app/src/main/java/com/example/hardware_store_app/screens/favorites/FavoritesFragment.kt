package com.example.hardware_store_app.screens.favorites

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.example.hardware_store_app.OnItemClick
import com.example.hardware_store_app.R
import com.example.hardware_store_app.adapters.ProductAdapter
import com.example.hardware_store_app.databinding.FragmentFavoritesBinding
import com.example.hardware_store_app.databinding.FragmentHomeBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FavoritesFragment : Fragment() {
    private lateinit var binding: FragmentFavoritesBinding
    private val viewModel by viewModels<FavoritesViewModel>()
    private lateinit var productAdapter: ProductAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentFavoritesBinding.inflate(inflater, container, false)

        viewModel.getLikedItems()

        initObservers()

        return binding.root
    }

    private fun initObservers() {
        binding.apply {
            productAdapter = ProductAdapter(listOf(), object : OnItemClick {
                override fun onItemClick(id: String) {
                    findNavController().navigate(
                        FavoritesFragmentDirections.actionFavoritesFragmentToDetailsFragment(id)
                    )
                }
            })

            viewModel.listOfLikedItems.observe(viewLifecycleOwner) {
                productAdapter.updateList(it)
                rvLikes.layoutManager = GridLayoutManager(requireContext(), 2)
                rvLikes.adapter = productAdapter
            }

        }
    }

}