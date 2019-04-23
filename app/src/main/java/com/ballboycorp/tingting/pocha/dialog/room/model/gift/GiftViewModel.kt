package com.ballboycorp.tingting.pocha.dialog.room.model.gift

import androidx.databinding.Bindable
import com.ballboycorp.tingting.BR
import com.ballboycorp.tingting.base.BaseObservableViewModel

/**
 * Created by musooff on 2019-04-23.
 */

class GiftViewModel(gift: Gift): BaseObservableViewModel() {

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
}