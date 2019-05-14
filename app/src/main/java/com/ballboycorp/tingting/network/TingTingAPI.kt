package com.ballboycorp.tingting.network

import com.ballboycorp.tingting.main.pocha.model.Pocha
import com.ballboycorp.tingting.main.pocha.region.model.Area
import io.reactivex.Observable
import io.reactivex.Single
import okhttp3.ResponseBody
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Created by musooff on 2019-05-13.
 */

interface TingTingAPI {

    @GET("getLocationList.php")
    fun locations(): Single<Area.AreaResult>

    @GET("getNearByRestaurants.php")
    fun nearbyRestaurants(@Query("longitude") longitude: Double, @Query("latitude") latitude: Double): Single<List<Pocha>>

    @GET("getRestaurantList.php")
    fun searchRestaurants(@Query("searchKey") searchKey: String): Single<List<Pocha>>

}