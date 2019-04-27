package com.ballboycorp.tingting.table.profile.dialog

import androidx.databinding.Bindable
import com.ballboycorp.tingting.BR
import com.ballboycorp.tingting.base.BaseObservableViewModel
import com.ballboycorp.tingting.pocha.dialog.room.model.game.Game
import com.ballboycorp.tingting.pocha.dialog.room.model.gift.Gift

/**
 * Created by musooff on 2019-04-26.
 */

class PreGameViewModel: BaseObservableViewModel() {

    var isRequestKind = true
        @Bindable get() = field
        set(value) {
            field = value
            updateState()
            notifyPropertyChanged(BR.requestKind)
        }

    var title: String? = null
        @Bindable get() = field
        set(value) {
            field = value
            notifyPropertyChanged(BR.title)
        }

    var countDownTime: Int = 10
        @Bindable get() = field
        set(value) {
            field = value
            notifyPropertyChanged(BR.countDownTime)
        }

    var isLoading = false
        @Bindable get() = field
        set(value) {
            field = value
            updateState()
            notifyPropertyChanged(BR.loading)
        }

    var game: Game? = null
        @Bindable get() = field
        set(value) {
            field = value
            notifyPropertyChanged(BR.game)
        }

    var gift: Gift? = null
        @Bindable get() = field
        set(value) {
            field = value
            notifyPropertyChanged(BR.gift)
        }

    fun updateState() {
        title = when {
            isLoading -> "신청중..."
            isRequestKind -> "게임신청"
            else -> "게임수락"
        }
    }
}