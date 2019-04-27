package com.ballboycorp.tingting.pocha.home

import androidx.databinding.Bindable
import com.ballboycorp.tingting.BR
import com.ballboycorp.tingting.base.BaseObservableViewModel
import com.ballboycorp.tingting.table.model.TableItemViewModel

/**
 * Created by musooff on 2019-04-21.
 */

class HomeViewModel: BaseObservableViewModel() {

    var myTableItemViewModel: TableItemViewModel? = null

    var isGameCreated: Boolean = false
        @Bindable get() = field
        set(value) {
            field = value
            notifyPropertyChanged(BR.gameCreated)
        }
}