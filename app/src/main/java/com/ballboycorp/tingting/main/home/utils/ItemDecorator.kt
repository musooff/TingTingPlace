package com.ballboycorp.tingting.main.home.utils

import android.content.Context
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.DividerItemDecoration
import com.ballboycorp.tingting.R

/**
 * Created by musooff on 09/04/2019.
 */

object ItemDecorator {

    fun emptyHorizontal(context: Context): DividerItemDecoration {
        val decorator = DividerItemDecoration(context, DividerItemDecoration.HORIZONTAL)
        decorator.setDrawable(ContextCompat.getDrawable(context, R.drawable.empty_layout)!!)
        return decorator
    }
}