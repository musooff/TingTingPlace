package com.ballboycorp.tingting.contact.add

import androidx.databinding.Bindable
import com.ballboycorp.tingting.BR
import com.ballboycorp.tingting.base.BaseObservableViewModel

/**
 * Created by musooff on 18/04/2019.
 */

class NewQuestionViewModel: BaseObservableViewModel() {

    var title: String? = null
        @Bindable get() = field
        set(value) {
            field = value
            verifyTitle(value)
            notifyPropertyChanged(BR.title)
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
    var isValidTitle : Boolean = false

    private fun verifyTitle(string: String?) {
        if (string == null || string.length < 10) {
            guide = "문의하실 내용을 10자이상 작성해주세요."
            isValidTitle = false
        } else {
            guide = null
            isValidTitle = true
        }
        verifyCanSubmit()
    }

    fun verifyCanSubmit() {
        canSubmit = isValidTitle
    }
}