package com.example.hardware_store_app.screens.search

import android.content.Context
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.bumptech.glide.Glide
import com.example.hardware_store_app.OnItemClick
import com.example.hardware_store_app.R
import com.example.hardware_store_app.adapters.ProductAdapter
import com.example.hardware_store_app.databinding.FragmentSearchBinding
import com.example.hardware_store_app.screens.home.HomeFragmentDirections
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SearchFragment : Fragment() {
    private lateinit var binding: FragmentSearchBinding
    private val viewModel by viewModels<SearchViewModel>()
    private lateinit var productAdapter: ProductAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSearchBinding.inflate(layoutInflater)

        initObservers()

        return binding.root
    }

    private fun initObservers() {
        binding.apply {
            productAdapter = ProductAdapter(listOf(), object : OnItemClick {
                override fun onItemClick(id: String) {
                    findNavController().navigate(
                        SearchFragmentDirections.actionSearchFragmentToDetailsFragment(id)
                    )
                }
            })

            viewModel.searchList.observe(viewLifecycleOwner) {
                if (it.isEmpty()) {
                    rvSearchList.visibility = View.INVISIBLE
                    ivSearchGif.visibility = View.VISIBLE
                    tvSearchGuide.visibility = View.VISIBLE

                    Glide.with(requireActivity()).load(R.drawable.nothing_gif).into(ivSearchGif)
                    tvSearchGuide.text = "Nothing found for your request"
                } else {
                    ivSearchGif.visibility = View.INVISIBLE
                    tvSearchGuide.visibility = View.INVISIBLE

                    productAdapter.updateList(it)
                    rvSearchList.layoutManager = GridLayoutManager(requireContext(), 2)
                    rvSearchList.adapter = productAdapter
                }
            }

            Glide.with(requireActivity()).load(R.drawable.search_gif).into(ivSearchGif)

            ivSearch.setOnClickListener {
                ivSearchGif.visibility = View.INVISIBLE
                tvSearchGuide.visibility = View.INVISIBLE
                rvSearchList.visibility = View.VISIBLE

                val inputMethodManager =
                    requireContext().getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
                inputMethodManager.hideSoftInputFromWindow(view?.windowToken, 0)

                viewModel.getProductsByName(etSearch.text.toString())
            }
        }
    }
}