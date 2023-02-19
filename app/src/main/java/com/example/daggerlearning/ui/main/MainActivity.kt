package com.example.daggerlearning.ui.main

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.lifecycleScope
import androidx.navigation.Navigation
import com.example.daggerlearning.R
import com.example.daggerlearning.data.pkg.api.ApiService
import com.example.daggerlearning.data.pkg.model.BengaliUser
import com.example.daggerlearning.data.pkg.model.Person
import com.example.daggerlearning.databinding.ActivityMainBinding
import com.example.daggerlearning.di.module.EnglishUserQualifier
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
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


    private lateinit var binding: ActivityMainBinding
   /* by lazy {

      //Keep an eye on this and make sure it works
      *//*  DataBindingUtil.setContentView(
            this,
            R.layout.activity_main
        )*//*

        ActivityMainBinding.inflate(layoutInflater)
    }*/

    private val navController by lazy {
        Navigation.findNavController(findViewById(R.id.nav_host_fragment_container))
    }
    @SuppressLint("SuspiciousIndentation")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

//        spanishUser.speak()
//        bengaliUser.speak()
//
//        lifecycleScope.launch(Dispatchers.IO){
//              val post =  apiService.getPostAsync(15)
//                println("Post Message is ")
//                println(post)
//
//
//        }

    }
}