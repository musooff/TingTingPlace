package com.ballboycorp.tingting

import android.app.Application
import android.content.Context
import com.facebook.stetho.Stetho


/**
 * Created by musooff on 07/04/2019.
 */

class MainApplication: Application() {

    companion object {

        private lateinit var INSTANCE: MainApplication

        fun getContext() : Context {
            return INSTANCE.applicationContext
        }

    }

    override fun onCreate() {
        super.onCreate()
        INSTANCE = this
        Stetho.initializeWithDefaults(this)
    }
}