package com.ballboycorp.tingting.pocha.home.description

import android.os.Bundle
import com.ballboycorp.tingting.R
import com.ballboycorp.tingting.base.BaseActivity
import com.ballboycorp.tingting.databinding.ActivityGameGiftDescriptionBinding
import com.ballboycorp.tingting.utils.extensions.bind

/**
 * Created by musooff on 2019-04-21.
 */

class GameGiftDescriptionActivity: BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = bind<ActivityGameGiftDescriptionBinding>(R.layout.activity_game_gift_description)
        initToolbar("게임/선물 내역", true)
    }
}