package com.example.hardware_store_app.screens.splash

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.hardware_store_app.db.data.Goods
import com.example.hardware_store_app.db.repository.LocalProductRepository
import com.example.hardware_store_app.repositories.ProductRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SplashViewModel @Inject constructor(
    private val productRepository: ProductRepository,
    private val productLocalRepository: LocalProductRepository,
) : ViewModel() {

    fun insertGoodsIntoDB() {
        viewModelScope.launch {
            productRepository.getList().forEach {
                productLocalRepository.insertProductIntoDB(
                    Goods(
                        it.id,
                        it.name,
                        it.image,
                        it.price,
                        it.category,
                        it.description,
                        it.rate
                    )
                )
            }
        }
    }

}