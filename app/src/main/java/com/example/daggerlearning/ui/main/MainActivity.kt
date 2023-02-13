package com.example.daggerlearning.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.daggerlearning.R
import com.example.daggerlearning.data.pkg.api.ApiService
import com.example.daggerlearning.data.pkg.model.BengaliUser
import com.example.daggerlearning.data.pkg.model.EnglishUser
import com.example.daggerlearning.data.pkg.model.Person
import com.example.daggerlearning.data.pkg.model.SpanishUser
import com.example.daggerlearning.di.module.EnglishUserQualifier
import com.example.daggerlearning.di.module.SpanishUserQualifier
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {


    @EnglishUserQualifier
    @Inject
    lateinit var spanishUser: Person

    @Inject
    lateinit var bengaliUser: BengaliUser

    @Inject
    lateinit var apiService: ApiService
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        spanishUser.speak()
        bengaliUser.speak()

        runBlocking{
            launch {
              val post =  apiService.getPost(15)
                println("Post Message is ")
                println(post)

            }
        }

    }
}