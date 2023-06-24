package com.example.hardware_store_app.screens.search

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.hardware_store_app.db.data.Goods
import com.example.hardware_store_app.db.repository.LocalProductRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SearchViewModel @Inject constructor(
    private val localProductRepository: LocalProductRepository
) : ViewModel() {
    val searchList = MutableLiveData<List<Goods>>()

    fun getProductsByName(productName: String){
        viewModelScope.launch {
            searchList.value = localProductRepository.getProductByName(productName)
        }
    }
}