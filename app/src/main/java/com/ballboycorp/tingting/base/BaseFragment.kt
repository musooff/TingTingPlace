package com.ballboycorp.tingting.base

import androidx.fragment.app.Fragment
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

/**
 * Created by musooff on 08/04/2019.
 */

open class BaseFragment : Fragment() {
    val mContext by lazy { context!! }

    val mActivity by lazy { activity!! }

    private val compositeDisposable = CompositeDisposable()

    protected fun addDisposable(disposable: Disposable) {
        compositeDisposable.add(disposable)
    }

    override fun onDestroyView() {
        compositeDisposable.clear()
        compositeDisposable.dispose()
        super.onDestroyView()
    }
}