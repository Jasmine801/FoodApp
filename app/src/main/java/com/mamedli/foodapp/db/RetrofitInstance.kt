package com.mamedli.foodapp.db

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {
    val api : CategoryApi by lazy {
        Retrofit.Builder()
            .baseUrl("https://run.mocky.io/v3/058729bd-1402-4578-88de-265481fd7d54/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(CategoryApi::class.java)
    }
}