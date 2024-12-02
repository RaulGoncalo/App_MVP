package com.rgos_developer.aulaapicommvp.api

import com.rgos_developer.aulaapicommvp.model.Post
import retrofit2.Response
import retrofit2.http.GET

interface JsonPlaceApi {

    @GET("posts")
    suspend fun getPosts() : Response<List<Post>>
}