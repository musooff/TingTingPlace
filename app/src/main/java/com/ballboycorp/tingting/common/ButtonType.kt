package com.ballboycorp.tingting.common

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.ballboycorp.tingting.R

/**
 * Created by musooff on 08/04/2019.
 */

enum class ButtonType(val text: String, val iconDrawable: Int, val backgroundColor: Int) {
    QR_CODE("큐알코드 찍고 포차입장하기", R.drawable.ic_qr, R.color.colorRed);
    companion object {
        @JvmStatic
        @BindingAdapter("imageResource")
        fun setImageViewResource(imageView: ImageView, resource: Int) {
            imageView.setImageResource(resource)
        }
    }
}