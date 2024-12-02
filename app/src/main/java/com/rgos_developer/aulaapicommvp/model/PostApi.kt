package com.rgos_developer.aulaapicommvp.model

import com.rgos_developer.aulaapicommvp.api.RetrofitService
import retrofit2.Response

class PostApi {
    suspend fun getPosts() : List<Post> {
        val jsonPlace = RetrofitService.getJsonPlace()
        var res : Response<List<Post>>? = null

        try {
            res = jsonPlace.getPosts()

            if (res.isSuccessful){
                res.body()?.let{posts ->
                    return posts
                }
            }

        }catch (error: Exception) {
            error.printStackTrace()
        }

        return emptyList()
    }
}