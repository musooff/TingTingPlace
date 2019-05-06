package com.ballboycorp.tingting.utils.extensions

import android.graphics.Color
import android.os.Build
import android.view.View
import android.view.WindowManager
import androidx.fragment.app.FragmentActivity

/**
 * Created by musooff on 2019-05-06.
 */

fun FragmentActivity.makeTransparentStatus() {
    if ((19 until 21).contains(Build.VERSION.SDK_INT)) {
        setWindowFlag(this, WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS, true)
    }
    if (Build.VERSION.SDK_INT >= 19) {
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LAYOUT_STABLE or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
    }
    if (Build.VERSION.SDK_INT >= 21) {
        setWindowFlag(this, WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS, false)
        window.statusBarColor = Color.TRANSPARENT
    }
}

private fun setWindowFlag(activity: FragmentActivity, bits: Int, on: Boolean) {
    activity.window.attributes.apply {
        flags = if (on) {
            flags or bits
        } else {
            flags and bits.inv()
        }
    }
}