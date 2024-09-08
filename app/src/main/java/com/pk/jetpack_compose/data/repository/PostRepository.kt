package com.pk.jetpack_compose.data.repository

import com.pk.jetpack_compose.data.api.RetrofitInstance
import com.pk.jetpack_compose.data.model.Post
import retrofit2.Call

class PostRepository {

    private var apiService = RetrofitInstance.apiService

    fun getPosts(): Call<List<Post>> {
        return apiService.getPosts()
    }
}