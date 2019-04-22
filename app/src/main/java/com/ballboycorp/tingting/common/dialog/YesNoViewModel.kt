package com.ballboycorp.tingting.common.dialog

import androidx.databinding.Bindable
import com.ballboycorp.tingting.BR
import com.ballboycorp.tingting.base.BaseObservableViewModel

/**
 * Created by musooff on 2019-04-23.
 */

class YesNoViewModel: BaseObservableViewModel() {

    var text: String? = null
        @Bindable get() = field
        set(value) {
            field = value
            notifyPropertyChanged(BR.text)
        }

    var title: String? = null
        @Bindable get() = field
        set(value) {
            field = value
            notifyPropertyChanged(BR.title)
        }
}