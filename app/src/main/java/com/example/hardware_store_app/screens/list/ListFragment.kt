package com.example.hardware_store_app.screens.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.GridLayoutManager
import com.example.hardware_store_app.OnItemClick
import com.example.hardware_store_app.adapters.ProductAdapter
import com.example.hardware_store_app.databinding.FragmentListBinding
import com.example.hardware_store_app.screens.home.HomeFragmentDirections
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ListFragment : Fragment() {
    private lateinit var binding: FragmentListBinding
    private val viewModel by viewModels<ListViewModel>()
    private val args by navArgs<ListFragmentArgs>()
    private lateinit var productAdapter: ProductAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentListBinding.inflate(inflater, container, false)

        if (args.category == "all") {
            binding.tvListName.text = "all products"
            viewModel.getAllProducts()
        } else {
            binding.tvListName.text = args.category
            viewModel.getProductsByCategory(args.category)
        }

        initObservers()

        return binding.root
    }

    private fun initObservers() {
        productAdapter = ProductAdapter(listOf(), object : OnItemClick {
            override fun onItemClick(id: String) {
                findNavController().navigate(
                    ListFragmentDirections.actionListFragmentToDetailsFragment(id)
                )
            }
        })
        binding.apply {
            viewModel.productList.observe(viewLifecycleOwner) {
                productAdapter.updateList(it)
                rvProductList.layoutManager = GridLayoutManager(requireContext(), 2)
                rvProductList.adapter = productAdapter
            }

            ivBtnSearch.setOnClickListener {
                findNavController().navigate(
                    ListFragmentDirections.actionListFragmentToSearchFragment()
                )
            }
        }
    }
}