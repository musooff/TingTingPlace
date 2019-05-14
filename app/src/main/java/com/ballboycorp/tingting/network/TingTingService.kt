package com.ballboycorp.tingting.network

import com.facebook.stetho.okhttp3.StethoInterceptor
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import io.reactivex.schedulers.Schedulers
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Created by musooff on 2019-05-13.
 */

class TingTingService {

    companion object {

        private const val SERVER_BASE_URL = "http://tingtingplace.co.kr/api/"

        @Volatile
        private var api: TingTingAPI? = null

        fun getApi(): TingTingAPI =
                api ?: synchronized(this) {
                    api ?: startService(SERVER_BASE_URL)
                            .also { api = it }
                }

        private fun startService(baseUrl: String): TingTingAPI {

            val okHttpClient = OkHttpClient.Builder()
                    .addNetworkInterceptor(StethoInterceptor())
                    .build()

            val retrofit = Retrofit.Builder()
                    .baseUrl(baseUrl)
                    .addConverterFactory(
                            GsonConverterFactory
                                    .create()
                    )
                    .client(okHttpClient)
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.createWithScheduler(Schedulers.io()))
                    .build()

            return retrofit.create(TingTingAPI::class.java)

        }
    }

    fun locations() = getApi().locations()

    fun nearbyRestaurants(longitude: Double, latitude: Double) = getApi().nearbyRestaurants(longitude, latitude)
}