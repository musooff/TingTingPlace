package com.ballboycorp.tingting.main.pocha.nearby.choose

import androidx.databinding.Bindable
import com.ballboycorp.tingting.BR
import com.ballboycorp.tingting.base.BaseObservableViewModel

/**
 * Created by musooff on 2019-05-05.
 */

class ChooseLocationViewModel: BaseObservableViewModel() {

    var location: String? = null
        @Bindable get() = field
        set(value) {
            field = value
            canSelect = location != null
            notifyPropertyChanged(BR.location)
        }

    var canSelect: Boolean = false
        @Bindable get() = field
        set(value) {
            field = value
            notifyPropertyChanged(BR.canSelect)
        }
}