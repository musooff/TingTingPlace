package com.ballboycorp.tingting.table.single

import androidx.databinding.Bindable
import com.ballboycorp.tingting.BR
import com.ballboycorp.tingting.base.BaseObservableViewModel

/**
 * Created by musooff on 2019-04-21.
 */

class SingleProfileViewModel: BaseObservableViewModel() {

    var userIndex: Int = 0
        @Bindable get() = field
        set(value) {
            field = value
            notifyPropertyChanged(BR.userIndex)
        }
}