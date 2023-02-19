package com.example.daggerlearning.data.pkg.api

import com.example.daggerlearning.data.pkg.model.Post
import com.example.daggerlearning.data.pkg.model.User
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {
    @GET("users")
    suspend fun getUsers(): Response<List<User>>

    @GET("posts/{id}")
    suspend fun getPostAsync(@Path("id") postID: Int): Post
}