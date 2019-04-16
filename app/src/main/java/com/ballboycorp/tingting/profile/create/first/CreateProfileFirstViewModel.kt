package com.ballboycorp.tingting.profile.create.first

import androidx.databinding.Bindable
import com.ballboycorp.tingting.BR
import com.ballboycorp.tingting.base.BaseObservableViewModel

/**
 * Created by musooff on 14/04/2019.
 */

class CreateProfileFirstViewModel : BaseObservableViewModel() {

    var gender: Int = -1
        @Bindable get() = field
        set(value) {
            field = value
            notifyPropertyChanged(BR.gender)
        }

    var nickname: String? = null
        @Bindable get() = field
        set(value) {
            field = value
            verifyNickName(value)
            notifyPropertyChanged(BR.nickname)
        }

    var isValidNickname: Boolean = false
        @Bindable get() = field
        set(value) {
            field = value
            notifyPropertyChanged(BR.validNickname)
        }
    var guide: String? = null
        @Bindable get() = field
        set(value) {
            field = value
            notifyPropertyChanged(BR.guide)
        }

    var canMoveNext: Boolean = false
        @Bindable get() = field
        set(value) {
            field = value
            notifyPropertyChanged(BR.canMoveNext)
        }

    private fun verifyNickName(string: String?) {
        if (string == null || string.length < 2 || string.length > 8) {
            guide = "2~8자 한글 또는 영문으로 입력 하세요."
            isValidNickname = false
        } else {
            guide = null
            isValidNickname = true
        }
        verifyCanMoveNext()
    }

    fun verifyCanMoveNext() {
        canMoveNext = gender != -1 && isValidNickname
    }
}