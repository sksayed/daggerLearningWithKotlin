package com.example.daggerlearning.data.pkg.model

import timber.log.Timber
import javax.inject.Inject

class BengaliUser @Inject constructor(val englishUser: EnglishUser) {
    fun speak() {
        Timber.d("Bengali Person Talking")
    }
}