package com.ballboycorp.tingting.review.model

import androidx.databinding.Bindable
import com.ballboycorp.tingting.BR
import com.ballboycorp.tingting.base.BaseObservableViewModel

/**
 * Created by musooff on 14/04/2019.
 */

class ReviewItemViewModel(review: Review): BaseObservableViewModel() {

    var nickname: String? = review.nickname
        @Bindable get() = field
        set(value) {
            field = value
            notifyPropertyChanged(BR.nickname)
        }

    var time: String? = review.time
        @Bindable get() = field
        set(value) {
            field = value
            notifyPropertyChanged(BR.time)
        }

    var description: String? = review.description
        @Bindable get() = field
        set(value) {
            field = value
            notifyPropertyChanged(BR.description)
        }
}