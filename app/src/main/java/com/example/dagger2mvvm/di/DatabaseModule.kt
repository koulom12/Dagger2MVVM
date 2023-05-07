package com.example.dagger2mvvm.di

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.dagger2mvvm.db.ProductDB
import com.example.dagger2mvvm.models.Product
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DatabaseModule {

    @Singleton
    @Provides
    fun getProductDB(context: Context) : ProductDB {
        return Room.databaseBuilder(context, ProductDB::class.java, "ProductDB").build()
    }
}