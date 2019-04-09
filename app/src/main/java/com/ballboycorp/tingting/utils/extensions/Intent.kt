package com.ballboycorp.tingting.utils.extensions

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.os.Parcelable
import androidx.fragment.app.Fragment
import java.io.Serializable

/**
 * Created by musooff on 4/8/19.
 *
 * Usage
 *
 * startActivity(intentFor<SomeOtherActivity>("id" to 5).singleTop())
 * startActivity<SomeOtherActivity>("id" to 5)
 */

inline fun <reified T: Activity> Context.startActivity(vararg params: Pair<String, Any?>) =
        this.startActivity(createIntent(this, T::class.java, params))

inline fun <reified T : Any> Context.intentFor(vararg params: Pair<String, Any?>): Intent =
        createIntent(this, T::class.java, params)

inline fun <reified T : Activity> Activity.startActivityForResult(requestCode: Int, vararg params: Pair<String, Any?>) =
        this.startActivityForResult(createIntent(this, T::class.java, params), requestCode)

inline fun <reified T : Activity> Fragment.startActivity(vararg params: Pair<String, Any?>) {
    requireActivity().startActivity(createIntent(requireActivity(), T::class.java, params))
}

inline fun <reified T : Activity> Fragment.startActivityForResult(requestCode: Int, vararg params: Pair<String, Any?>) {
    requireActivity().startActivityForResult(createIntent(requireActivity(), T::class.java, params), requestCode)
}

inline fun <reified T : Any> Fragment.intentFor(vararg params: Pair<String, Any?>): Intent =
        createIntent(requireActivity(), T::class.java, params)

fun <T> createIntent(context: Context, clazz: Class<out T>, params: Array<out Pair<String, Any?>>): Intent {
    val intent = Intent(context, clazz)
    if (params.isNotEmpty()) fillIntentArguments(intent, params)
    return intent
}

fun fillIntentArguments(intent: Intent, params: Array<out Pair<String, Any?>>) {
    params.forEach {
        val value = it.second
        when (value) {
            null -> intent.putExtra(it.first, null as Serializable?)
            is Int -> intent.putExtra(it.first, value)
            is Long -> intent.putExtra(it.first, value)
            is CharSequence -> intent.putExtra(it.first, value)
            is String -> intent.putExtra(it.first, value)
            is Float -> intent.putExtra(it.first, value)
            is Double -> intent.putExtra(it.first, value)
            is Char -> intent.putExtra(it.first, value)
            is Short -> intent.putExtra(it.first, value)
            is Boolean -> intent.putExtra(it.first, value)
            is Serializable -> intent.putExtra(it.first, value)
            is Bundle -> intent.putExtra(it.first, value)
            is Parcelable -> intent.putExtra(it.first, value)
            is Array<*> -> when {
                value.isArrayOf<CharSequence>() -> intent.putExtra(it.first, value)
                value.isArrayOf<String>() -> intent.putExtra(it.first, value)
                value.isArrayOf<Parcelable>() -> intent.putExtra(it.first, value)
                else -> throw Exception("Intent extra ${it.first} has wrong type ${value.javaClass.name}")
            }
            is IntArray -> intent.putExtra(it.first, value)
            is LongArray -> intent.putExtra(it.first, value)
            is FloatArray -> intent.putExtra(it.first, value)
            is DoubleArray -> intent.putExtra(it.first, value)
            is CharArray -> intent.putExtra(it.first, value)
            is ShortArray -> intent.putExtra(it.first, value)
            is BooleanArray -> intent.putExtra(it.first, value)
            else -> throw Exception("Intent extra ${it.first} has wrong type ${value.javaClass.name}")
        }
        return@forEach
    }
}

fun Intent.singleTop(): Intent = apply { addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP) }
fun Intent.newTask(): Intent = apply { addFlags(Intent.FLAG_ACTIVITY_NEW_TASK) }
fun Intent.clearTop(): Intent = apply { addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP) }
fun Intent.clearTask(): Intent = apply { addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK) }