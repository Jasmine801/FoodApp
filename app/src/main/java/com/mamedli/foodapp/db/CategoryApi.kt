package com.mamedli.foodapp.db


import com.mamedli.foodapp.entities.CategoryItem
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface CategoryApi {
    @GET("сategories")
    fun getCategories() : Call<CategoryItem>

    //suspend fun getCategoryById(@Path("id") id : Int)
}