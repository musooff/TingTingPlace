package com.ballboycorp.tingting.pocha.game.model

import com.ballboycorp.tingting.pocha.dialog.room.model.bet.Bet
import com.ballboycorp.tingting.pocha.dialog.room.model.game.Game
import com.ballboycorp.tingting.table.model.Table
import kotlin.random.Random

/**
 * Created by musooff on 2019-04-27.
 */

class GameStatus {

    var game: Game? = Game()
    var bet: Bet? = Bet()
    var table: Table? = Table(maleCount = 2, femaleCount = 4).apply { addTestPeople() }
    var userIndex: Int = 2
    var status: Int = Random.nextInt(2)
}