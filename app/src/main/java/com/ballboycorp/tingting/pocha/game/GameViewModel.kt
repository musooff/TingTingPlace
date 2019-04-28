package com.ballboycorp.tingting.pocha.game

import com.ballboycorp.tingting.base.BaseObservableViewModel
import com.ballboycorp.tingting.pocha.game.model.GameStatus
import com.ballboycorp.tingting.pocha.game.model.GameStatusItemViewModel

/**
 * Created by musooff on 2019-04-21.
 */

class GameViewModel: BaseObservableViewModel() {

    var myRoom =  GameStatusItemViewModel(GameStatus())

    var lastGameWinner = GameStatusItemViewModel(GameStatus())
}