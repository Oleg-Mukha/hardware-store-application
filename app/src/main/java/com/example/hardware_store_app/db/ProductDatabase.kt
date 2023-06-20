package com.example.hardware_store_app.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.hardware_store_app.db.dao.GoodsDao
import com.example.hardware_store_app.db.data.Cart
import com.example.hardware_store_app.db.data.Goods
import com.example.hardware_store_app.db.data.Like
import com.example.hardware_store_app.db.data.User

@Database(entities = [Goods::class, Like::class, Cart::class, User::class], version = 1)
abstract class ProductDatabase : RoomDatabase() {
    abstract fun goodsDao(): GoodsDao
}