package com.ballboycorp.tingting.pocha.details

import android.os.Bundle
import com.ballboycorp.tingting.R
import com.ballboycorp.tingting.base.BaseMapActivity
import com.ballboycorp.tingting.common.adapter.ImagePagerAdapter
import com.ballboycorp.tingting.databinding.ActivityPochaDetailsBinding
import com.ballboycorp.tingting.pocha.details.adapter.MenuAdapter
import com.ballboycorp.tingting.pocha.details.adapter.ThumbsPlaceholderPagerAdapter
import com.ballboycorp.tingting.pocha.details.dialog.ShareDialog
import com.ballboycorp.tingting.pocha.details.map.PochaMapActivity
import com.ballboycorp.tingting.review.ReviewActivity
import com.ballboycorp.tingting.review.model.ReviewItemViewModel
import com.ballboycorp.tingting.utils.MapUtils.createCustomMarker
import com.ballboycorp.tingting.utils.extensions.*
import kotlinx.android.synthetic.main.activity_pocha_details.*
import net.daum.mf.map.api.MapPoint
import net.daum.mf.map.api.MapView

/**
 * Created by musooff on 13/04/2019.
 */

class PochaDetailsActivity : BaseMapActivity() {

    private val viewModel by lazy { getViewModel<PochaDetailsViewModel>() }
    private lateinit var mMapView: MapView

    private val menuAdapter = MenuAdapter()
    private val thumbAdapter = ImagePagerAdapter()
    private val thumbPlaceHolderAdapter = ThumbsPlaceholderPagerAdapter()

    private lateinit var binding: ActivityPochaDetailsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        makeTransparentStatus()

        binding = bind(R.layout.activity_pocha_details)
        binding.viewModel = viewModel
        binding.clickHandler = ClickHandler()

        setSupportActionBar(toolbar)

        vp_thumb_placeholder.onPageChange { vp_thumb.currentItem = it }

        vp_thumb_placeholder.adapter = thumbPlaceHolderAdapter
        vp_thumb.adapter = thumbAdapter

        initialize()
    }

    override fun onResume() {
        super.onResume()

        initializeMapView()
    }

    override fun onPause() {
        super.onPause()
        container_map.removeAllViews()
    }

    private fun initialize() {
        viewModel.getPocha()

        thumbAdapter.submitList(viewModel.pocha.thumbs)
        thumbPlaceHolderAdapter.submitList(viewModel.pocha.title, viewModel.pocha.thumbs)

        viewModel.getMenus().observe(this) {
            menuAdapter.submitList(it)
        }

        viewModel.getReviews().observe(this) {
            val reviewViewModel = ReviewItemViewModel(it[0])
            binding.review1.viewModel = reviewViewModel
            binding.review2.viewModel = reviewViewModel
        }
    }

    private fun initializeMapView() {

        mMapView = MapView(this)

        mMapView.setOpenAPIKeyAuthenticationResultListener(this)
        mMapView.setMapViewEventListener(this)
        mMapView.mapType = MapView.MapType.Standard

        container_map.addView(mMapView)

    }

    override fun onMapViewInitialized(mapView: MapView) {
        val mapPoint = MapPoint.mapPointWithGeoCoord(viewModel.pocha.latitude, viewModel.pocha.longtitude)
        mapView.setMapCenterPointAndZoomLevel(mapPoint, 2, true)
        createCustomMarker(mapView, mapPoint, viewModel.pocha.title)
    }

    override fun onMapViewSingleTapped(mapView: MapView, mapPoint: MapPoint) {
        startActivity<PochaMapActivity>()
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
            showDialog(::ShareDialog)
        }

        fun onClickGoTo() {
            startActivity<PochaMapActivity>()
        }

        fun onClickCopy() {
            copyToClipBoard(viewModel.pocha.location)
            showToast("클립보드에 주소가 복사되었습니다.")
        }

    }
}