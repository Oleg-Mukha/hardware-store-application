package com.example.hardware_store_app.db.repository

import com.example.hardware_store_app.db.dao.CartDao
import com.example.hardware_store_app.db.dao.GoodsDao
import com.example.hardware_store_app.db.dao.LikeDao
import com.example.hardware_store_app.db.data.Cart
import com.example.hardware_store_app.db.data.Goods
import com.example.hardware_store_app.db.data.Like
import javax.inject.Inject

class LocalProductRepository @Inject constructor(
    var goodsDao: GoodsDao,
    var likeDao: LikeDao,
    var cartDao: CartDao
) {
    companion object {
        const val DATABASE_NAME = "ProductDB"
    }

    // GoodsDao
    suspend fun getPopularProducts(): List<Goods> = goodsDao.getPopularProducts()
    suspend fun getAllProducts(): List<Goods> = goodsDao.getAllProducts()
    suspend fun getProductById(id: String): Goods = goodsDao.getProductById(id)
    suspend fun getProductByName(name: String): List<Goods> = goodsDao.getProductsByName(name)
    suspend fun getProductsByCategory(category: String): List<Goods> = goodsDao.getProductsByCategory(category)
    suspend fun insertProductIntoDB(goods: Goods) = goodsDao.insertProductIntoDB(goods)

    // LikeDao
    suspend fun getAllLikeItems(): List<Like> = likeDao.getAllLikeItems()
    suspend fun isLiked(id: String): Boolean {
        return likeDao.getLikeItem(id) != null
    }

    suspend fun insertLikeItem(like: Like) = likeDao.insertLikeItem(like)
    suspend fun deleteLikeItem(id: String) = likeDao.deleteLikeItem(id)

    // CartDao
    suspend fun addProductToCart(cart: Cart) = cartDao.addProductToCart(cart)
    suspend fun getProductsFromCart(): MutableList<Cart> = cartDao.getProductsFromCart()
    suspend fun deleteProductFromCart(id: Int) = cartDao.deleteProductFromCart(id)
    suspend fun deleteAllProductsFromCart() = cartDao.deleteAllProductsFromCart()
}