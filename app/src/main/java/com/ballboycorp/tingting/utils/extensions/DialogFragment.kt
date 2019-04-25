package com.ballboycorp.tingting.utils.extensions

import android.os.Bundle
import android.os.Parcelable
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import java.io.Serializable

/**
 * Created by musooff on 18/04/2019.
 */

fun <T : DialogFragment> FragmentActivity.showDialog(factory: () -> T, vararg params: Pair<String, Any?>) {
    val dialog = factory()
    if (params.isNotEmpty()) {
        val bundle = Bundle()
        fillBundleArguments(bundle, params)
        dialog.arguments = bundle
    }
    dialog.show(supportFragmentManager, dialog::class.java.simpleName)
}

fun <T: DialogFragment> Fragment.showDialog(factory: () -> T, vararg params: Pair<String, Any?>) {
    val dialog = factory()
    if (params.isNotEmpty()) {
        val bundle = Bundle()
        fillBundleArguments(bundle, params)
        dialog.arguments = bundle
    }
    dialog.show(childFragmentManager, dialog::class.java.simpleName)
}

fun fillBundleArguments(bundle: Bundle, params: Array<out Pair<String, Any?>>) {
    params.forEach {
        val value = it.second
        when (value) {
            null -> bundle.putSerializable(it.first, null as Serializable?)
            is Int -> bundle.putInt(it.first, value)
            is Long -> bundle.putLong(it.first, value)
            is CharSequence -> bundle.putCharSequence(it.first, value)
            is String -> bundle.putString(it.first, value)
            is Float -> bundle.putFloat(it.first, value)
            is Double -> bundle.putDouble(it.first, value)
            is Char -> bundle.putChar(it.first, value)
            is Short -> bundle.putShort(it.first, value)
            is Boolean -> bundle.putBoolean(it.first, value)
            is Serializable -> bundle.putSerializable(it.first, value)
            is Bundle -> bundle.putBundle(it.first, value)
            is Parcelable -> bundle.putParcelable(it.first, value)
            is Array<*> -> when {
                value.isArrayOf<CharSequence>() -> bundle.putCharSequenceArray(it.first, value as Array<CharSequence>?)
                value.isArrayOf<String>() -> bundle.putStringArray(it.first, value as Array<String>)
                value.isArrayOf<Parcelable>() -> bundle.putParcelableArray(it.first, value as Array<Parcelable>?)
                else -> throw Exception("Intent extra ${it.first} has wrong type ${value.javaClass.name}")
            }
            is IntArray -> bundle.putIntArray(it.first, value)
            is LongArray -> bundle.putLongArray(it.first, value)
            is FloatArray -> bundle.putFloatArray(it.first, value)
            is DoubleArray -> bundle.putDoubleArray(it.first, value)
            is CharArray -> bundle.putCharArray(it.first, value)
            is ShortArray -> bundle.putShortArray(it.first, value)
            is BooleanArray -> bundle.putBooleanArray(it.first, value)
            else -> throw Exception("Intent extra ${it.first} has wrong type ${value.javaClass.name}")
        }
        return@forEach
    }
}