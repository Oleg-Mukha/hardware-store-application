package com.example.hardware_store_app.db.dao

import androidx.room.*
import com.example.hardware_store_app.db.data.Like

@Dao
interface LikeDao {
    @Query("SELECT * FROM likes")
    suspend fun getAllLikeItems(): List<Like>

    @Query("SELECT * FROM likes WHERE id=:id")
    suspend fun getLikeItem(id: String): Like?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertLikeItem(like: Like)

    @Query("DELETE FROM likes WHERE id=:id")
    suspend fun deleteLikeItem(id: String)
}