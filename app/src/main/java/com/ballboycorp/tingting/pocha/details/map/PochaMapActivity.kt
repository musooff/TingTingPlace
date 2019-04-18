package com.ballboycorp.tingting.pocha.details.map

import android.os.Bundle
import com.ballboycorp.tingting.R
import com.ballboycorp.tingting.base.BaseActivity
import com.ballboycorp.tingting.databinding.ActivityPochaMapBinding
import com.ballboycorp.tingting.utils.extensions.bind
/**
 * Created by musooff on 18/04/2019.
 */

class PochaMapActivity: BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = bind<ActivityPochaMapBinding>(R.layout.activity_pocha_map)
        initToolbar("지도", true)

    }
}