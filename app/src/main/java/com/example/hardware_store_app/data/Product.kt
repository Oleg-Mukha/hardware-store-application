package com.example.hardware_store_app.data

data class Product(
    val id: Int? = 0,
    val name: String? = null,
    val image: Int? = null,
    val price: Double? = null,
    val category: String? = null,
    val description: String? = null,
    val rate: Double? = null
)