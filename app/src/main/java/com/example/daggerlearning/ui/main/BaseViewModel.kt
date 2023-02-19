package com.example.daggerlearning.ui.main

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import com.example.daggerlearning.utils.CoroutineDispatcherProvider
import kotlinx.coroutines.*
import kotlinx.coroutines.channels.BufferOverflow
import kotlinx.coroutines.flow.MutableSharedFlow
import timber.log.Timber
import java.util.concurrent.atomic.AtomicBoolean
import javax.inject.Inject
import kotlin.coroutines.CoroutineContext
import kotlin.coroutines.EmptyCoroutineContext

open class BaseViewModel(
    private val dispatcher: CoroutineDispatcherProvider,
    protected val context: Application
) :
    ViewModel() {

    private val viewModelJob = Job()

    private val exceptionHandler = CoroutineExceptionHandler { context, error ->
        showError(CorountineJobException(context, error))
    }

    private val caughtException = MutableSharedFlow<Throwable>(
        extraBufferCapacity = 1,
        onBufferOverflow = BufferOverflow.DROP_OLDEST
    )

    open fun showError(t: Throwable) {
        caughtException.tryEmit(t)
    }

    private val ioScope =
        CoroutineScope(dispatcher.io + viewModelJob + exceptionHandler)


    protected val ioJobContext = ioScope.coroutineContext

    fun launchJob(
        name: String? = null,
        block: suspend CoroutineScope.() -> Unit
    ): Job {
        return ioScope.launch(EmptyCoroutineContext, CoroutineStart.DEFAULT, block).apply {
            name?.let { plus(CoroutineName(it)) }
            invokeOnCompletion {
                completeJob()
            }

        }

    }

    private val cancelJobOnCompletion = AtomicBoolean(false)

    private fun completeJob() {
        if (cancelJobOnCompletion.get()) {
            Timber.d("completeJob(): Cancelling view model job [$viewModelJob, $this]")
            cancelViewModelJob()
        }
    }

    private fun cancelViewModelJob() {
        viewModelJob.cancel()
    }

    override fun onCleared() {
        super.onCleared()
        Timber.d("onCleared() [$viewModelJob, $this]")
        if (viewModelJob.isActive) {
            cancelJobOnCompletion.set(true)
        } else {
            Timber.d("onCleared(): Cancelling view model job [$viewModelJob, $this]")
            cancelViewModelJob()
        }
    }


}

private class CorountineJobException(private val context: CoroutineContext, cause: Throwable) :
    RuntimeException(cause) {

    override val message: String
        get() = "${context[CoroutineName.Key]}: ${cause?.message}"
}