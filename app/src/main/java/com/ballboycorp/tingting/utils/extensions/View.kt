package com.ballboycorp.tingting.utils.extensions

import android.app.Activity
import android.content.Context
import android.content.res.Resources
import android.graphics.Point
import android.graphics.Rect
import android.os.Build
import android.util.DisplayMetrics
import android.view.View
import android.view.WindowManager
import android.view.inputmethod.InputMethodManager
import androidx.core.content.ContextCompat.getSystemService




/**
 * Created by musooff on 2019-04-24.
 */

fun Activity.getScreenWidth(): Int {
    val size = Point()
    this.windowManager.defaultDisplay.getSize(size)
    return size.x
}


fun Activity.getKeyboardHeight(): Int {
    val r = Rect()
    val rootView = window.decorView
    rootView.getWindowVisibleDisplayFrame(r)
    return rootView.height - r.bottom
}

fun View.setHeight(height: Int) {
    val newLayoutParams = layoutParams
    newLayoutParams.height = height
    layoutParams = newLayoutParams
}

fun View.showKeyboard() {
    if (requestFocus()) {
        val imm = context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.showSoftInput(this, InputMethodManager.SHOW_IMPLICIT)
    }
}

fun View.hideKeyboard() {
    val imm = context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
    imm.hideSoftInputFromWindow(this.windowToken, InputMethodManager.SHOW_IMPLICIT)
}

fun Int.toPx(): Int = (this * Resources.getSystem().displayMetrics.density).toInt()

fun Int.toDp(): Int = (this / Resources.getSystem().displayMetrics.density).toInt()


fun Context.getUsableScreenHeight(rootView: View): Int {
    return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
        val metrics = DisplayMetrics()

        val windowManager = getSystemService(Context.WINDOW_SERVICE) as WindowManager
        windowManager.defaultDisplay.getMetrics(metrics)

        metrics.heightPixels

    } else {
        rootView.rootView.height
    }
}

fun View.hideView() {
    if (visibility != View.INVISIBLE) {
        visibility = View.INVISIBLE
    }
}

fun View.removeView() {
    if (visibility != View.GONE) {
        visibility = View.GONE
    }
}

fun View.showView() {
    if (visibility != View.VISIBLE) {
        visibility = View.VISIBLE
    }
}