package com.ballboycorp.tingting.pocha.dialog.room.model.bet

import androidx.databinding.Bindable
import com.ballboycorp.tingting.BR
import com.ballboycorp.tingting.base.BaseObservableViewModel

/**
 * Created by musooff on 2019-04-23.
 */

class BetItemViewModel(val bet: Bet): BaseObservableViewModel() {

    var id: Int = bet.id
        @Bindable get() = field
        set(value) {
            field = value
            notifyPropertyChanged(BR.id)
        }

    var title = bet.title
        @Bindable get() = field
        set(value) {
            field = value
            notifyPropertyChanged(BR.title)
        }

    var price = bet.price + "원"
        @Bindable get() = field
        set(value) {
            field = value
            notifyPropertyChanged(BR.price)
        }

    var isSelected: Boolean = false
        @Bindable get() = field
        set(value) {
            field = value
            notifyPropertyChanged(BR.selected)
        }

    var count: Int = 0
        @Bindable get() = field
        set(value) {
            field = value
            notifyPropertyChanged(BR.count)
        }
}