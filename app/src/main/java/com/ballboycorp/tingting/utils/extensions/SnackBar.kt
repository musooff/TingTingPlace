package com.ballboycorp.tingting.utils.extensions

import android.view.View
import androidx.core.content.ContextCompat
import com.ballboycorp.tingting.R
import com.google.android.material.snackbar.Snackbar
import android.view.Gravity
import android.os.Build
import android.widget.TextView


/**
 * Created by musooff on 2019-05-05.
 */

fun showSnackBar(view: View, text: CharSequence) {
    val snackBar = Snackbar.make(view, text, Snackbar.LENGTH_SHORT)
    snackBar.view.setBackgroundColor(ContextCompat.getColor(view.context, R.color.colorRed))
    val tv = snackBar.view.findViewById(com.google.android.material.R.id.snackbar_text) as TextView
    tv.gravity = Gravity.CENTER
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
        tv.textAlignment = View.TEXT_ALIGNMENT_CENTER
    }
    snackBar.show()

}