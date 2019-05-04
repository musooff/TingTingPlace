package com.ballboycorp.tingting.base

import android.content.pm.ActivityInfo
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.content.ContextCompat
import com.ballboycorp.tingting.R
import com.ballboycorp.tingting.utils.PermissionUtils
import kotlinx.android.synthetic.main.toolbar.*
import kotlinx.android.synthetic.main.toolbar.view.*

/**
 * Created by musooff on 07/04/2019.
 */

open class BaseActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
    }

    fun initToolbar(title: String, withBackButton: Boolean = false) {
        toolbar.tb_title.text = title
        setSupportActionBar(toolbar)
        if (withBackButton){
            toolbar.iv_back.visibility = View.VISIBLE
            toolbar.iv_back.setOnClickListener { onBackPressed() }
        }
    }

    fun initCustomToolbar(toolbar: Toolbar) {
        setSupportActionBar(toolbar)
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        PermissionUtils.onRequestPermissionsResult(requestCode, permissions, grantResults)

    }
}