package com.example.hardware_store_app.db.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "likes")
data class Like(
    @PrimaryKey(autoGenerate = false)
    @ColumnInfo(name = "id")
    val idProduct: String
)