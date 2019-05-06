package com.ballboycorp.tingting.common.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.viewpager.widget.PagerAdapter
import com.ballboycorp.tingting.R
import kotlinx.android.synthetic.main.item_vp_image.view.*

/**
 * Created by musooff on 2019-05-05.
 */

class ImagePagerAdapter: PagerAdapter() {
    private var mImageUrls: List<String> = arrayListOf()

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view == `object` as LinearLayout
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val itemView = LayoutInflater.from(container.context).inflate(R.layout.item_vp_image, container, false)
        itemView.imageView.setImageResource(R.drawable.placeholder_thumb)
        container.addView(itemView)
        return itemView
    }

    override fun getCount(): Int {
        return mImageUrls.size
    }

    fun submitList(imageUrls: List<String>) {
        mImageUrls = imageUrls
        notifyDataSetChanged()
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(`object` as LinearLayout)
    }
}