package com.ballboycorp.tingting.profile.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import kotlin.random.Random

/**
 * Created by musooff on 16/04/2019.
 */

@Parcelize
class User(
        var nickname: String? = "닉네임",
        var gender: Int = Random.nextInt(2),
        var thumbnail: String? = null,
        var coin: String? = "20"
) : Parcelable