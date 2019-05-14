package com.ballboycorp.tingting.pocha

import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.databinding.Bindable
import androidx.databinding.BindingAdapter
import com.ballboycorp.tingting.BR
import com.ballboycorp.tingting.R
import com.ballboycorp.tingting.base.BaseObservableViewModel

/**
 * Created by musooff on 2019-05-12.
 */

class PochaViewModel: BaseObservableViewModel() {

    companion object {
        @JvmStatic
        @BindingAdapter("app:home_tab_index")
        fun setHomeTabItems(constraintLayout: ConstraintLayout, tabIndex: Int) {
            when (tabIndex) {
                0 -> {
                    (constraintLayout.getViewById(R.id.text_tab_title) as TextView).text = "홈"
                    (constraintLayout.getViewById(R.id.iv_tab_thumb) as ImageView).setImageResource(R.drawable.ic_home_black)
                }
                1 -> {
                    (constraintLayout.getViewById(R.id.text_tab_title) as TextView).text = "게임"
                    (constraintLayout.getViewById(R.id.iv_tab_thumb) as ImageView).setImageResource(R.drawable.ic_game)
                }
                2 -> {
                    (constraintLayout.getViewById(R.id.text_tab_title) as TextView).text = "메세지"
                    (constraintLayout.getViewById(R.id.iv_tab_thumb) as ImageView).setImageResource(R.drawable.ic_message)
                }
            }
        }
    }

    var notCounts: MutableList<Int> = mutableListOf(0, 0, 0)
        @Bindable get() = field
        set(value) {
            field = value
            notifyPropertyChanged(BR.notCounts)
        }
}