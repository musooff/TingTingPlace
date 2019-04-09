package com.ballboycorp.tingting.main.home

import androidx.lifecycle.MutableLiveData
import com.ballboycorp.tingting.base.BaseViewModel

/**
 * Created by musooff on 10/04/2019.
 */

class HomeViewModel: BaseViewModel() {
    val qrScanPageRequest: MutableLiveData<Boolean> = MutableLiveData()

    fun openQrScanPage() {
        qrScanPageRequest.value = true
    }
}