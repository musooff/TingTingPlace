package com.ballboycorp.tingting.main.pocha.nearby.choose

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.core.os.bundleOf
import com.ballboycorp.tingting.R
import com.ballboycorp.tingting.base.BaseMapActivity
import com.ballboycorp.tingting.databinding.ActivityChooseLocationBinding
import com.ballboycorp.tingting.utils.extensions.bind
import com.ballboycorp.tingting.utils.extensions.getViewModel
import kotlinx.android.synthetic.main.activity_choose_location.*
import net.daum.mf.map.api.MapPoint
import net.daum.mf.map.api.MapReverseGeoCoder
import net.daum.mf.map.api.MapView

/**
 * Created by musooff on 2019-05-05.
 */

class ChooseLocationActivity : BaseMapActivity() {

    companion object {
        const val LONGITUDE = "longitude"
        const val LATITUDE = "latitude"

        private val CUSTOM_MARKER_POINT = MapPoint.mapPointWithGeoCoord(37.537229, 127.005515)
    }

    private val viewModel by lazy { getViewModel<ChooseLocationViewModel>() }
    private val mMapView by lazy { MapView(this) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = bind<ActivityChooseLocationBinding>(R.layout.activity_choose_location)
        binding.clickHandler = ClickHandler()
        binding.viewModel = viewModel

        initCustomToolbar(toolbar)

        initialize()
    }

    override fun onDestroy() {
        super.onDestroy()
        container_map.removeAllViews()
    }

    private fun initialize() {

        mMapView.setOpenAPIKeyAuthenticationResultListener(this)
        mMapView.setMapViewEventListener(this)
        mMapView.mapType = MapView.MapType.Standard

        mMapView.setCurrentLocationEventListener(this)
        container_map.addView(mMapView)

    }

    override fun onMapViewInitialized(mapView: MapView) {
        mapView.setMapCenterPointAndZoomLevel(CUSTOM_MARKER_POINT, 2, true)
        iv_map_marker.visibility = View.VISIBLE
        val reverseGeoCoder = MapReverseGeoCoder(getString(R.string.kakao_app_key), mMapView.mapCenterPoint, this, this)
        reverseGeoCoder.startFindingAddress()
    }

    override fun onMapViewDragEnded(mapView: MapView, mapPoint: MapPoint) {
        val reverseGeoCoder = MapReverseGeoCoder(getString(R.string.kakao_app_key), mMapView.mapCenterPoint, this, this)
        reverseGeoCoder.startFindingAddress()
    }

    override fun onReverseGeoCoderFoundAddress(mapReverseGeoCoder: MapReverseGeoCoder?, s: String?) {
        viewModel.location = s
    }

    override fun onReverseGeoCoderFailedToFindAddress(mapReverseGeoCoder: MapReverseGeoCoder?) {
        viewModel.location = null
    }

    inner class ClickHandler {
        fun onClickSelect() {
            setResult(Activity.RESULT_OK, Intent().apply {
                putExtra(LONGITUDE, mMapView.mapCenterPoint.mapPointGeoCoord.longitude)
                putExtra(LATITUDE,  mMapView.mapCenterPoint.mapPointGeoCoord.latitude)
            })
            finish()
        }

        fun onClickExit() {
            setResult(Activity.RESULT_CANCELED)
            finish()
        }
    }
}