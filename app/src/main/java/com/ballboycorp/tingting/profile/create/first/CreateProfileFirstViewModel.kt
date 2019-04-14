package com.ballboycorp.tingting.profile.create.first

import androidx.databinding.Bindable
import com.ballboycorp.tingting.BR
import com.ballboycorp.tingting.base.BaseObservableViewModel

/**
 * Created by musooff on 14/04/2019.
 */

class CreateProfileFirstViewModel: BaseObservableViewModel() {

    var gender:Int = -1
    @Bindable get() = field
    set(value) {
        field = value
        notifyPropertyChanged(BR.gender)
    }
}