/**
 * Copyright (C) 2018 Google Inc. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.ballboycorp.tingting.billing

import android.app.Activity
import android.app.Application
import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.android.billingclient.api.BillingClient
import com.android.billingclient.api.BillingClientStateListener
import com.android.billingclient.api.BillingFlowParams
import com.android.billingclient.api.BillingResult
import com.android.billingclient.api.Purchase
import com.android.billingclient.api.PurchasesUpdatedListener
import com.android.billingclient.api.SkuDetails
import com.android.billingclient.api.SkuDetailsParams
import com.ballboycorp.tingting.billing.model.ChattingSkuDetails
import com.ballboycorp.tingting.utils.extensions.showToast
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class BillingRepository private constructor(private val application: Application) :
        PurchasesUpdatedListener, BillingClientStateListener {

    private lateinit var playStoreBillingClient: BillingClient

    val inappSkuDetailsListLiveData: MutableLiveData<List<ChattingSkuDetails>> = MutableLiveData()

    fun startDataSourceConnections() {
        Log.d(LOG_TAG, "startDataSourceConnections")
        instantiateAndConnectToPlayBillingService()
    }

    fun endDataSourceConnections() {
        playStoreBillingClient.endConnection()
    }

    private fun instantiateAndConnectToPlayBillingService() {
        playStoreBillingClient = BillingClient.newBuilder(application.applicationContext)
                .enablePendingPurchases() // required or app will crash
                .setListener(this)
                .build()
        connectToPlayBillingService()
    }

    private fun connectToPlayBillingService(): Boolean {
        Log.d(LOG_TAG, "connectToPlayBillingService")
        if (!playStoreBillingClient.isReady) {
            playStoreBillingClient.startConnection(this)
            return true
        }
        return false
    }

    override fun onBillingSetupFinished(billingResult: BillingResult) {
        when (billingResult.responseCode) {
            BillingClient.BillingResponseCode.OK -> {
                Log.d(LOG_TAG, "onBillingSetupFinished successfully")
                querySkuDetailsAsync(BillingClient.SkuType.INAPP, ChattingSku.INAPP_SKUS)
            }
            BillingClient.BillingResponseCode.BILLING_UNAVAILABLE -> {
                Log.d(LOG_TAG, billingResult.debugMessage)
            }
            else -> {
                Log.d(LOG_TAG, billingResult.debugMessage)
            }
        }
    }

    override fun onBillingServiceDisconnected() {
        Log.d(LOG_TAG, "onBillingServiceDisconnected")
        connectToPlayBillingService()
    }

    private fun querySkuDetailsAsync(
            @BillingClient.SkuType skuType: String,
            skuList: List<String>) {
        val params = SkuDetailsParams.newBuilder().setSkusList(skuList).setType(skuType).build()
        Log.d(LOG_TAG, "querySkuDetailsAsync for $skuType")
        playStoreBillingClient.querySkuDetailsAsync(params) { billingResult, skuDetailsList ->
            when (billingResult.responseCode) {
                BillingClient.BillingResponseCode.OK -> {
                    if (skuDetailsList.orEmpty().isNotEmpty()) {
                        skuDetailsList.forEach { _ ->
                            CoroutineScope(Job() + Dispatchers.IO).launch {
                                inappSkuDetailsListLiveData.postValue(skuDetailsList.map {
                                    ChattingSkuDetails(
                                            canPurchase = true,
                                            sku = it.sku,
                                            type = it.type,
                                            price = it.price,
                                            title = it.title,
                                            description = it.description,
                                            originalJson = it.toString().substring("SkuDetails: ".length)
                                    )

                                })
                            }
                        }
                    }
                }
                else -> {
                    Log.e(LOG_TAG, billingResult.debugMessage)
                }
            }
        }
    }

    fun launchBillingFlow(activity: Activity, chattingSkuDetails: ChattingSkuDetails) =
            launchBillingFlow(activity, SkuDetails(chattingSkuDetails.originalJson))

    fun launchBillingFlow(activity: Activity, skuDetails: SkuDetails) {
        val purchaseParams = BillingFlowParams.newBuilder()
                .setSkuDetails(skuDetails)
                .build()
        playStoreBillingClient.launchBillingFlow(activity, purchaseParams)
    }

    override fun onPurchasesUpdated(
            billingResult: BillingResult,
            purchases: MutableList<Purchase>?
    ) {
        when (billingResult.responseCode) {
            BillingClient.BillingResponseCode.OK -> {
                purchases?.apply {
                    this@BillingRepository.application.applicationContext.showToast("haha")
                }
            }
            BillingClient.BillingResponseCode.ITEM_ALREADY_OWNED -> {
                Log.d(LOG_TAG, billingResult.debugMessage)
            }
            BillingClient.BillingResponseCode.SERVICE_DISCONNECTED -> {
                connectToPlayBillingService()
            }
            else -> {
                Log.i(LOG_TAG, billingResult.debugMessage)
            }
        }
    }


    companion object {
        private const val LOG_TAG = "BillingRepository"

        @Volatile
        private var INSTANCE: BillingRepository? = null

        fun getInstance(application: Application): BillingRepository =
                INSTANCE ?: synchronized(this) {
                    INSTANCE
                            ?: BillingRepository(application)
                                    .also { INSTANCE = it }
                }
    }

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

