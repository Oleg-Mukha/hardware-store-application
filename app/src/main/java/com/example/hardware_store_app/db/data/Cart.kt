package com.example.hardware_store_app.db.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "cart")
data class Cart(
    @PrimaryKey(autoGenerate = false)
    @ColumnInfo(name = "id") val productId: Int? = 0,
    val name: String? = null,
    val image: Int? = null,
    val price: Double? = null,
    val category: String? = null
)
