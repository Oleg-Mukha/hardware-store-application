package com.example.hardware_store_app.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.hardware_store_app.db.data.Cart

@Dao
interface CartDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addProductToCart(cart: Cart)

    @Query("SELECT * FROM cart")
    suspend fun getProductsFromCart(): MutableList<Cart>

    @Query("DELETE FROM cart WHERE id=:id")
    suspend fun deleteProductFromCart(id: Int)

    @Query("DELETE FROM cart")
    suspend fun deleteAllProductsFromCart()
}