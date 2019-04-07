package com.ballboycorp.tingting.utils.preference

import android.content.Context

/**
 * Created by musooff on 07/04/2019.
 */

class ApplicationPreference(context: Context) {

    companion object {
        @Volatile
        private var INSTANCE: ApplicationPreference? = null

        fun getInstance(context: Context) =
                INSTANCE
                        ?: ApplicationPreference(context)
                                .also {
                                    INSTANCE = it
                                }
    }
}