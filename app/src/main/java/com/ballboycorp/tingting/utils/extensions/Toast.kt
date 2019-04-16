package com.ballboycorp.tingting.utils.extensions

import android.content.Context
import android.widget.Toast

/**
 * Created by musooff on 16/04/2019.
 */

fun Context.showShortToast(message: String) {
    Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
}

fun Context.showLongToast(message: String) {
    Toast.makeText(this, message, Toast.LENGTH_LONG).show()
}