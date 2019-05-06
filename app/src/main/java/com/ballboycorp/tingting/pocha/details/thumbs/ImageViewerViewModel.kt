package com.ballboycorp.tingting.pocha.details.thumbs

import androidx.databinding.Bindable
import com.ballboycorp.tingting.BR
import com.ballboycorp.tingting.base.BaseObservableViewModel

/**
 * Created by musooff on 2019-05-06.
 */

class ImageViewerViewModel: BaseObservableViewModel() {

    var title: String? = null
        @Bindable get() = field
        set(value) {
            field = value
            notifyPropertyChanged(BR.title)
        }

    var thumbs: List<String> = arrayListOf()
        @Bindable get() = field
        set(value) {
            field = value
            notifyPropertyChanged(BR.thumbs)
        }

    var currentItem: Int = 0
        @Bindable get() = field
        set(value) {
            field = value
            notifyPropertyChanged(BR.currentItem)
        }
}