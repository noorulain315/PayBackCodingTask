package com.example.core.utils

import android.view.View


fun View.hide() {
    visibility = View.GONE
}

fun View.show() {
    visibility = View.VISIBLE
}

fun View.visibleWhenTrue(condition: Boolean) {
    visibility = if (condition) {
        View.VISIBLE
    } else {
        View.GONE
    }
}

