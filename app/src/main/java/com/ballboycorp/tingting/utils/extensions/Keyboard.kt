package com.ballboycorp.tingting.utils.extensions

import android.app.Activity
import android.view.inputmethod.InputMethodManager



/**
 * Created by musooff on 2019-04-21.
 */

fun Activity.hideSoftKeyboard() {
    val inputMethodManager = this.getSystemService(
            Activity.INPUT_METHOD_SERVICE) as InputMethodManager
    inputMethodManager.hideSoftInputFromWindow(
            this.currentFocus?.windowToken, 0)
}