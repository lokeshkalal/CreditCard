package com.dev.lokeshkalal.creditCard.common

import android.content.Context
import android.view.View
import android.view.inputmethod.InputMethodManager

/**
 * Extension method to provide show keyboard for View.
 */
fun View.showKeyboard() {
    this.requestFocus()
    val imm = context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
    imm.showSoftInput(this, InputMethodManager.RESULT_UNCHANGED_SHOWN)
}


/**
 * Extension method to provide hide keyboard for [View].
 */
fun View.hideKeyboard() {
    val imm = context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
    imm.hideSoftInputFromWindow(windowToken, 0)
}
