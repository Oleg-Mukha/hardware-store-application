package com.example.hardware_store_app.screens.list

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.hardware_store_app.db.data.Goods
import com.example.hardware_store_app.db.repository.LocalProductRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ListViewModel @Inject constructor(
    private val productLocalRepository: LocalProductRepository
) : ViewModel() {

    val productList = MutableLiveData<List<Goods>>()

    fun getAllProducts() {
        viewModelScope.launch {
            productList.value = productLocalRepository.getAllProducts()
        }
    }

    fun getProductsByCategory(category: String){
        viewModelScope.launch {
            productList.value = productLocalRepository.getProductsByCategory(category)
        }
    }

    fun getProductByName(name: String) {
        viewModelScope.launch {
            productList.value = productLocalRepository.getProductByName(name)
        }
    }
}