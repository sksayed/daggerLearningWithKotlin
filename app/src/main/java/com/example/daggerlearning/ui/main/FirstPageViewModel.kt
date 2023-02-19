package com.example.daggerlearning.ui.main

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ServiceLifecycleDispatcher
import androidx.lifecycle.ViewModel
import com.example.daggerlearning.data.pkg.api.ApiService
import com.example.daggerlearning.data.pkg.model.Post
import com.example.daggerlearning.utils.CoroutineDispatcherProvider
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

@HiltViewModel
class FirstPageViewModel @Inject constructor(
    dispatcher: CoroutineDispatcherProvider,
    context: Application ,
    apiService: ApiService
) : BaseViewModel(
    dispatcher,
    context
) {
    val firstText =  "This is from ViewModel"

   private var _postData = MutableLiveData<Post> ()
   val postLiveData : LiveData<Post> = _postData

    val testFlow : Flow<Post> = flow {
        val result = apiService.getPostAsync(13)
        _postData.postValue(result)
        this.emit(result)
    }.flowOn(dispatcher.default)

     fun buttonClick () = testFlow



}