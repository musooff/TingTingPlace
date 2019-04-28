package com.ballboycorp.tingting.pocha.dialog.room.model.bet

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

/**
 * Created by musooff on 2019-04-23.
 */

@Parcelize
class Bet (
    var id: Int = 0,
    var title: String? = "참이슬",
    var price: String? = "4,000"
): Parcelable