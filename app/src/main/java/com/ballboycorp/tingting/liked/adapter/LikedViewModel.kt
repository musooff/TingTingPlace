package com.ballboycorp.tingting.liked.adapter

import androidx.databinding.Bindable
import com.ballboycorp.tingting.BR
import com.ballboycorp.tingting.base.BaseObservableViewModel

/**
 * Created by musooff on 13/04/2019.
 */

class LikedViewModel: BaseObservableViewModel() {

    var isEditMode: Boolean = false
    @Bindable get() = field
    set(value) {
        field = value
        notifyPropertyChanged(BR.editMode)
    }
}