package com.ballboycorp.tingting.splash

import android.os.Handler
import androidx.lifecycle.MutableLiveData
import com.ballboycorp.tingting.base.BaseViewModel

/**
 * Created by musooff on 07/04/2019.
 */

class SplashViewModel: BaseViewModel() {

    val mainPageRequest: MutableLiveData<Boolean> = MutableLiveData()

    fun openMainPage() {
        Handler().postDelayed({
            mainPageRequest.value = true
        }, 500)
    }
}