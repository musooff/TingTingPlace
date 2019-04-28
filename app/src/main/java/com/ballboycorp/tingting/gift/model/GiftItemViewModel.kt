package com.ballboycorp.tingting.gift.model

import androidx.databinding.Bindable
import com.ballboycorp.tingting.BR
import com.ballboycorp.tingting.base.BaseObservableViewModel

/**
 * Created by musooff on 2019-04-28.
 */

class GiftItemViewModel(val gift: Gift): BaseObservableViewModel() {

    var id: Int = gift.id
        @Bindable get() = field
        set(value) {
            field = value
            notifyPropertyChanged(BR.id)
        }

    var title = gift.title
        @Bindable get() = field
        set(value) {
            field = value
            notifyPropertyChanged(BR.title)
        }

    var price = gift.price + "원"
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