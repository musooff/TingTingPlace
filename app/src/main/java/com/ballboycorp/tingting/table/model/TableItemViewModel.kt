package com.ballboycorp.tingting.table.model

import androidx.databinding.BindingAdapter
import com.ballboycorp.tingting.R
import com.ballboycorp.tingting.base.BaseObservableViewModel
import com.ballboycorp.tingting.main.pocha.model.PochaItemViewModel
import com.ballboycorp.tingting.profile.model.UserViewModel
import com.mikhaellopez.circularimageview.CircularImageView

/**
 * Created by musooff on 2019-04-20.
 */

class TableItemViewModel(val table: Table): BaseObservableViewModel() {

    companion object {
        @JvmStatic
        @BindingAdapter("app:gender")
        fun setGender(imageView: CircularImageView, gender: Int) {
            when (gender) {
                0 -> imageView.setBorderColor(R.color.colorBlue)
                1 -> imageView.setBorderColor(R.color.colorRed)
                else -> imageView.setBorderColor(R.color.colorWhite)

            }
        }
    }
    var pocha: PochaItemViewModel = PochaItemViewModel(table.pocha)
    var tableNumber: Int = table.tableNumber
    var maleCount: Int = table.maleCount
    var femaleCount: Int = table.femaleCount
    var hashTag: String? = table.hashTag
    var people: List<UserViewModel> = table.people.map { UserViewModel(it) }


    var backgroundRecourseId: Int = when {
        maleCount == 0 -> R.drawable.shape_rectangle_outline_red_4
        femaleCount == 0 -> R.drawable.shape_rectangle_outline_blue_4
        else -> R.drawable.shape_rectangle_outline_green_4
    }



}