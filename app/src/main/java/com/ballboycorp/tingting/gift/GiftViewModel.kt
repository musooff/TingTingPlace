package com.ballboycorp.tingting.gift

import androidx.databinding.Bindable
import com.ballboycorp.tingting.BR
import com.ballboycorp.tingting.base.BaseObservableViewModel
import com.ballboycorp.tingting.pocha.dialog.room.model.gift.GiftItemViewModel
import java.math.BigDecimal
import java.util.*

/**
 * Created by musooff on 2019-04-24.
 */

class GiftViewModel: BaseObservableViewModel() {

    val selectedGifts: MutableList<GiftItemViewModel> = mutableListOf()

    var isBottomSheepOpen: Boolean = false
        @Bindable get() = field
        set(value) {
            field = value
            notifyPropertyChanged(BR.bottomSheepOpen)
        }

    var canSendGift: Boolean = false
        @Bindable get() = field
        set(value) {
            field = value
            notifyPropertyChanged(BR.canSendGift)
        }

    var totalPrice: String? = "0원"
        @Bindable get() = field
        set(value) {
            field = value
            notifyPropertyChanged(BR.totalPrice)
        }

    fun updateTotal() {
        totalPrice = selectedGifts
                .map { it.gift.price }
                .map { it?.replace(",", "") }
                .map { BigDecimal(it) }
                .fold(BigDecimal.ZERO, BigDecimal::add)
                .toString() + "원"
    }
}