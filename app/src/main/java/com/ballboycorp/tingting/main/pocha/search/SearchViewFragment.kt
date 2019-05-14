package com.ballboycorp.tingting.main.pocha.search

import androidx.databinding.Bindable
import androidx.lifecycle.MutableLiveData
import com.ballboycorp.tingting.BR
import com.ballboycorp.tingting.base.BaseObservableViewModel
import com.ballboycorp.tingting.main.pocha.model.Pocha
import com.ballboycorp.tingting.utils.extensions.observeOnMainThread

/**
 * Created by musooff on 13/04/2019.
 */

class SearchViewFragment: BaseObservableViewModel() {

    val pochas: MutableLiveData<List<Pocha>> = MutableLiveData()
    val error: MutableLiveData<Throwable> = MutableLiveData()

    var searchKey: String? = null
        @Bindable get() = field
        set(value) {
            field = value
            canSearch = !searchKey.isNullOrBlank()
            notifyPropertyChanged(BR.searchKey)
        }

    var canSearch: Boolean = false
        @Bindable get() = field
        set(value) {
            field = value
            notifyPropertyChanged(BR.canSearch)
        }

    fun searchRestaurants() {
        searchKey?.let {
            addDisposable(tingTingService.searchRestaurants(it)
                    .observeOnMainThread()
                    .subscribe({
                        pochas.value = it }, {
                        error.value = it }))
        }
    }
}