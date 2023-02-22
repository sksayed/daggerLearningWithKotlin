package com.example.daggerlearning.extensions

import android.view.View
import androidx.databinding.BindingAdapter


@BindingAdapter("showIf")
fun View.showIf(condition: Boolean) {
    this.visibility = if (condition) {
        View.VISIBLE
    }else {
        View.GONE
    }
}