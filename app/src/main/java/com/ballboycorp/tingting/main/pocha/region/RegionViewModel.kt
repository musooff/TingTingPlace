package com.ballboycorp.tingting.main.pocha.region

import androidx.databinding.Bindable
import com.ballboycorp.tingting.BR
import com.ballboycorp.tingting.base.BaseObservableViewModel
import com.ballboycorp.tingting.main.pocha.model.SortType

/**
 * Created by musooff on 18/04/2019.
 */

class RegionViewModel: BaseObservableViewModel() {

    var sortType: SortType = SortType.RATING
        @Bindable get() = field
        set(value) {
            field = value
            notifyPropertyChanged(BR.sortType)
        }
}