package com.ballboycorp.tingting.table.nearby.profile

import androidx.databinding.Bindable
import com.ballboycorp.tingting.BR
import com.ballboycorp.tingting.base.BaseObservableViewModel
import com.ballboycorp.tingting.table.model.TableItemViewModel

/**
 * Created by musooff on 2019-04-23.
 */

class NearbyProfileViewModel: BaseObservableViewModel() {

    var tableItemViewModel: TableItemViewModel? = null


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
            else -> guide = null
        }

    }

    fun onClickChat() {
        chatSelectionMode = true
        updateGuide()
    }

    fun onClickCancel() {
        chatSelectionMode = false
        updateGuide()
    }
}
