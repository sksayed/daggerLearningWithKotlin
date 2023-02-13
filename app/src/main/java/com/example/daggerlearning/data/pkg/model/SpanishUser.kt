package com.example.daggerlearning.data.pkg.model

import timber.log.Timber
import javax.inject.Inject

class SpanishUser @Inject constructor ():Person {
    init {
        Timber.d("Spanish User Being Created ")
    }

   override fun speak() {
        Timber.d("I am speaking spanish")
    }
}