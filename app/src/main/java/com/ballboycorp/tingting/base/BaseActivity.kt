package com.ballboycorp.tingting.base

import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.content.ContextCompat
import com.ballboycorp.tingting.R
import kotlinx.android.synthetic.main.toolbar.view.*

/**
 * Created by musooff on 07/04/2019.
 */

open class BaseActivity: AppCompatActivity() {

    fun customToolbar(toolbar: Toolbar, title: String, withBackButton: Boolean = false) {
        toolbar.tb_title.text = title
        setSupportActionBar(toolbar)
        if (withBackButton){
            supportActionBar?.setDisplayUseLogoEnabled(true)
            supportActionBar?.setDisplayShowHomeEnabled(true)
            toolbar.iv_back.visibility = View.VISIBLE

            toolbar.iv_back.setOnClickListener { onBackPressed() }
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}