package com.ballboycorp.tingting.notice.model

import androidx.databinding.Bindable
import com.ballboycorp.tingting.BR
import com.ballboycorp.tingting.base.BaseObservableViewModel

/**
 * Created by musooff on 18/04/2019.
 */

class NoticeItemViewModel(notice: Notice): BaseObservableViewModel() {
    var id: Int = notice.id
    var header: String? = notice.header
        @Bindable get() = field
        set(value) {
            field = value
            notifyPropertyChanged(BR.header)
        }
    var title: String? = notice.title
        @Bindable get() = field
        set(value) {
            field = value
            notifyPropertyChanged(BR.title)
        }
    var time: String? = notice.time
        @Bindable get() = field
        set(value) {
            field = value
            notifyPropertyChanged(BR.time)
        }
    var content: String? = notice.content
        @Bindable get() = field
        set(value) {
            field = value
            notifyPropertyChanged(BR.content)
        }

    var isOpen: Boolean = false
        @Bindable get() = field
        set(value) {
            field = value
            notifyPropertyChanged(BR.open)
        }

}