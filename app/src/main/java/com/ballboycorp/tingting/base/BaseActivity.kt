package com.ballboycorp.tingting.base

import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.ballboycorp.tingting.R

/**
 * Created by musooff on 07/04/2019.
 */

open class BaseActivity: AppCompatActivity() {

    fun customToolbar(toolbar: Toolbar, withBackButton: Boolean = false) {

        setSupportActionBar(toolbar)
        if (withBackButton){
            supportActionBar?.setDisplayUseLogoEnabled(true)
            supportActionBar?.setDisplayShowHomeEnabled(true)
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}