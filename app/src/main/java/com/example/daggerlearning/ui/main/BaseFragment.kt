package com.example.daggerlearning.ui.main

import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.CoroutineStart
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

open class BaseFragment : Fragment() {

    val viewStateJob = Job()

    protected fun launchInViewLifeCycle(block: suspend CoroutineScope.() -> Unit) {
        lifecycleScope.launch(viewStateJob ,  CoroutineStart.DEFAULT , block )
    }


    override fun onDestroyView() {
        viewStateJob.cancel()
        super.onDestroyView()
    }
}