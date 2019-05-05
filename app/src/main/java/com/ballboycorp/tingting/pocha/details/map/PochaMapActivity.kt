package com.ballboycorp.tingting.pocha.details.map

import android.os.Bundle
import com.ballboycorp.tingting.R
import com.ballboycorp.tingting.base.BaseMapActivity
import com.ballboycorp.tingting.databinding.ActivityPochaMapBinding
import com.ballboycorp.tingting.utils.MapUtils.createCustomMarker
import com.ballboycorp.tingting.utils.PermissionUtils
import com.ballboycorp.tingting.utils.extensions.bind
import com.ballboycorp.tingting.utils.extensions.copyToClipBoard
import com.ballboycorp.tingting.utils.extensions.getViewModel
import com.ballboycorp.tingting.utils.extensions.showSnackBar
import kotlinx.android.synthetic.main.activity_pocha_map.*
import net.daum.mf.map.api.MapPoint
import net.daum.mf.map.api.MapView

/**
 * Created by musooff on 18/04/2019.
 */

class PochaMapActivity: BaseMapActivity() {

    private val mMapView by lazy { MapView(this) }

    private val viewModel by lazy { getViewModel<PochaMapViewModel>() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = bind<ActivityPochaMapBinding>(R.layout.activity_pocha_map)
        binding.clickHandler = ClickHandler()
        binding.viewModel = viewModel
        initToolbar("지도", true)

        initialize()

    }

    override fun onPause() {
        super.onPause()
        container_map.removeAllViews()
    }

    override fun onDestroy() {
        super.onDestroy()
        turnOffTracking()
    }

    override fun onResume() {
        super.onResume()
        container_map.addView(mMapView)
    }

    private fun initialize() {

        mMapView.setOpenAPIKeyAuthenticationResultListener(this)
        mMapView.setMapViewEventListener(this)
        mMapView.mapType = MapView.MapType.Standard

        mMapView.setCurrentLocationEventListener(this)


    }

    override fun onMapViewInitialized(mapView: MapView) {
        val mapPoint = MapPoint.mapPointWithGeoCoord(viewModel.pocha.latitude, viewModel.pocha.longtitude)
        mapView.setMapCenterPointAndZoomLevel(mapPoint, 2, true)
        createCustomMarker(mapView, mapPoint, viewModel.pocha.title)
    }

    override fun onCurrentLocationUpdate(mapView: MapView, mapPoint: MapPoint, accuracyInMeters: Float) {
        viewModel.currentLocation = mapPoint
    }

    inner class ClickHandler {

        fun onClickCopy() {
            copyToClipBoard(viewModel.pocha.location)
            showSnackBar(container_map, "클립보드에 주소가 복사되었습니다.")
        }

        fun onClickCurrentLocation() {
            PermissionUtils.requestLocation(this@PochaMapActivity, object : PermissionUtils.OnPermissionResult{
                override fun onResult(requestCode: Int, granted: Boolean, permissions: Array<out String>) {
                    if (granted) {
                        mMapView.currentLocationTrackingMode = MapView.CurrentLocationTrackingMode.TrackingModeOnWithoutHeading
                    }
                }
            })
        }

        fun onClickRestaurantLocation() {
            val mapPoint = MapPoint.mapPointWithGeoCoord(viewModel.pocha.latitude, viewModel.pocha.longtitude)
            mMapView.setMapCenterPointAndZoomLevel(mapPoint, 2, true)
            turnOffTracking()
        }
    }

    private fun turnOffTracking() {
        mMapView.currentLocationTrackingMode = MapView.CurrentLocationTrackingMode.TrackingModeOff
        mMapView.setShowCurrentLocationMarker(false)
    }
}