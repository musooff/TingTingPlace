package com.ballboycorp.tingting.utils.extensions

import androidx.viewpager.widget.ViewPager

/**
 * Created by musooff on 18/04/2019.
 */

fun ViewPager.onPageChange(block: (Int) -> Unit) {
    this.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
        override fun onPageScrollStateChanged(state: Int) {
        }

        override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {
        }

        override fun onPageSelected(position: Int) {
            block(position)
        }
    })
}