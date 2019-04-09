package com.ballboycorp.tingting.utils.extensions

import android.app.Activity
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment

/**
 * Created by musooff on 10/04/2019.
 */

fun <T: ViewDataBinding> Activity.bind(layoutId: Int): T {
    return DataBindingUtil.setContentView(this, layoutId)
}

fun <T: ViewDataBinding> Fragment.bind(inflater: LayoutInflater,layoutId: Int, container: ViewGroup?): T {
    return DataBindingUtil.inflate(inflater, layoutId, container, false)
}