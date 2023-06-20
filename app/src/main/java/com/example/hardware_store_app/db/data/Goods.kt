package com.example.hardware_store_app.db.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "goods")
data class Goods(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id") val id: Int? = 0,
    val name: String? = null,
    val image: Int? = null,
    val price: Double? = null,
    val category: String? = null,
    val description: String? = null,
    val rate: Double? = null
)
