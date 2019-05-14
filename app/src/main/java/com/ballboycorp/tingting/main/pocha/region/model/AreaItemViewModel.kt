package com.ballboycorp.tingting.main.pocha.region.model

import androidx.databinding.Bindable
import com.ballboycorp.tingting.BR
import com.ballboycorp.tingting.base.BaseObservableViewModel

/**
 * Created by musooff on 2019-05-13.
 */

class AreaItemViewModel(val area: Area): BaseObservableViewModel() {
    var name = area.name
    var subAreas = area.subAreas

    var isSelected: Boolean = false
        @Bindable get() = field
        set(value) {
            field = value
            notifyPropertyChanged(BR.selected)
        }
}