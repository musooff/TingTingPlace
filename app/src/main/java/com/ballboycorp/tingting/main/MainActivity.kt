package com.ballboycorp.tingting.main

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import com.ballboycorp.tingting.R
import com.ballboycorp.tingting.base.BaseActivity
import com.ballboycorp.tingting.databinding.ActivityMainBinding

/**
 * Created by musooff on 07/04/2019.
 */

class MainActivity: BaseActivity() {

    companion object {

        fun newIntent(context: Context) {
            val intent = Intent(context, MainActivity::class.java)
            context.startActivity(intent)
        }
    }

    private val viewModel by lazy {
        ViewModelProviders
                .of(this)
                .get(MainViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)
    }
}