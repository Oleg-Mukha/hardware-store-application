package com.example.hardware_store_app.screens.details

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.GridLayoutManager
import com.example.hardware_store_app.OnItemClick
import com.example.hardware_store_app.adapters.ProductAdapter
import com.example.hardware_store_app.databinding.FragmentDetailsBinding
import com.example.hardware_store_app.db.data.Like
import com.like.LikeButton
import com.like.OnLikeListener
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailsFragment : Fragment() {
    private lateinit var binding: FragmentDetailsBinding
    private val viewModel by viewModels<DetailsViewModel>()
    private val args by navArgs<DetailsFragmentArgs>()
    private lateinit var productAdapter: ProductAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentDetailsBinding.inflate(inflater, container, false)

        viewModel.getProductById(args.id)
        viewModel.isLiked(args.id)
        viewModel.getPopularList()

        binding.viewModel = viewModel
        binding.lifecycleOwner = this

        initObservers()

        return binding.root
    }

    private fun initObservers() {
        binding.apply {
            productAdapter = ProductAdapter(listOf(), object : OnItemClick {
                override fun onItemClick(id: String) {
                    findNavController().navigate(
                        DetailsFragmentDirections.actionDetailsFragmentSelf(id)
                    )
                }
            })

            viewModel!!.popularList.observe(viewLifecycleOwner) {
                productAdapter.updateList(it)
                rvProductPopularList.layoutManager = GridLayoutManager(requireContext(), 2)
                rvProductPopularList.adapter = productAdapter
            }

            btnAddToCart.setOnClickListener {
                Toast.makeText(
                    requireContext(),
                    "Product was successfully added to your cart!",
                    Toast.LENGTH_SHORT
                ).show()

                viewModel!!.addProductToCart()
            }

            ivProductCart.setOnClickListener {
                Toast.makeText(
                    requireContext(),
                    "Product was successfully added to your cart!",
                    Toast.LENGTH_SHORT
                ).show()

                viewModel!!.addProductToCart()
            }

            btnAddToFav.setOnLikeListener(object : OnLikeListener {
                override fun liked(likeButton: LikeButton?) {
                    viewModel!!.insertProduct(Like(args.id))
                }

                override fun unLiked(likeButton: LikeButton?) {
                    viewModel!!.deleteProduct(args.id)
                }
            })
        }
    }
}