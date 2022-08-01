package com.example.core.utils

import android.app.Activity
import android.content.Context
import android.view.inputmethod.InputMethodManager
import android.widget.EditText


object KeyboardUtils {

    fun showVirtualKeyboard(activity: Activity, editText: EditText) {
        try {
            editText.requestFocus()
            val imm = activity.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            imm.showSoftInput(editText, InputMethodManager.SHOW_IMPLICIT)
        } catch (e: Exception) {
        }
    }

    fun hideVirtualKeyboard(activity: Activity, onDone: () -> Unit = {}) {
        try {
            val inputManager =
                activity.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            // check if no view has focus:
            val view = activity.currentFocus
            if (view != null) {
                view.postDelayed({
                    inputManager.hideSoftInputFromWindow(
                        view.windowToken,
                        0
                    )
                    onDone()
                }, 50)
            } else {
                onDone()
            }
        } catch (e: Exception) {
            onDone()
        }
    }
}