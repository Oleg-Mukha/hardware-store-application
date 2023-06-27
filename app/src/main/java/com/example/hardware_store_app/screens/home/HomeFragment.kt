package com.example.hardware_store_app.screens.home

import android.os.Bundle
import android.os.Handler
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.hardware_store_app.ActionHandler
import com.example.hardware_store_app.OnItemClick
import com.example.hardware_store_app.R
import com.example.hardware_store_app.adapters.AdvertAdapter
import com.example.hardware_store_app.adapters.CategoryAdapter
import com.example.hardware_store_app.adapters.ProductAdapter
import com.example.hardware_store_app.databinding.FragmentHomeBinding
import com.example.hardware_store_app.db.data.Goods
import dagger.hilt.android.AndroidEntryPoint
import java.util.*

@AndroidEntryPoint
class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding
    private val viewModel by viewModels<HomeViewModel>()
    private lateinit var advertAdapter: AdvertAdapter
    private lateinit var categoryAdapter: CategoryAdapter
    private lateinit var productAdapter: ProductAdapter

    private val timer = Timer()
    private val handler = Handler()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(inflater, container, false)

        viewModel.getPopularList()
        initObservers()

        return binding.root
    }

    private fun initObservers() {
        binding.apply {
            productAdapter = ProductAdapter(listOf(), object : OnItemClick {
                override fun onItemClick(id: String) {
                    findNavController().navigate(
                        HomeFragmentDirections.actionHomeFragmentToDetailsFragment(id)
                    )
                }
            })

            advertAdapter = AdvertAdapter(viewModel.listOfAds)
            val advertLayoutManager = LinearLayoutManager(requireContext(), RecyclerView.HORIZONTAL, false)
            rvAdverts.layoutManager = advertLayoutManager
            rvAdverts.adapter = advertAdapter

            startAutoScroll(advertLayoutManager, advertAdapter, rvAdverts)

            categoryAdapter = CategoryAdapter(viewModel.listOfCategories, object : ActionHandler {
                override fun onCategoryClick(category: String) {
                    findNavController().navigate(
                        HomeFragmentDirections.actionHomeFragmentToListFragment(category)
                    )
                }
            })

            rvCategories.layoutManager =
                LinearLayoutManager(requireContext(), RecyclerView.HORIZONTAL, false)
            rvCategories.adapter = categoryAdapter

            viewModel.popularList.observe(viewLifecycleOwner) {
                productAdapter.updateList(it)
                rvPopular.layoutManager = GridLayoutManager(requireContext(), 2)
                rvPopular.adapter = productAdapter


                tvViewAll.setOnClickListener {
                    findNavController().navigate(
                        HomeFragmentDirections.actionHomeFragmentToListFragment("all")
                    )
                }
            }
        }
    }

    private fun startAutoScroll(layoutManager: LinearLayoutManager, adapter: AdvertAdapter, recyclerView: RecyclerView) {
        timer.scheduleAtFixedRate(object : TimerTask() {
            override fun run() {
                handler.post {
                    val currentPosition = layoutManager.findFirstVisibleItemPosition()
                    val nextPosition =
                        if (currentPosition == adapter.itemCount - 1) 0 else currentPosition + 1
                    recyclerView.smoothScrollToPosition(nextPosition)
                }
            }
        }, 3000L, 3000L)
    }

}