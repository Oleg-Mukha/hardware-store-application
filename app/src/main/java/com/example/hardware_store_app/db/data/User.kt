package com.example.hardware_store_app.db.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "users")
data class User(
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0,
    val email: String? = null,
    val password: String? = null
)
