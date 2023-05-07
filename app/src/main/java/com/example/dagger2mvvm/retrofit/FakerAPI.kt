package com.example.dagger2mvvm.retrofit

import com.example.dagger2mvvm.models.Product
import retrofit2.Response
import retrofit2.http.GET

interface FakerAPI {

    @GET("products")
    suspend fun getProducts() : Response<ArrayList<Product>>
}