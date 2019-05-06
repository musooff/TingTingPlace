package com.ballboycorp.tingting.main.pocha

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentActivity
import com.ballboycorp.tingting.base.BaseFragment
import com.ballboycorp.tingting.databinding.FragmentPochaBinding
import com.ballboycorp.tingting.main.pocha.adapter.ViewPagerAdapter
import com.ballboycorp.tingting.main.pocha.nearby.choose.ChooseLocationActivity
import com.ballboycorp.tingting.main.pocha.nearby.dialog.LocationOptionDialog
import com.ballboycorp.tingting.utils.extensions.*
import kotlinx.android.synthetic.main.fragment_pocha.*
import android.location.LocationManager
import android.annotation.SuppressLint
import android.content.Context
import com.ballboycorp.tingting.R
import com.ballboycorp.tingting.utils.PermissionUtils

/**
 * Created by musooff on 08/04/2019.
 */

class PochaFragment : BaseFragment() {

    companion object {

        private const val FRAGMENT_TAG = "pocha_fragment"
        private const val REQUEST_CHOOSE = 132

        fun replace(fragmentActivity: FragmentActivity) {
            val manager = fragmentActivity.supportFragmentManager
            val transaction = manager.beginTransaction()
            val fragment = PochaFragment()
            transaction.replace(R.id.container_main, fragment, FRAGMENT_TAG)
                    .commit()
        }
    }

    private val viewModel by lazy { getViewModel<PochaViewModel>() }

    private lateinit var adapter: ViewPagerAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val binding = bind<FragmentPochaBinding>(inflater, R.layout.fragment_pocha, container)
        binding.viewModel = viewModel
        binding.clickHandler = ClickHandler()
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.viewPagerPosition = 0

        tabs_vp_pocha.setupWithViewPager(vp_pocha)
        adapter = ViewPagerAdapter(childFragmentManager)
        vp_pocha.adapter = adapter
        vp_pocha.offscreenPageLimit = 2

        vp_pocha.onPageChange {
            viewModel.viewPagerPosition = it
        }
    }

    fun onLocationTypeSelected(type: Int) {
        if (type == 0) {
            getLastBestLocation()
        } else startActivityForResult<ChooseLocationActivity>(REQUEST_CHOOSE)
    }

    inner class ClickHandler {
        fun onClickToolbarTitle() {
            if (viewModel.viewPagerPosition != 0) return
            LocationOptionDialog.show(childFragmentManager)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == REQUEST_CHOOSE) {
            showToast("got location")
        }
    }

    private fun getLastBestLocation() {
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
                        showToast("got location gps ${locationGPS.latitude}")
                    } else {
                        showToast("got location net ${locationNet.latitude}")
                    }
                }
            }

        })
    }
}