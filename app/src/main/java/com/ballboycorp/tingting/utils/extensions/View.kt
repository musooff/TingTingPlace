package com.ballboycorp.tingting.utils.extensions

import android.app.Activity
import android.graphics.Point


/**
 * Created by musooff on 2019-04-24.
 */

fun Activity.getScreenWidth(): Int {
    val size = Point()
    this.windowManager.defaultDisplay.getSize(size)
    return size.x
}