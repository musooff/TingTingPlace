package com.ballboycorp.tingting.shop.model

import com.ballboycorp.tingting.billing.model.ChattingSkuDetails

/**
 * Created by musooff on 2019-05-11.
 */

class ShopItem(
        var id: Long = 0,
        var duration: Int = 0,
        var amount : Int = 0,
        var price: String? = null,
        var chattingSkuDetails: ChattingSkuDetails? = null

)