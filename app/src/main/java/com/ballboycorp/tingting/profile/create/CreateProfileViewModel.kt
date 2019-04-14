package com.ballboycorp.tingting.profile.create

import androidx.databinding.Bindable
import com.ballboycorp.tingting.BR
import com.ballboycorp.tingting.base.BaseObservableViewModel

/**
 * Created by musooff on 14/04/2019.
 */

class CreateProfileViewModel: BaseObservableViewModel(){

    var canMoveNext: Boolean = false
    @Bindable get() = field
    set(value) {
        field = value
        notifyPropertyChanged(BR.canMoveNext)
    }
}