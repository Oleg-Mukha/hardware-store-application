package com.example.hardware_store_app.screens.home

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.hardware_store_app.R
import com.example.hardware_store_app.data.Advert
import com.example.hardware_store_app.data.Product
import com.example.hardware_store_app.db.data.Goods
import com.example.hardware_store_app.db.repository.LocalProductRepository
import com.example.hardware_store_app.repositories.ProductRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject
@HiltViewModel
class HomeViewModel @Inject constructor(
    private val productRepository: ProductRepository,
    private val productLocalRepository: LocalProductRepository,
) : ViewModel() {

    val listOfAds = listOf(
        Advert(
            advertName = "Build, repair & paint",
            advertDescription = "Save up to 40% on building materials only in June!",
            advertImage = R.drawable.building
        ),
        Advert(
            advertName = "Free shipping",
            advertDescription = "Choose free shipping to your location",
            advertImage = R.drawable.truck
        ),
        Advert(
            advertName = "Save 5% with Google Pay",
            advertDescription = "Additional 5% discount with Google Pay",
            advertImage = R.drawable.googlepay
        ),
    )

    val listOfCategories = listOf(
        Product(name = "Building Materials", image = R.drawable.brick),
        Product(name = "Paints & Varnishes", image = R.drawable.paint),
        Product(name = "Electrical Goods", image = R.drawable.socket),
        Product(name = "Fasteners", image = R.drawable.bolt),
        Product(name = "Chemistry", image = R.drawable.chemicals),
        Product(name = "Mixtures", image = R.drawable.cement),
    )

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
    val popularList = MutableLiveData<List<Goods>>()
    fun getPopularList() {
        viewModelScope.launch {
            val list = productLocalRepository.getPopularProducts()
            popularList.value = list.shuffled().slice(0..1)
        }
    }
}
