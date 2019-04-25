package com.ballboycorp.tingting.common.dialog

/**
 * Created by musooff on 2019-04-23.
 */

interface YesNoCallback {

    fun onYes(reason: String)

    fun onNo(reason: String) {}
}