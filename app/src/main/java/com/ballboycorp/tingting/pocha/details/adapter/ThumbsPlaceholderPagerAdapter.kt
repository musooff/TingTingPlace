package com.ballboycorp.tingting.pocha.details.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.viewpager.widget.PagerAdapter
import com.ballboycorp.tingting.R
import com.ballboycorp.tingting.pocha.details.thumbs.ImageViewerActivity
import com.ballboycorp.tingting.utils.extensions.startActivity

/**
 * Created by musooff on 2019-05-06.
 */

class ThumbsPlaceholderPagerAdapter: PagerAdapter() {
    private var mTitle: String? = null
    private var mImageUrls: List<String> = arrayListOf()

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view == `object` as LinearLayout
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val itemView = LayoutInflater.from(container.context).inflate(R.layout.item_vp_image, container, false)
        itemView.setOnClickListener {
            container.context.startActivity<ImageViewerActivity>(
                    ImageViewerActivity.TITLE to mTitle,
                    ImageViewerActivity.THUMBS to mImageUrls
            )
        }
        container.addView(itemView)
        return itemView
    }

    override fun getCount(): Int {
        return mImageUrls.size
    }

    fun submitList(title: String?, imageUrls: List<String>) {
        mTitle = title
        mImageUrls = imageUrls
        notifyDataSetChanged()
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(`object` as LinearLayout)
    }
}