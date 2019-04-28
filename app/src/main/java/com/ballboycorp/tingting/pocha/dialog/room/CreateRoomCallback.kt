package com.ballboycorp.tingting.pocha.dialog.room

import com.ballboycorp.tingting.pocha.dialog.room.model.game.Game
import com.ballboycorp.tingting.pocha.dialog.room.model.bet.Bet

/**
 * Created by musooff on 2019-04-25.
 */

interface CreateRoomCallback {
    fun onCreateRoom(game: Game, bet: Bet, isRandomJoin: Boolean)
}