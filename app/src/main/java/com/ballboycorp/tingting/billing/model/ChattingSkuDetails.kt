package com.ballboycorp.tingting.billing.model

data class ChattingSkuDetails(
        val canPurchase: Boolean,
        val sku: String,
        val type: String?,
        val price: String?,
        val title: String?,
        val description: String?,
        val originalJson: String?
) {

    object ChattingSku {
        val CHATTING_30_1 = "chatting_30_1"
        val CHATTING_30_2 = "chatting_30_2"
        val CHATTING_30_3 = "chatting_30_3"
        val CHATTING_60_1 = "chatting_60_1"
        val CHATTING_60_2 = "chatting_60_2"
        val CHATTING_60_3 = "chatting_60_3"

        val INAPP_SKUS = listOf(CHATTING_30_1, CHATTING_30_2, CHATTING_30_3, CHATTING_60_1, CHATTING_60_2, CHATTING_60_3)


    }
}