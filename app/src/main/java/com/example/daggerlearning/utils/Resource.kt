package com.example.daggerlearning.utils

data class Resource<out T>(val status: Status, val message: String?, val data: T?) {

    companion object {
        //this is a generic static method which takes an arg as T types
        fun <T> success(data: T?): Resource<T> {
            return Resource(Status.Success, null, data)
        }

        fun <T> error(message: String? , data : T?): Resource<T> {
            return Resource(Status.Error, message!!, data)
        }

        fun <T> loading(data: T?): Resource<T> {
            return Resource(Status.Loading , null , data)
        }
    }

}