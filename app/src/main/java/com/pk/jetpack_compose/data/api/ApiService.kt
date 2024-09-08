package com.pk.jetpack_compose.data.api

import com.pk.jetpack_compose.data.model.Post
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {

    @GET("/posts")
    fun getPosts(): Call<List<Post>>
}

