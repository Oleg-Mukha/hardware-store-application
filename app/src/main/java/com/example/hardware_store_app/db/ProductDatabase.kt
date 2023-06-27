package com.example.hardware_store_app.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.hardware_store_app.db.dao.CartDao
import com.example.hardware_store_app.db.dao.GoodsDao
import com.example.hardware_store_app.db.dao.LikeDao
import com.example.hardware_store_app.db.data.Cart
import com.example.hardware_store_app.db.data.Goods
import com.example.hardware_store_app.db.data.Like

@Database(entities = [Goods::class, Like::class, Cart::class], version = 3)
abstract class ProductDatabase : RoomDatabase() {
    abstract fun goodsDao(): GoodsDao
    abstract fun likeDao(): LikeDao
    abstract fun cartDao(): CartDao
}