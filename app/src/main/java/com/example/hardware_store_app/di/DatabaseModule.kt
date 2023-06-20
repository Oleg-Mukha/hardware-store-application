package com.example.hardware_store_app.di

import android.content.Context
import androidx.room.Room
import com.example.hardware_store_app.db.ProductDatabase
import com.example.hardware_store_app.db.dao.GoodsDao
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
    fun provideFoodDao(foodDatabase: ProductDatabase): GoodsDao {
        return foodDatabase.goodsDao()
    }
}