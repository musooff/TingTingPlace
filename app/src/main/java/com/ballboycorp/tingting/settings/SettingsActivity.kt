package com.ballboycorp.tingting.settings

import android.os.Bundle
import com.ballboycorp.tingting.R
import com.ballboycorp.tingting.base.BaseActivity
import com.ballboycorp.tingting.databinding.ActivitySettingsBinding
import com.ballboycorp.tingting.utils.extensions.bind

/**
 * Created by musooff on 18/04/2019.
 */

class SettingsActivity: BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = bind<ActivitySettingsBinding>(R.layout.activity_settings)
        initToolbar("환경설정", true)

    }

    inner class ClickHandler {
        fun onClickMessageNot() {

        }

        fun onClickGameNot() {

        }

        fun onClickEventNot() {

        }
    }
}