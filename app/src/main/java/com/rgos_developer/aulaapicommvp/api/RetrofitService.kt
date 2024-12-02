package com.rgos_developer.aulaapicommvp.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

object RetrofitService {

    fun getJsonPlace(): JsonPlaceApi {
        return  Retrofit.Builder()
            .baseUrl("https://jsonplaceholder.typicode.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(JsonPlaceApi::class.java)
    }
}