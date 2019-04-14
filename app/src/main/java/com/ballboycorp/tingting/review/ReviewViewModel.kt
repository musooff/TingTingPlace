package com.ballboycorp.tingting.review

import androidx.databinding.Bindable
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.ballboycorp.tingting.BR
import com.ballboycorp.tingting.base.BaseObservableViewModel
import com.ballboycorp.tingting.review.model.Review
import com.ballboycorp.tingting.review.model.ReviewItemViewModel

/**
 * Created by musooff on 14/04/2019.
 */

class ReviewViewModel: BaseObservableViewModel() {

    var rating: String? = "4.2"
        @Bindable get() = field
        set(value) {
            field = value
            notifyPropertyChanged(BR.rating)
        }

    fun getReviews(): LiveData<List<ReviewItemViewModel>> {
        val result = ArrayList<ReviewItemViewModel>()
        for (i in 0..25) result.add(ReviewItemViewModel(Review()))
        return MutableLiveData<List<ReviewItemViewModel>>().apply { value = result }
    }
}