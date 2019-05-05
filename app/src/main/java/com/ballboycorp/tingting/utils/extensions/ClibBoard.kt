package com.ballboycorp.tingting.utils.extensions

import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context

/**
 * Created by musooff on 2019-05-05.
 */

fun Context.copyToClipBoard(message: String?) {
    val clipboard = getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager?
    val clip = ClipData.newPlainText("TingTingPlace", message)
    clipboard?.primaryClip = clip
}