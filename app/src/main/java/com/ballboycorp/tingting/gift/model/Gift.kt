package com.ballboycorp.tingting.gift.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

/**
 * Created by musooff on 2019-04-28.
 */

@Parcelize
class Gift (
        var id: Int = 0,
        var title: String? = "참이슬",
        var price: String? = "4,000"
): Parcelable