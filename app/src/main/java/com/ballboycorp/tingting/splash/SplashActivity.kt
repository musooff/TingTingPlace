package com.ballboycorp.tingting.splash

import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import com.ballboycorp.tingting.R
import com.ballboycorp.tingting.base.BaseActivity
import com.ballboycorp.tingting.databinding.ActivitySplashBinding
import com.ballboycorp.tingting.main.MainActivity
import com.ballboycorp.tingting.utils.extensions.observeIfTrue

/**
 * Created by musooff on 07/04/2019.
 */

class SplashActivity: BaseActivity() {

    private val viewModel by lazy {
        ViewModelProviders
                .of(this)
                .get(SplashViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = DataBindingUtil.setContentView<ActivitySplashBinding>(this, R.layout.activity_splash)
        binding.viewModel = viewModel

        initialize()
    }

    private fun initialize() {

        viewModel.mainPageRequest.observeIfTrue(this) {
            MainActivity.newIntent(this)
            finish()
        }

        viewModel.openMainPage()
    }

}