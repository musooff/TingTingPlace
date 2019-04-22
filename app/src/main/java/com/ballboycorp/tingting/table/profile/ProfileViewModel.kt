package com.ballboycorp.tingting.table.profile

import androidx.databinding.Bindable
import com.ballboycorp.tingting.BR
import com.ballboycorp.tingting.base.BaseObservableViewModel
import com.ballboycorp.tingting.table.model.TableItemViewModel

/**
 * Created by musooff on 2019-04-21.
 */

class ProfileViewModel: BaseObservableViewModel() {

    var tableItemViewModel: TableItemViewModel? = null

    var gameSelectionMode: Boolean = false
        @Bindable get() = field
        set(value) {
            field = value
            notifyPropertyChanged(BR.gameSelectionMode)
        }

    var chatSelectionMode: Boolean = false
        @Bindable get() = field
        set(value) {
            field = value
            notifyPropertyChanged(BR.chatSelectionMode)
        }
    var guide: String? = null
        @Bindable get() = field
        set(value) {
            field = value
            notifyPropertyChanged(BR.guide)
        }

    fun updateGuide() {
        when {
            chatSelectionMode -> guide = "채팅을 하고 싶은 상대를 선택하세요"
            gameSelectionMode -> guide = "게임을 신청하고 싶은 상대를 선택하세요"
            else -> guide = null
        }

    }

    fun onClickChat() {
        chatSelectionMode = true
        updateGuide()
    }

    fun onClickGame() {
        gameSelectionMode = true
        updateGuide()
    }

    fun onClickCancel() {
        chatSelectionMode = false
        gameSelectionMode = false
        updateGuide()
    }
}