package com.ballboycorp.tingting.shop.model

import android.widget.ImageView
import androidx.databinding.Bindable
import androidx.databinding.BindingAdapter
import com.ballboycorp.tingting.BR
import com.ballboycorp.tingting.R
import com.ballboycorp.tingting.base.BaseObservableViewModel
import com.ballboycorp.tingting.billing.model.ChattingSkuDetails

/**
 * Created by musooff on 2019-05-11.
 */

class ShopItemViewModel(val chattingSkuDetails: ChattingSkuDetails) : BaseObservableViewModel(){
    companion object {
        @JvmStatic
        @BindingAdapter("app:sku")
        fun setPriceThumb(imageView: ImageView, sku: String) {
            when (sku) {
                ChattingSkuDetails.ChattingSku.CHATTING_30_1 -> imageView.setImageResource(R.drawable.ic_30_1)
                ChattingSkuDetails.ChattingSku.CHATTING_30_2 -> imageView.setImageResource(R.drawable.ic_30_2)
                ChattingSkuDetails.ChattingSku.CHATTING_30_3 -> imageView.setImageResource(R.drawable.ic_30_3)
                ChattingSkuDetails.ChattingSku.CHATTING_60_1 -> imageView.setImageResource(R.drawable.ic_60_1)
                ChattingSkuDetails.ChattingSku.CHATTING_60_2 -> imageView.setImageResource(R.drawable.ic_60_2)
                ChattingSkuDetails.ChattingSku.CHATTING_60_3 -> imageView.setImageResource(R.drawable.ic_60_3)
            }
        }
    }

    var sku = chattingSkuDetails.sku
        @Bindable get() = field
        set(value) {
            field = value
            notifyPropertyChanged(BR.sku)
        }

    var duration = getDuration(chattingSkuDetails.sku)
        @Bindable get() = field
        set(value) {
            field = value
            notifyPropertyChanged(BR.duration)
        }
    var amount = getAmount(chattingSkuDetails.sku)
        @Bindable get() = field
        set(value) {
            field = value
            notifyPropertyChanged(BR.amount)
        }
    var price = chattingSkuDetails.price
        @Bindable get() = field
        set(value) {
            field = value
            notifyPropertyChanged(BR.price)
        }

    private fun getDuration(sku: String): Int {
        return when (sku) {
            ChattingSkuDetails.ChattingSku.CHATTING_30_1 -> 30
            ChattingSkuDetails.ChattingSku.CHATTING_30_2 -> 30
            ChattingSkuDetails.ChattingSku.CHATTING_30_3 -> 30
            ChattingSkuDetails.ChattingSku.CHATTING_60_1 -> 60
            ChattingSkuDetails.ChattingSku.CHATTING_60_2 -> 60
            ChattingSkuDetails.ChattingSku.CHATTING_60_3 -> 60
            else -> 0
        }
    }

    private fun getAmount(sku: String): Int {
        return when (sku) {
            ChattingSkuDetails.ChattingSku.CHATTING_30_1 -> 1
            ChattingSkuDetails.ChattingSku.CHATTING_30_2 -> 2
            ChattingSkuDetails.ChattingSku.CHATTING_30_3 -> 3
            ChattingSkuDetails.ChattingSku.CHATTING_60_1 -> 1
            ChattingSkuDetails.ChattingSku.CHATTING_60_2 -> 2
            ChattingSkuDetails.ChattingSku.CHATTING_60_3 -> 3
            else -> 0
        }
    }
}