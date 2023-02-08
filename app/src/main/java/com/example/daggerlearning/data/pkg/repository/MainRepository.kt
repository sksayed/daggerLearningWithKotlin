package com.example.daggerlearning.data.pkg.repository

import com.example.daggerlearning.data.pkg.api.ApiHelper
import javax.inject.Inject

class MainRepository @Inject constructor(private val apiHelper: ApiHelper) {
    suspend fun getUsers() = apiHelper.getUsers()
}