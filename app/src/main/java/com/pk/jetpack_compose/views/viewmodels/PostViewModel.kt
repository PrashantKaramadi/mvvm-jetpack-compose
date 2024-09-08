package com.pk.jetpack_compose.views.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.pk.jetpack_compose.data.model.Post
import com.pk.jetpack_compose.data.repository.PostRepository
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PostViewModel : ViewModel() {

    private var postRepository = PostRepository()

    var _posts = MutableLiveData<List<Post>>()

    var post: LiveData<List<Post>> = _posts

    init {
        getPosts()
    }

    private fun getPosts() {
        postRepository.getPosts().enqueue(object : Callback<List<Post>> {
            override fun onResponse(call: Call<List<Post>>, response: Response<List<Post>>) {
                if (response.isSuccessful)
                    _posts.value = response.body()
            }

            override fun onFailure(call: Call<List<Post>>, t: Throwable) {
                TODO("Not yet implemented")
            }

        })
    }
}