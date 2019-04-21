package com.ballboycorp.tingting.table.model

import com.ballboycorp.tingting.R
import com.ballboycorp.tingting.base.BaseObservableViewModel
import com.ballboycorp.tingting.profile.model.User
import com.ballboycorp.tingting.profile.model.UserViewModel

/**
 * Created by musooff on 2019-04-20.
 */

class TableItemViewModel(val table: Table): BaseObservableViewModel() {

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