package com.example.hardware_store_app.screens.cart

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.hardware_store_app.db.data.Cart
import com.example.hardware_store_app.db.repository.LocalProductRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CartViewModel @Inject constructor(
    private val localProductRepository: LocalProductRepository
) : ViewModel() {
    val cartList = MutableLiveData<MutableList<Cart>>()

    fun getProductsFromCart() {
        viewModelScope.launch {
            cartList.value = localProductRepository.getProductsFromCart()
        }
    }

    fun deleteProductFromCart(id: Int) {
        viewModelScope.launch {
            localProductRepository.deleteProductFromCart(id)
        }
    }

    fun deleteAllProductsFromCart(){
        viewModelScope.launch {
            localProductRepository.deleteAllProductsFromCart()
        }
    }
}