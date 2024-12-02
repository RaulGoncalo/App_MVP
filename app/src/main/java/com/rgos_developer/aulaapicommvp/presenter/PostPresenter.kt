package com.rgos_developer.aulaapicommvp.presenter

import android.util.Log
import com.rgos_developer.aulaapicommvp.api.RetrofitService
import com.rgos_developer.aulaapicommvp.model.Post
import com.rgos_developer.aulaapicommvp.model.PostApi
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.cancel
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.Response


class PostPresenter(
    private val view: IPostsPresenter,
    private val postApi: PostApi
) {

    private val coroutine = CoroutineScope(Dispatchers.IO)

    fun getPosts() {
        view.loading(true)
        coroutine.launch {
            val posts = postApi.getPosts()
            withContext(Dispatchers.Main){
                posts.forEach{
                    Log.i("teste_api", "${it.id}")
                }
                view.showPosts(posts)
                view.loading(false)
            }
        }

    }

    fun onDestroy(){
        coroutine.cancel()
    }
}