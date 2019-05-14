package com.ballboycorp.tingting.main.pocha.nearby

import androidx.databinding.Bindable
import androidx.lifecycle.MutableLiveData
import com.ballboycorp.tingting.BR
import com.ballboycorp.tingting.base.BaseObservableViewModel
import com.ballboycorp.tingting.main.pocha.model.Pocha
import com.ballboycorp.tingting.main.pocha.model.SortType
import com.ballboycorp.tingting.utils.extensions.observeOnMainThread
import io.reactivex.Single

/**
 * Created by musooff on 13/04/2019.
 */

class NearbyViewModel : BaseObservableViewModel() {

    val pochas: MutableLiveData<List<Pocha>> = MutableLiveData()
    val error: MutableLiveData<Throwable> = MutableLiveData()

    var sortType: SortType = SortType.RATING
        @Bindable get() = field

        set(value) {
            field = value
            notifyPropertyChanged(BR.sortType)
        }

    fun nearbyRestaurants(longitude: Double, latitude: Double) {
        addDisposable(tingTingService.nearbyRestaurants(longitude, latitude)
                .observeOnMainThread()
                .subscribe({ pochas.value = it }, { error.value = it }))
    }
}