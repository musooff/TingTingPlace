package com.ballboycorp.tingting.my.orders.model

import androidx.databinding.Bindable
import com.ballboycorp.tingting.BR
import com.ballboycorp.tingting.base.BaseObservableViewModel
import com.ballboycorp.tingting.shop.model.ShopItemViewModel
import com.ballboycorp.tingting.utils.extensions.toStringDateOrder

/**
 * Created by musooff on 2019-05-11.
 */

class OrderItemViewModel(val order: Order): BaseObservableViewModel() {
    var status = order.status
        @Bindable get() = field
        set(value) {
            field = value
            notifyPropertyChanged(BR.status)
        }

    var duration = order.shopItem!!.duration
        @Bindable get() = field
        set(value) {
            field = value
            notifyPropertyChanged(BR.duration)
        }
    var amount = order.shopItem!!.amount
        @Bindable get() = field
        set(value) {
            field = value
            notifyPropertyChanged(BR.amount)
        }

    var shopItemViewModel = ShopItemViewModel(order.shopItem!!)
        @Bindable get() = field
        set(value) {
            field = value
            notifyPropertyChanged(BR.shopItemViewModel)
        }

    var usedAt: String? = order.usedAt?.toStringDateOrder()
        @Bindable get() = field
        set(value) {
            field = value
            notifyPropertyChanged(BR.usedAt)
        }
}