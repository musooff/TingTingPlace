package com.ballboycorp.tingting.review.model

import androidx.databinding.Bindable
import com.ballboycorp.tingting.BR
import com.ballboycorp.tingting.base.BaseObservableViewModel
import com.ballboycorp.tingting.review.Review

/**
 * Created by musooff on 14/04/2019.
 */

class ReviewViewModel: BaseObservableViewModel() {

    var nickname: String? = null
        @Bindable get() = field
        set(value) {
            field = value
            notifyPropertyChanged(BR.nickname)
        }

    var time: String? = null
        @Bindable get() = field
        set(value) {
            field = value
            notifyPropertyChanged(BR.time)
        }

    var description: String? = null
        @Bindable get() = field
        set(value) {
            field = value
            notifyPropertyChanged(BR.description)
        }

    fun setData(review: Review) {
        nickname = review.nickname
        time = review.time
        description = review.description
    }
}