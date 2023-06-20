package com.example.hardware_store_app.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.hardware_store_app.db.data.Goods

@Dao
interface GoodsDao {
    @Query("SELECT * FROM goods WHERE rate = 5")
    suspend fun getPopularProducts(): List<Goods>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertProductIntoDB(goods: Goods)

}