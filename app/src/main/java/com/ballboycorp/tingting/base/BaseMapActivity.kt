package com.ballboycorp.tingting.base

import net.daum.mf.map.api.MapPoint
import net.daum.mf.map.api.MapReverseGeoCoder
import net.daum.mf.map.api.MapView

/**
 * Created by musooff on 2019-05-05.
 */

open class BaseMapActivity : BaseActivity(), MapView.MapViewEventListener, MapView.OpenAPIKeyAuthenticationResultListener, MapView.CurrentLocationEventListener, MapReverseGeoCoder.ReverseGeoCodingResultListener {
    override fun onReverseGeoCoderFailedToFindAddress(mapReverseGeoCoder: MapReverseGeoCoder?) {
    }

    override fun onReverseGeoCoderFoundAddress(mapReverseGeoCoder: MapReverseGeoCoder?, s: String?) {
    }

    override fun onCurrentLocationUpdateFailed(mapView: MapView?) {
    }

    override fun onCurrentLocationUpdate(mapView: MapView, mapPoint: MapPoint, accuracyInMeters: Float) {
    }

    override fun onCurrentLocationUpdateCancelled(mapView: MapView?) {
    }

    override fun onCurrentLocationDeviceHeadingUpdate(mapView: MapView?, p1: Float) {
    }

    override fun onDaumMapOpenAPIKeyAuthenticationResult(mapView: MapView?, p1: Int, p2: String?) {
    }

    override fun onMapViewDoubleTapped(mapView: MapView, p1: MapPoint) {
    }

    override fun onMapViewInitialized(mapView: MapView) {
    }

    override fun onMapViewDragStarted(mapView: MapView, p1: MapPoint) {
    }

    override fun onMapViewMoveFinished(mapView: MapView, p1: MapPoint) {
    }

    override fun onMapViewCenterPointMoved(mapView: MapView, p1: MapPoint) {
    }

    override fun onMapViewDragEnded(mapView: MapView, mapPoint: MapPoint) {
    }

    override fun onMapViewSingleTapped(mapView: MapView, mapPoint: MapPoint) {
    }

    override fun onMapViewZoomLevelChanged(mapView: MapView, p1: Int) {
    }

    override fun onMapViewLongPressed(mapView: MapView, p1: MapPoint) {
    }
}