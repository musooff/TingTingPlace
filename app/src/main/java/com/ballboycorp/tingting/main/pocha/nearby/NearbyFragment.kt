package com.ballboycorp.tingting.main.pocha.nearby

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Context
import android.content.Intent
import android.location.LocationManager
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.ballboycorp.tingting.R
import com.ballboycorp.tingting.base.BaseFragment
import com.ballboycorp.tingting.databinding.FragmentNearbyBinding
import com.ballboycorp.tingting.main.pocha.PochaFragment
import com.ballboycorp.tingting.main.pocha.adapter.PochaRecyclerViewAdapter
import com.ballboycorp.tingting.main.pocha.dialog.PochaSortDialog
import com.ballboycorp.tingting.main.pocha.model.SortType
import com.ballboycorp.tingting.main.pocha.dialog.SortDialogListener
import com.ballboycorp.tingting.main.pocha.nearby.choose.ChooseLocationActivity
import com.ballboycorp.tingting.utils.PermissionUtils
import com.ballboycorp.tingting.utils.extensions.*
import kotlinx.android.synthetic.main.fragment_nearby.*
import net.daum.mf.map.api.MapPoint
import net.daum.mf.map.api.MapReverseGeoCoder

/**
 * Created by musooff on 12/04/2019.
 */

class NearbyFragment: BaseFragment(), SortDialogListener {

    companion object {

        private const val REQUEST_CHOOSE = 132
    }

    private val adapter = PochaRecyclerViewAdapter()
    private val viewModel by lazy { getViewModel<NearbyViewModel>() }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val binding = bind<FragmentNearbyBinding>(inflater, R.layout.fragment_nearby, container)
        binding.viewModel = viewModel
        binding.clickHandler = ClickHandler()
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        rv_main.apply {
            adapter = adapter
            layoutManager = LinearLayoutManager(context)
            addItemDecoration(DividerItemDecoration(context!!, DividerItemDecoration.VERTICAL))
        }

        initialize()

    }

    private fun initialize() {

        viewModel.pochas.observe(this) {
            adapter.submitList(it)
        }

        viewModel.error.observe(this) {
            showToast(it.message)
        }

        getByCurrentPosition()

    }

    fun onLocationTypeSelected(type: Int) {
        if (type == 0) {
            getByCurrentPosition()
        } else startActivityForResult<ChooseLocationActivity>(REQUEST_CHOOSE)
    }

    private fun getByCurrentPosition() {
        PermissionUtils.requestLocation(mActivity, object : PermissionUtils.OnPermissionResult {
            @SuppressLint("MissingPermission")
            override fun onResult(requestCode: Int, granted: Boolean, permissions: Array<out String>) {
                if (granted) {
                    val locationManager = (mContext.getSystemService(Context.LOCATION_SERVICE) as LocationManager)
                    val locationGPS = locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER)
                    val locationNet = locationManager.getLastKnownLocation(LocationManager.NETWORK_PROVIDER)

                    val locationTimeGPS = locationGPS?.time ?: 0
                    val locationTimeNet = locationNet?.time ?: 0

                    if (0 < locationTimeGPS - locationTimeNet) {
                        viewModel.nearbyRestaurants(locationGPS.longitude, locationGPS.latitude)
                        getLocationName(locationGPS.longitude, locationGPS.latitude)
                    } else {
                        viewModel.nearbyRestaurants(locationNet.longitude, locationNet.latitude)
                        getLocationName(locationNet.longitude, locationGPS.latitude)
                    }
                }
            }

        })
    }

    private fun getLocationName(longitude: Double, latitude: Double) {

        val reverseGeoCoder = MapReverseGeoCoder(
                getString(R.string.kakao_app_key),
                MapPoint.mapPointWithGeoCoord(latitude, longitude),
                object : MapReverseGeoCoder.ReverseGeoCodingResultListener {
                    override fun onReverseGeoCoderFailedToFindAddress(mapReverseGeoCoder: MapReverseGeoCoder?) {
                    }

                    override fun onReverseGeoCoderFoundAddress(mapReverseGeoCoder: MapReverseGeoCoder?, s: String?) {
                        (parentFragment as PochaFragment).setNearbyLocationName(s)
                    }
                },
                mActivity)
        reverseGeoCoder.startFindingAddress()
    }

    override fun onResult(sortType: SortType) {
        viewModel.sortType = sortType
    }

    inner class ClickHandler {

        fun onClickSortType() {
            PochaSortDialog.show(childFragmentManager, viewModel.sortType, true)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == REQUEST_CHOOSE) {
            if (resultCode == Activity.RESULT_OK) {
                data?.extras?.let {
                    val longitude = it.getDouble(ChooseLocationActivity.LONGITUDE)
                    val latitude = it.getDouble(ChooseLocationActivity.LATITUDE)
                    viewModel.nearbyRestaurants(longitude, latitude)
                    getLocationName(longitude, latitude)
                }
            }
        }
    }
}