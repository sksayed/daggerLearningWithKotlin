package com.example.daggerlearning.data.pkg.api

import com.example.daggerlearning.data.pkg.model.User
import retrofit2.Response

interface ApiHelper {

    suspend fun getUsers(): Response<List<User>>
}