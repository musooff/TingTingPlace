package com.ballboycorp.tingting.review.add

import android.net.Uri
import android.widget.ImageView
import androidx.databinding.Bindable
import androidx.databinding.BindingAdapter
import com.ballboycorp.tingting.BR
import com.ballboycorp.tingting.R
import com.ballboycorp.tingting.base.BaseObservableViewModel
import com.bumptech.glide.Glide

/**
 * Created by musooff on 18/04/2019.
 */

class AddActivityViewModel: BaseObservableViewModel() {

    companion object {
        @JvmStatic
        @BindingAdapter("app:loadImageCameraBorder")
        fun loadImageCameraBorder(imageView: ImageView, uri: Uri?){
            Glide
                    .with(imageView.context)
                    .load(uri)
                    .placeholder(R.drawable.ic_camera_border)
                    .into(imageView)
        }
    }

    var rating: Float = 3.5f
        @Bindable get() = field
        set(value) {
            field = value
            notifyPropertyChanged(BR.rating)
        }

    var nickname: String? = "안녕하세요"
        @Bindable get() = field
        set(value) {
            field = value
            notifyPropertyChanged(BR.nickname)
        }

    var description: String? = null
        @Bindable get() = field
        set(value) {
            field = value
            verifyDescription(value)
            notifyPropertyChanged(BR.description)
        }

    var isValidDescription: Boolean = false
        @Bindable get() = field
        set(value) {
            field = value
            notifyPropertyChanged(BR.validDescription)
        }

    var canSubmit: Boolean = false
        @Bindable get() = field
        set(value) {
            field = value
            notifyPropertyChanged(BR.canSubmit)
        }

    var guide: String? = null
        @Bindable get() = field
        set(value) {
            field = value
            notifyPropertyChanged(BR.guide)
        }

    var pictures: ArrayList<Uri?> = arrayListOf(null, null, null)
        @Bindable get() = field

    var requestedImageIndex: Int = 0

    private fun verifyDescription(string: String?) {
        if (string == null || string.length < 10) {
            guide = "10자 이상 한글 또는 영문으로 입력해주세요!"
            isValidDescription = false
        } else {
            guide = null
            isValidDescription = true
        }
        verifyCanMoveNext()
    }

    fun verifyCanMoveNext() {
        canSubmit = isValidDescription
    }

    fun addPicture(source: Uri?) {
        if (pictures[requestedImageIndex] != null) {
            pictures[requestedImageIndex] = source
        }
        else {
            var addingIndex = 0
            while (pictures[addingIndex] != null) {
                addingIndex++
            }
            pictures[addingIndex] = source
        }
        notifyPropertyChanged(BR.pictures)
    }
}