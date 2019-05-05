package com.ballboycorp.tingting.pocha.details

import android.os.Bundle
import com.ballboycorp.tingting.R
import com.ballboycorp.tingting.base.BaseActivity
import com.ballboycorp.tingting.databinding.ActivityPochaDetailsBinding
import com.ballboycorp.tingting.pocha.details.adapter.MenuAdapter
import com.ballboycorp.tingting.pocha.details.dialog.ShareDialog
import com.ballboycorp.tingting.review.ReviewActivity
import com.ballboycorp.tingting.review.model.ReviewItemViewModel
import com.ballboycorp.tingting.utils.extensions.bind
import com.ballboycorp.tingting.utils.extensions.getViewModel
import com.ballboycorp.tingting.utils.extensions.observe
import com.ballboycorp.tingting.utils.extensions.startActivity
import com.kakao.kakaonavi.Location
import kotlinx.android.synthetic.main.activity_pocha_details.*
import net.daum.mf.map.api.MapPOIItem
import net.daum.mf.map.api.MapPoint
import net.daum.mf.map.api.MapView

/**
 * Created by musooff on 13/04/2019.
 */

class PochaDetailsActivity: BaseActivity(), MapView.MapViewEventListener, MapView.POIItemEventListener {
    override fun onCalloutBalloonOfPOIItemTouched(p0: MapView?, p1: MapPOIItem?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onCalloutBalloonOfPOIItemTouched(p0: MapView?, p1: MapPOIItem?, p2: MapPOIItem.CalloutBalloonButtonType?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onDraggablePOIItemMoved(p0: MapView?, p1: MapPOIItem?, p2: MapPoint?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onPOIItemSelected(p0: MapView?, p1: MapPOIItem?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onMapViewDoubleTapped(p0: MapView?, p1: MapPoint?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onMapViewInitialized(p0: MapView?) {
    }

    override fun onMapViewDragStarted(p0: MapView?, p1: MapPoint?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onMapViewMoveFinished(p0: MapView?, p1: MapPoint?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onMapViewCenterPointMoved(p0: MapView?, p1: MapPoint?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onMapViewDragEnded(p0: MapView?, p1: MapPoint?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onMapViewSingleTapped(p0: MapView?, p1: MapPoint?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onMapViewZoomLevelChanged(p0: MapView?, p1: Int) {
    }

    override fun onMapViewLongPressed(p0: MapView?, p1: MapPoint?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    private val viewModel by lazy { getViewModel<PochaDetailsViewModel>() }

    private val menuAdapter = MenuAdapter()

    private lateinit var binding: ActivityPochaDetailsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = bind(R.layout.activity_pocha_details)
        binding.viewModel = viewModel
        binding.clickHandler = ClickHandler()

        setSupportActionBar(toolbar)
        initialize()
    }

    private fun initialize() {
        viewModel.getPocha()


        viewModel.getMenus().observe(this) {
            menuAdapter.submitList(it)
        }

        viewModel.getReviews().observe(this) {
            val reviewViewModel = ReviewItemViewModel(it[0])
            binding.review1.viewModel = reviewViewModel
            binding.review2.viewModel = reviewViewModel
        }



        val mapView = MapView(this)
        container_map.addView(mapView)

        mapView.setMapViewEventListener(this)
        mapView.setPOIItemEventListener(this)

        mapView.setMapCenterPoint(MapPoint.mapPointWithGeoCoord(37.53737528, 127.00557633), true);
        mapView.setZoomLevel(7, true);
        mapView.setMapCenterPointAndZoomLevel(MapPoint.mapPointWithGeoCoord(33.41, 126.52), 9, true);
        mapView.zoomIn(true);
        mapView.zoomOut(true);


    }

    inner class ClickHandler {

        fun onClickBack() {
            this@PochaDetailsActivity.onBackPressed()
        }

        fun onClickLike() {
            viewModel.isLiked = !viewModel.isLiked
        }

        fun onClickMoreReviews() {
            startActivity<ReviewActivity>()
        }

        fun onClickShare() {
            ShareDialog.show(supportFragmentManager)
        }
    }
}