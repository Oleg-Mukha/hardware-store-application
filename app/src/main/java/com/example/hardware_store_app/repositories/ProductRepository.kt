package com.example.hardware_store_app.repositories

import com.example.hardware_store_app.R
import com.example.hardware_store_app.data.Product
import dagger.hilt.android.scopes.ViewModelScoped
import javax.inject.Inject

@ViewModelScoped
class ProductRepository @Inject constructor() {
    fun getList(): List<Product> {
        return listOf(
            Product(
                1,
                "Ceramic block",
                R.drawable.brick,
                12.5,
                "Building Materials",
                "Brick brick",
                5.0
            )
        )
    }
}