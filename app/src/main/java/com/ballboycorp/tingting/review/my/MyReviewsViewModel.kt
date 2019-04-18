package com.ballboycorp.tingting.review.my

import androidx.databinding.Bindable
import com.ballboycorp.tingting.BR
import com.ballboycorp.tingting.base.BaseObservableViewModel

/**
 * Created by musooff on 18/04/2019.
 */

class MyReviewsViewModel : BaseObservableViewModel(){

    var myReviewsSize: Int = 0
    @Bindable get() = field
    set(value) {
        field = value
        notifyPropertyChanged(BR.myReviewsSize)
    }

    var canReviewSize: Int = 0
        @Bindable get() = field
        set(value) {
            field = value
            notifyPropertyChanged(BR.canReviewSize)
        }
}