package com.example.dagger2mvvm.repository

import com.example.dagger2mvvm.db.ProductDB
import com.example.dagger2mvvm.models.Product
import com.example.dagger2mvvm.retrofit.FakerAPI
import javax.inject.Inject

class ProductRepository @Inject constructor(private val fakerAPI: FakerAPI, private val productDB: ProductDB) {

    suspend fun getProducts() : ArrayList<Product>? {
        val result = fakerAPI.getProducts()
        return if(result.isSuccessful && !result.body().isNullOrEmpty()) {
            productDB.getProductDao().addProducts(result.body() as List<Product>)
            result.body()
        }
        else
            null
    }
}