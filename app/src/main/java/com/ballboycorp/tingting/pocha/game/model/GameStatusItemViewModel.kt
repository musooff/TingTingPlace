package com.ballboycorp.tingting.pocha.game.model

import com.ballboycorp.tingting.pocha.dialog.room.model.bet.BetItemViewModel
import com.ballboycorp.tingting.pocha.dialog.room.model.game.GameItemViewModel
import com.ballboycorp.tingting.profile.model.UserViewModel
import com.ballboycorp.tingting.table.model.TableItemViewModel

/**
 * Created by musooff on 2019-04-28.
 */

class GameStatusItemViewModel(val gameStatus: GameStatus) {

    var game = gameStatus.game?.let { GameItemViewModel(it) }

    var bet = gameStatus.bet?.let { BetItemViewModel(it) }

    var table = gameStatus.table?.let { TableItemViewModel(it) }

    var userIndex = gameStatus.userIndex

    var status = gameStatus.status

    var user = table!!.people[userIndex]
}