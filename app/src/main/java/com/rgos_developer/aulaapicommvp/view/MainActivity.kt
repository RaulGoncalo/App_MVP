package com.rgos_developer.aulaapicommvp.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.rgos_developer.aulaapicommvp.R
import com.rgos_developer.aulaapicommvp.databinding.ActivityMainBinding
import com.rgos_developer.aulaapicommvp.model.Post
import com.rgos_developer.aulaapicommvp.model.PostApi
import com.rgos_developer.aulaapicommvp.presenter.IPostsPresenter
import com.rgos_developer.aulaapicommvp.presenter.PostPresenter

class MainActivity : AppCompatActivity(), IPostsPresenter {

    private val binding: ActivityMainBinding by lazy{
        ActivityMainBinding.inflate(layoutInflater)
    }

    private lateinit var postPresenter: PostPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val postApi = PostApi()
        postPresenter = PostPresenter(this, postApi)
    }

    override fun onStart() {
        super.onStart()
        postPresenter.getPosts()
    }

    override fun onDestroy() {
        super.onDestroy()
        postPresenter.onDestroy()
    }

    override fun showPosts(posts: List<Post>) {
        var text = ""
        posts.forEach {post ->
            text += "(${post.id}) - ${post.title}\n"

        }
        binding.textLista.text = text
    }

    override fun loading(isLoading: Boolean) {
        if(isLoading){
            binding.progressBar.visibility = View.VISIBLE
        }else{
            binding.progressBar.visibility = View.GONE
        }
    }

}