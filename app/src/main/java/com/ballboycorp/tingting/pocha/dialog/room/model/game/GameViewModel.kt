package com.ballboycorp.tingting.pocha.dialog.room.model.game

import androidx.databinding.Bindable
import com.ballboycorp.tingting.BR
import com.ballboycorp.tingting.base.BaseObservableViewModel

/**
 * Created by musooff on 2019-04-23.
 */

class GameViewModel(val game: Game): BaseObservableViewModel() {

    var id: Int = game.id
        @Bindable get() = field
        set(value) {
            field = value
            notifyPropertyChanged(BR.id)
        }

    var title = game.title
        @Bindable get() = field
        set(value) {
            field = value
            notifyPropertyChanged(BR.title)
        }

    var isSelected: Boolean = false
        @Bindable get() = field
        set(value) {
            field = value
            notifyPropertyChanged(BR.selected)
        }

}