package com.example.hardware_store_app.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.hardware_store_app.db.data.Goods

@Dao
interface GoodsDao {
    @Query("SELECT * FROM goods WHERE rate >= 4.8")
    suspend fun getPopularProducts(): List<Goods>

    @Query("SELECT * FROM goods")
    suspend fun getAllProducts(): List<Goods>

    @Query("SELECT * FROM goods WHERE id=:id")
    suspend fun getProductById(id: String): Goods

    @Query("SELECT * FROM goods WHERE name LIKE '%' || :name  || '%'")
    suspend fun getProductsByName(name: String): List<Goods>

    @Query("SELECT * FROM goods WHERE category=:category")
    suspend fun getProductsByCategory(category: String): List<Goods>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertProductIntoDB(goods: Goods)

}