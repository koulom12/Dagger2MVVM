package com.example.dagger2mvvm.repository

import androidx.lifecycle.LiveData
import com.example.dagger2mvvm.models.Product
import com.example.dagger2mvvm.retrofit.FakerAPI
import javax.inject.Inject

class ProductRepository @Inject constructor(val fakerAPI: FakerAPI) {

    suspend fun getProducts() : ArrayList<Product>? {
        val result = fakerAPI.getProducts()
        return if(result.isSuccessful && !result.body().isNullOrEmpty())
            result.body()
        else
            null
    }
}