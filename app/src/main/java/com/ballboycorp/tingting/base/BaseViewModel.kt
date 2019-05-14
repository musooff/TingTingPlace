package com.ballboycorp.tingting.base

import androidx.lifecycle.ViewModel
import com.ballboycorp.tingting.MainApplication
import com.ballboycorp.tingting.network.TingTingService
import com.ballboycorp.tingting.utils.preference.ApplicationPreference
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

/**
 * Created by musooff on 07/04/2019.
 */

open class BaseViewModel : ViewModel() {

    val appPref by lazy { ApplicationPreference.getInstance(MainApplication.getContext()) }

    val tingTingService by lazy { TingTingService() }

    private val compositeDisposable = CompositeDisposable()

    protected fun addDisposable(disposable: Disposable) {
        compositeDisposable.add(disposable)
    }

    override fun onCleared() {
        compositeDisposable.clear()
        compositeDisposable.dispose()
        super.onCleared()
    }
}