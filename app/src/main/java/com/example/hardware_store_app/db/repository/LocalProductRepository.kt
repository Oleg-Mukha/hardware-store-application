package com.example.hardware_store_app.db.repository

import com.example.hardware_store_app.db.dao.GoodsDao
import com.example.hardware_store_app.db.data.Goods
import javax.inject.Inject

class LocalProductRepository @Inject constructor(var goodsDao: GoodsDao) {
    companion object {
        const val DATABASE_NAME = "ProductDB"
    }

    suspend fun getPopularProducts(): List<Goods> = goodsDao.getPopularProducts()
    suspend fun getAllProducts(): List<Goods> = goodsDao.getAllProducts()
    suspend fun getProductById(id: String): Goods = goodsDao.getProductById(id)
    suspend fun getProductByName(name: String): List<Goods> = goodsDao.getProductsByName(name)
    suspend fun getProductsByCategory(category: String): List<Goods> = goodsDao.getProductsByCategory(category)
    suspend fun insertProductIntoDB(goods: Goods) = goodsDao.insertProductIntoDB(goods)
}