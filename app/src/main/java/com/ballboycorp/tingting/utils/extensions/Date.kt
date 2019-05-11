package com.ballboycorp.tingting.utils.extensions

import java.text.SimpleDateFormat
import java.util.*

/**
 * Created by musooff on 2019-05-11.
 */

fun Date.toStringDate(): String {
    val format = SimpleDateFormat("yy.MM.dd HH:mm", Locale.KOREA)
    return format.format(this)
}

fun Date.toStringDateOrder(): String {
    val format = SimpleDateFormat("yy.MM.dd\nHH:mm", Locale.KOREA)
    return format.format(this)
}