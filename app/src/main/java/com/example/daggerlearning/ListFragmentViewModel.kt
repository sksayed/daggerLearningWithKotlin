package com.example.daggerlearning

import android.app.Application
import android.view.View
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.daggerlearning.ui.main.BaseViewModel
import com.example.daggerlearning.utils.CoroutineDispatcherProvider
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ListFragmentViewModel @Inject constructor(
    dispatcherProvider: CoroutineDispatcherProvider,
    context: Application
) : BaseViewModel(dispatcherProvider, context) {

    private val _progressShowing: MutableLiveData<Boolean> = MutableLiveData<Boolean>(false)
    val progressShowing: LiveData<Boolean> = _progressShowing
    fun button2ClickListener(view: View) {
        _progressShowing.postValue(true)
    }
}