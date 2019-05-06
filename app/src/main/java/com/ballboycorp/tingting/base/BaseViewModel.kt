package com.ballboycorp.tingting.base

import androidx.lifecycle.ViewModel
import com.ballboycorp.tingting.MainApplication
import com.ballboycorp.tingting.utils.preference.ApplicationPreference

/**
 * Created by musooff on 07/04/2019.
 */

open class BaseViewModel : ViewModel() {

    val appPref by lazy { ApplicationPreference.getInstance(MainApplication.getContext()) }
}