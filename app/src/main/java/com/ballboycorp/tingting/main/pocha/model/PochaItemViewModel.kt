package com.ballboycorp.tingting.main.pocha.model

import androidx.databinding.Bindable
import com.ballboycorp.tingting.BR
import com.ballboycorp.tingting.base.BaseObservableViewModel
import com.ballboycorp.tingting.review.model.ReviewItemViewModel

/**
 * Created by musooff on 18/04/2019.
 */

class PochaItemViewModel(pocha: Pocha) : BaseObservableViewModel() {

    var title: String? = pocha.title
        @Bindable get() = field
        set(value) {
            field = value
            notifyPropertyChanged(BR.title)
        }
    var reviewCount: String? = "리뷰 ${pocha.reviewCount}"
        @Bindable get() = field
        set(value) {
            field = value
            notifyPropertyChanged(BR.reviewCount)
        }
    var commentCount: String = "사장님 댓글 ${pocha.commentCount}"
        @Bindable get() = field
        set(value) {
            field = value
            notifyPropertyChanged(BR.commentCount)
        }
    var distance: Int = pocha.distance
        @Bindable get() = field
        set(value) {
            field = value
            notifyPropertyChanged(BR.distance)
        }
    var rating: Float = pocha.rating
        @Bindable get() = field
        set(value) {
            field = value
            notifyPropertyChanged(BR.rating)
        }
    var location: String? = pocha.location
        @Bindable get() = field
        set(value) {
            field = value
            notifyPropertyChanged(BR.location)
        }

    var latitude: Double = pocha.lattitude
        @Bindable get() = field
        set(value) {
            field = value
            notifyPropertyChanged(BR.latitude)
        }
    var longtitude: Double = pocha.longtitude
        @Bindable get() = field
        set(value) {
            field = value
            notifyPropertyChanged(BR.longtitude)
        }
    var isLiked: Boolean = pocha.isLiked
        @Bindable get() = field
        set(value) {
            field = value
            notifyPropertyChanged(BR.liked)
        }
    var description: String? = pocha.description
        @Bindable get() = field
        set(value) {
            field = value
            notifyPropertyChanged(BR.description)
        }
    var descriptionMore: String? = pocha.descriptionMore
        @Bindable get() = field
        set(value) {
            field = value
            notifyPropertyChanged(BR.descriptionMore)
        }
    var phone: String? = pocha.phone
        @Bindable get() = field
        set(value) {
            field = value
            notifyPropertyChanged(BR.phone)
        }
    var workTime: String? = pocha.workTime
        @Bindable get() = field
        set(value) {
            field = value
            notifyPropertyChanged(BR.workTime)
        }
    var myReview: ReviewItemViewModel? = pocha.myReview?.let { ReviewItemViewModel(it) }
        @Bindable get() = field
        set(value) {
            field = value
            notifyPropertyChanged(BR.myReview)
        }

    var thumbs: List<String> = pocha.thumbs
        @Bindable get() = field
        set(value) {
            field = value
            notifyPropertyChanged(BR.thumbs)
        }
}