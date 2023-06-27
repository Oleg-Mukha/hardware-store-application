package com.example.hardware_store_app.di

import android.content.Context
import android.content.SharedPreferences
import android.preference.PreferenceManager
import androidx.room.Room
import com.example.hardware_store_app.db.ProductDatabase
import com.example.hardware_store_app.db.dao.CartDao
import com.example.hardware_store_app.db.dao.GoodsDao
import com.example.hardware_store_app.db.dao.LikeDao
import com.example.hardware_store_app.db.repository.LocalProductRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    fun provideDatabase(@ApplicationContext context: Context): ProductDatabase {
        return Room.databaseBuilder(
            context.applicationContext,
            ProductDatabase::class.java,
            LocalProductRepository.DATABASE_NAME
        ).fallbackToDestructiveMigration().build()
    }

    @Provides
    fun provideGoodsDao(productDatabase: ProductDatabase): GoodsDao {
        return productDatabase.goodsDao()
    }

    @Provides
    fun provideLikeDao(productDatabase: ProductDatabase): LikeDao {
        return productDatabase.likeDao()
    }

    @Provides
    fun provideCartDao(productDatabase: ProductDatabase): CartDao {
        return productDatabase.cartDao()
    }

    @Provides
    fun provideSharedPreferences(@ApplicationContext context: Context): SharedPreferences {
        return PreferenceManager.getDefaultSharedPreferences(context)
    }
}