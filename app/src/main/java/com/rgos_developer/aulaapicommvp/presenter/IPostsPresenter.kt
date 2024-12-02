package com.rgos_developer.aulaapicommvp.presenter

import com.rgos_developer.aulaapicommvp.model.Post

interface IPostsPresenter {
    fun showPosts(list: List<Post>)
    fun loading(isLoading: Boolean)
}