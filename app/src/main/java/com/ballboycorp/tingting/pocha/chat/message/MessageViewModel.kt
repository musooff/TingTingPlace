package com.ballboycorp.tingting.pocha.chat.message

import androidx.databinding.Bindable
import com.ballboycorp.tingting.BR
import com.ballboycorp.tingting.base.BaseObservableViewModel
import com.ballboycorp.tingting.my.model.User
import com.ballboycorp.tingting.my.model.UserViewModel

/**
 * Created by musooff on 2019-05-01.
 */

class MessageViewModel: BaseObservableViewModel() {

    var message: String? = null
        @Bindable get() = field
        set(value) {
            field = value
            canSend = !value.isNullOrBlank()
            notifyPropertyChanged(BR.message)
        }

    var canSend: Boolean = false
        @Bindable get() = field
        set(value) {
            field = value
            notifyPropertyChanged(BR.canSend)
        }

    var isAddMode: Boolean = false
        @Bindable get() = field
        set(value) {
            field = value
            notifyPropertyChanged(BR.addMode)
        }

    var receiver: UserViewModel? = UserViewModel(User())
        @Bindable get() = field
        set(value) {
            field = value
            notifyPropertyChanged(BR.receiver)
        }

    fun sendMessage() {
        message = null
    }
}