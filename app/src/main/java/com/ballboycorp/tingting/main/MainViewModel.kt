package com.ballboycorp.tingting.main

import android.os.Handler
import androidx.databinding.Bindable
import com.ballboycorp.tingting.BR
import com.ballboycorp.tingting.base.BaseObservableViewModel

/**
 * Created by musooff on 07/04/2019.
 */

class MainViewModel : BaseObservableViewModel() {

    var isFirstRun: Boolean = true
        @Bindable get() = field
        set(value) {
            field = value
            notifyPropertyChanged(BR.firstRun)
        }

    fun checkFirstRun() {
        isFirstRun = appPref.isFirstRun()
        if (isFirstRun) {
            closeFirstImage()
        }
    }

    private fun closeFirstImage() {
        Handler().postDelayed({
            isFirstRun = false
            appPref.setFirstRun(false)
        }, 5000)
    }
}