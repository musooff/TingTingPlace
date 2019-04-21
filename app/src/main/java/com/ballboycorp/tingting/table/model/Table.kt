package com.ballboycorp.tingting.table.model

import android.os.Parcelable
import com.ballboycorp.tingting.profile.model.User
import kotlinx.android.parcel.Parcelize
import java.util.*
import kotlin.collections.ArrayList

/**
 * Created by musooff on 2019-04-20.
 */

@Parcelize
class Table (
    var tableNumber: Int = Random().nextInt(10) + 1,
    var maleCount: Int = Random().nextInt(4),
    var femaleCount: Int = Random().nextInt(4),
    var hashTag: String? = "헌팅안함",
    var people: ArrayList<User> = arrayListOf()
): Parcelable {
    fun addTestPeople() {
            for (i in 1..maleCount) {
                people.add(User(
                        gender = 0
                ))
            }
            for (i in 1..femaleCount) {
                people.add(User(
                        gender = 1
                ))
            }
    }
}