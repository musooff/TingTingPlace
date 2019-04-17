package com.ballboycorp.tingting.utils.extensions

import android.app.Activity
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.FragmentActivity

/**
 * Created by musooff on 18/04/2019.
 */

fun <T: DialogFragment> FragmentActivity.showDialog() {
    val fragmentManager = this.supportFragmentManager
}