package com.ballboycorp.tingting.main.pocha.region.result

import androidx.databinding.Bindable
import com.ballboycorp.tingting.BR
import com.ballboycorp.tingting.base.BaseObservableViewModel
import com.ballboycorp.tingting.main.pocha.model.SortType

/**
 * Created by musooff on 2019-05-13.
 */

class RegionResultViewModel: BaseObservableViewModel() {
    var sortType: SortType = SortType.RATING
        @Bindable get() = field
        set(value) {
            field = value
            notifyPropertyChanged(BR.sortType)
        }
}