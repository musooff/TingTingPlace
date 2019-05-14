package com.ballboycorp.tingting.utils.extensions

import android.view.View

/**
 * Created by musooff on 2019-05-12.
 */

object Animation {

    fun moveUp(view: View, amount: Float, duration: Long) {
        val yPosition = view.y
        view.animate()
                .y(yPosition - amount)
                .setDuration(duration)
                .withEndAction {
                    view.hideView()
                    view.y = yPosition
                }
                .start()
    }

    fun moveDown(view: View, amount: Float, duration: Long) {
        val yPosition = view.y
        view.animate()
                .y(yPosition + amount)
                .setDuration(duration)
                .withEndAction {
                    view.hideView()
                    view.y = yPosition
                }
                .start()
    }

}