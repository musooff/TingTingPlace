package com.ballboycorp.tingting.main.home.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager.widget.PagerAdapter
import android.widget.LinearLayout
import com.ballboycorp.tingting.R
import kotlinx.android.synthetic.main.item_vp_main.view.*


/**
 * Created by musooff on 09/04/2019.
 */

class ViewPagerAdapter: PagerAdapter() {
    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view == `object` as LinearLayout
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val itemView = LayoutInflater.from(container.context).inflate(R.layout.item_vp_main, container, false)
        itemView.imageView.setImageResource(R.drawable.image_vp_main)
        container.addView(itemView)
        return itemView
    }

    override fun getCount(): Int {
        return 5
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(`object` as LinearLayout)
    }
}