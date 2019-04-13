package com.ballboycorp.tingting.pocha.details

import android.view.View
import androidx.databinding.Bindable
import androidx.databinding.BindingAdapter
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.ballboycorp.tingting.BR
import com.ballboycorp.tingting.base.BaseObservableViewModel
import com.ballboycorp.tingting.main.pocha.model.Pocha
import com.ballboycorp.tingting.pocha.details.model.Menu

/**
 * Created by musooff on 13/04/2019.
 */

class PochaDetailsViewModel : BaseObservableViewModel() {

    companion object {
        @JvmStatic
        @BindingAdapter("activated")
        fun isActivated(view: View, value: Boolean) {
            view.isActivated = value
        }
    }

    var isLiked: Boolean = false
        @Bindable get() = field
        set(value) {
            field = value
            notifyPropertyChanged(BR.liked)
        }

    var title: String? = null
        @Bindable get() = field
        set(value) {
            field = value
            notifyPropertyChanged(BR.title)
        }

    var commentCount: String? = null
        @Bindable get() = field
        set(value) {
            field = value
            notifyPropertyChanged(BR.commentCount)
        }

    var reviewCount: String? = null
        @Bindable get() = field
        set(value) {
            field = value
            notifyPropertyChanged(BR.reviewCount)
        }

    var location: String? = null
        @Bindable get() = field
        set(value) {
            field = value
            notifyPropertyChanged(BR.location)
        }

    var rating: String? = null
        @Bindable get() = field
        set(value) {
            field = value
            notifyPropertyChanged(BR.rating)
        }

    var description: String? = null
        @Bindable get() = field
        set(value) {
            field = value
            notifyPropertyChanged(BR.description)
        }

    var descriptionMore: String? = null
        @Bindable get() = field
        set(value) {
            field = value
            notifyPropertyChanged(BR.descriptionMore)
        }


    fun getPocha() {

        val pocha = Pocha()
        title = pocha.title
        commentCount = "사장님 댓글 ${pocha.commentCount}"
        reviewCount = "리뷰 ${pocha.reviewCount}"
        location = pocha.location
        rating = pocha.rating.toString()
        isLiked = pocha.isLiked
        description = pocha.description
        descriptionMore = pocha.descriptionMore
    }

    fun getMenus(): LiveData<List<Menu>> {
        val result = ArrayList<Menu>()
        result.add(Menu())
        result.add(Menu())
        result.add(Menu())
        result.add(Menu())

        return MutableLiveData<List<Menu>>().apply { value = result }
    }
}