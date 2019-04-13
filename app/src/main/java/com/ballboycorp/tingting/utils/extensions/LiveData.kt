package com.ballboycorp.tingting.utils.extensions

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer

/**
 * Created by musooff on 07/04/2019.
 */

fun <T> LiveData<T>.observe(owner: LifecycleOwner, action: (T) -> Unit) {
    this.observe(owner, Observer {
        action.invoke(it)
    })
}

fun MutableLiveData<Boolean>.observeIfTrue(owner: LifecycleOwner, action: (Boolean) -> Unit) {
    this.observe(owner, Observer {
        if (it) {
            action.invoke(it)
            value = false
        }
    })
}

fun <T> MutableLiveData<ArrayList<T>>.contains(element: T): Boolean {
    return this.value?.contains(element) ?: false

}

fun <T> MutableLiveData<ArrayList<T>>.add(element: T) {
    var values = value
    if (values == null) {
        values = arrayListOf()
    }
    values.add(element)
    value = values
}


fun <T> MutableLiveData<ArrayList<T>>.remove(element: T) {
    val values = value
    if (values?.contains(element) == true) values.remove(element)
    value = values
}