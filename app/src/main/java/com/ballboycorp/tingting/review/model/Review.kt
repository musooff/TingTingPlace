package com.ballboycorp.tingting.review.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

/**
 * Created by musooff on 14/04/2019.
 */

@Parcelize
class Review(
        var nickname: String? = "닉네임",
        var description: String? = "분위기 너무 재밌고 맨날 가고싶어요~!",
        var time: String? = "12시간전"
) : Parcelable