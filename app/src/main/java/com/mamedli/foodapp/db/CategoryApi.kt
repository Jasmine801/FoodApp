package com.mamedli.foodapp.db

import retrofit2.http.GET
import retrofit2.http.Path

interface CategoryApi {
    @GET("categories/{id}")
    suspend fun getCategoryById(@Path("id") id : Int)
}