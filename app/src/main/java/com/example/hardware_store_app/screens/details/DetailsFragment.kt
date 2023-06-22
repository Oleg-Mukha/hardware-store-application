package com.example.hardware_store_app.screens.details

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
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

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentDetailsBinding.inflate(inflater, container, false)

        viewModel.getProductById(args.id)
        viewModel.isLiked(args.id)

        binding.viewModel = viewModel
        binding.lifecycleOwner = this

        binding.btnAddToFav.setOnLikeListener(object : OnLikeListener {
            override fun liked(likeButton: LikeButton?) {
                viewModel.insertProduct(Like(args.id))
            }

            override fun unLiked(likeButton: LikeButton?) {
                viewModel.deleteProduct(args.id)
            }
        })

        binding.btnAddToCart.setOnClickListener {
            viewModel.addProductToCart()
        }

        return binding.root
    }
}