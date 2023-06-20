package com.example.hardware_store_app.db.repository

import com.example.hardware_store_app.db.dao.GoodsDao
import com.example.hardware_store_app.db.data.Goods
import javax.inject.Inject

class LocalProductRepository @Inject constructor(var goodsDao: GoodsDao) {
    companion object {
        const val DATABASE_NAME = "ProductDB"
    }

    suspend fun getPopularProducts(): List<Goods> = goodsDao.getPopularProducts()

    suspend fun insertProductIntoDB(goods: Goods) = goodsDao.insertProductIntoDB(goods)
}