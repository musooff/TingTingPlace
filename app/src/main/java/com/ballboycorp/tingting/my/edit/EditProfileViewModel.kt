package com.ballboycorp.tingting.my.edit

import android.net.Uri
import androidx.databinding.Bindable
import com.ballboycorp.tingting.BR
import com.ballboycorp.tingting.base.BaseObservableViewModel
import com.ballboycorp.tingting.my.model.User

/**
 * Created by musooff on 16/04/2019.
 */

class EditProfileViewModel: BaseObservableViewModel() {

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

    var canSave: Boolean = false
        @Bindable get() = field
        set(value) {
            field = value
            notifyPropertyChanged(BR.canSave)
        }

    var thumb: Uri? = null
        @Bindable get() = field
        set(value) {
            field = value
            notifyPropertyChanged(BR.thumb)
        }

    var user: User? = null

    private fun verifyNickName(string: String?) {
        if (string == null || string.length < 2 || string.length > 8) {
            guide = "2~8자 한글 또는 영문으로 입력 하세요."
            isValidNickname = false
        } else {
            guide = null
            isValidNickname = true
        }
        verifyCanSave()
    }

    fun verifyCanSave() {
        canSave = gender != -1 && isValidNickname
    }

    fun getUser() {
        user = appPref.getUser()
        user?.let {
            nickname = it.nickname
            thumb = it.thumbnail?.let { Uri.parse(it) }
            gender = it.gender
        }
    }

    fun saveUser() {
        val newUser = User()
        newUser.thumbnail = thumb?.toString()
        newUser.nickname = nickname
        newUser.gender = gender

        appPref.setUser(newUser)
    }
}