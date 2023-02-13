package com.example.daggerlearning.data.pkg.api

import com.example.daggerlearning.data.pkg.model.Post
import com.example.daggerlearning.data.pkg.model.User
import retrofit2.Response
import javax.inject.Inject
import javax.inject.Named

class ApiHelperImpl @Inject constructor(@Named() private val apiService: ApiService):ApiHelper{

    override suspend fun getUsers(): Response<List<User>> = apiService.getUsers()
    override suspend fun getPost(postId: Int): Post {
        return apiService.getPost(postId)
    }

}