package com.ballboycorp.tingting.pocha.dialog.room.model.game

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

/**
 * Created by musooff on 2019-04-23.
 */

@Parcelize
class Game(
        var id: Int = 0,
        var title: String? = "가위바위보"
): Parcelable