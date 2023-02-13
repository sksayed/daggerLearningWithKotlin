package com.example.daggerlearning.data.pkg.model

import timber.log.Timber
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class EnglishUser @Inject constructor() :Person{
    init {
        Timber.d("English User is being created ")
    }
  override  fun speak( ) {
        Timber.d("I am speaking in English ")
    }
}