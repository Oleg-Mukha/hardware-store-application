package com.example.hardware_store_app.screens.details

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.hardware_store_app.db.data.Goods
import com.example.hardware_store_app.db.repository.LocalProductRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailsViewModel @Inject constructor(
    private val productLocalRepository: LocalProductRepository
) : ViewModel() {

    val productItem = MutableLiveData<Goods>()

    fun getProductById(id: String) {
        viewModelScope.launch {
            productItem.value = productLocalRepository.getProductById(id)
        }
    }
    val product = Goods(
        productItem.value?.id,
        productItem.value?.name,
        productItem.value?.price?.toInt()
    )
}