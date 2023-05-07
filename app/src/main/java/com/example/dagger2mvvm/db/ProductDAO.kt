package com.example.dagger2mvvm.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Query
import com.example.dagger2mvvm.models.Product

@Dao
interface ProductDAO {

    @Insert(onConflict = REPLACE)
    suspend fun addProducts(products: List<Product>)

    @Query("SELECT * FROM Product")
    suspend fun getProducts() : List<Product>
}