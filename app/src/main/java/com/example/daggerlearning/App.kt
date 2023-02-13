package com.example.daggerlearning

import android.app.Application
import dagger.hilt.android.HiltAndroidApp
import timber.log.Timber

@HiltAndroidApp
class App : Application() {
    companion object {
       const val BASE_URL = "\"https://5e510330f2c0d300147c034c.mockapi.io/\""
        const val BASE_URL_TYPECODE = "https://jsonplaceholder.typicode.com"
    }

    override fun onCreate() {
        super.onCreate()
        if(BuildConfig.DEBUG) {
            Timber.plant( Timber.DebugTree())
        }
    }
}