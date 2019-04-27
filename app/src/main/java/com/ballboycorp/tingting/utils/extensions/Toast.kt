package com.ballboycorp.tingting.utils.extensions

import android.content.Context
import android.widget.Toast
import androidx.fragment.app.Fragment

/**
 * Created by musooff on 16/04/2019.
 */

fun Context.showShortToast(message: String) {
    Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
}

fun Context.showLongToast(message: String) {
    Toast.makeText(this, message, Toast.LENGTH_LONG).show()
}

fun Fragment.showShortToast(message: String) {
    Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
}

fun Fragment.showLongToast(message: String) {
    Toast.makeText(context, message, Toast.LENGTH_LONG).show()
}