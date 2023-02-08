package com.example.daggerlearning.data.pkg.api

import com.example.daggerlearning.data.pkg.model.User
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {
    @GET("users")
    suspend fun getUsers():Response<List<User>>
}