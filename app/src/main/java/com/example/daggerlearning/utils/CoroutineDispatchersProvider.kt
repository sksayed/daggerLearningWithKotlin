package com.example.daggerlearning.utils

import kotlinx.coroutines.Dispatchers

open class CoroutineDispatcherProvider {

    open val io = Dispatchers.IO

    open val default = Dispatchers.Default

    open val main = Dispatchers.Main
}
