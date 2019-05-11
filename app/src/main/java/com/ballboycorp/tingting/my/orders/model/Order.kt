package com.ballboycorp.tingting.my.orders.model

import com.ballboycorp.tingting.shop.model.ShopItem
import java.util.*

/**
 * Created by musooff on 2019-05-11.
 */

class Order(
        var id: Long = 0,
        var shopItem: ShopItem? = null,
        var status: Int = 0,
        var boughtAt: Date? = null,
        var usedAt: Date? = Calendar.getInstance().time
)