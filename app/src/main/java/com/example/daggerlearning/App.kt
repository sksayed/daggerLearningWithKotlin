package com.example.daggerlearning

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class App : Application() {
    companion object {
       const val BASE_URL = "\"https://5e510330f2c0d300147c034c.mockapi.io/\""
    }
}