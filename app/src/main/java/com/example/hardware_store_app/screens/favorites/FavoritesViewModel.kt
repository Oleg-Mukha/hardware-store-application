package com.example.hardware_store_app.screens.favorites

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.hardware_store_app.db.data.Goods
import com.example.hardware_store_app.db.repository.LocalProductRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject
@HiltViewModel
class FavoritesViewModel @Inject constructor(
    private val localProductRepository: LocalProductRepository
) : ViewModel() {

    val listOfLikedItems = MutableLiveData<List<Goods>>()
    private val favoritesList = mutableListOf<Goods>()

    fun getLikedItems() {
        viewModelScope.launch {
            localProductRepository.getAllLikeItems().forEach {
                favoritesList.add(localProductRepository.getProductById(it.idProduct))
            }
            listOfLikedItems.value = favoritesList
        }
    }
}