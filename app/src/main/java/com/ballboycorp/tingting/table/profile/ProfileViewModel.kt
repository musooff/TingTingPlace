package com.ballboycorp.tingting.table.profile

import androidx.databinding.Bindable
import com.ballboycorp.tingting.BR
import com.ballboycorp.tingting.base.BaseObservableViewModel
import com.ballboycorp.tingting.table.model.Table
import com.ballboycorp.tingting.table.model.TableItemViewModel

/**
 * Created by musooff on 2019-04-21.
 */

class ProfileViewModel: BaseObservableViewModel() {

    var toolbarTitle: String? = null
        @Bindable get() = field
        set(value) {
            field = value
            notifyPropertyChanged(BR.toolbarTitle)
        }
    var tableItemViewModel: TableItemViewModel? = null
}