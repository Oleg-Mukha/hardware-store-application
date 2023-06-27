package com.example.hardware_store_app.screens.details

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.hardware_store_app.db.data.Cart
import com.example.hardware_store_app.db.data.Goods
import com.example.hardware_store_app.db.data.Like
import com.example.hardware_store_app.db.repository.LocalProductRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailsViewModel @Inject constructor(
    private val productLocalRepository: LocalProductRepository
) : ViewModel() {

    val productItem = MutableLiveData<Goods>()
    val isLikedItem = MutableLiveData<Boolean>()
    val popularList = MutableLiveData<List<Goods>>()

    fun getProductById(id: String) {
        viewModelScope.launch {
            productItem.value = productLocalRepository.getProductById(id)
        }
    }

    fun isLiked(id: String) {
        viewModelScope.launch {
            isLikedItem.value = productLocalRepository.isLiked(id)
        }
    }

    fun insertProduct(like: Like) {
        viewModelScope.launch {
            productLocalRepository.insertLikeItem(like)
        }
    }

    fun deleteProduct(id: String) {
        viewModelScope.launch {
            productLocalRepository.deleteLikeItem(id)
        }
    }

    fun addProductToCart() {
        val cart = Cart(
            productItem.value?.id,
            productItem.value?.name,
            productItem.value?.image,
            productItem.value?.price,
            productItem.value?.category
        )
        viewModelScope.launch {
            productLocalRepository.addProductToCart(cart)
        }
    }

    fun getPopularList() {
        viewModelScope.launch {
            val list = productLocalRepository.getPopularProducts()
            popularList.value = list.shuffled().slice(0..1)
        }
    }
}