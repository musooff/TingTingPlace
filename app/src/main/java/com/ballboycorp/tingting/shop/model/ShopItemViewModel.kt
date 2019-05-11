package com.ballboycorp.tingting.shop.model

import android.widget.ImageView
import androidx.databinding.Bindable
import androidx.databinding.BindingAdapter
import com.ballboycorp.tingting.BR
import com.ballboycorp.tingting.R
import com.ballboycorp.tingting.base.BaseObservableViewModel

/**
 * Created by musooff on 2019-05-11.
 */

class ShopItemViewModel(val shopItem: ShopItem) : BaseObservableViewModel(){
    companion object {
        @JvmStatic
        @BindingAdapter("app:duration", "app:amount")
        fun setPriceThumb(imageView: ImageView, duration: Int, amount: Int) {
            when (duration){
                30 -> {
                    when (amount) {
                        1 -> imageView.setImageResource(R.drawable.ic_30_1)
                        2 -> imageView.setImageResource(R.drawable.ic_30_2)
                        3 -> imageView.setImageResource(R.drawable.ic_30_3)
                    }
                }
                60 -> {
                    when (amount) {
                        1 -> imageView.setImageResource(R.drawable.ic_60_1)
                        2 -> imageView.setImageResource(R.drawable.ic_60_2)
                        3 -> imageView.setImageResource(R.drawable.ic_60_3)
                    }
                }
            }
        }
    }
    var duration = shopItem.duration
        @Bindable get() = field
        set(value) {
            field = value
            notifyPropertyChanged(BR.duration)
        }
    var amount = shopItem.amount
        @Bindable get() = field
        set(value) {
            field = value
            notifyPropertyChanged(BR.amount)
        }
    var price = shopItem.price
        @Bindable get() = field
        set(value) {
            field = value
            notifyPropertyChanged(BR.price)
        }
}