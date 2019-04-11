package com.ballboycorp.tingting.main.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.ballboycorp.tingting.R
import com.ballboycorp.tingting.base.BaseFragment
import com.ballboycorp.tingting.databinding.FragmentHomeBinding
import com.ballboycorp.tingting.main.home.adapter.HomeRecyclerViewAdapter
import com.ballboycorp.tingting.main.home.adapter.ViewPagerAdapter
import com.ballboycorp.tingting.main.home.utils.ItemDecorator
import com.ballboycorp.tingting.qr.QRScanActivity
import com.ballboycorp.tingting.utils.extensions.bind
import com.ballboycorp.tingting.utils.extensions.getViewModel
import com.ballboycorp.tingting.utils.extensions.observeIfTrue
import com.ballboycorp.tingting.utils.extensions.startActivity
import kotlinx.android.synthetic.main.fragment_home.*

/**
 * Created by musooff on 08/04/2019.
 */

class HomeFragment: BaseFragment() {

    companion object {

        private const val FRAGMENT_TAG = "home_fragment"

        fun replace(fragmentActivity: FragmentActivity) {
            val manager = fragmentActivity.supportFragmentManager
            val transaction = manager.beginTransaction()
            val fragment = HomeFragment()
            transaction.replace(R.id.container_main, fragment, FRAGMENT_TAG)
                    .commit()
        }
    }

    private val viewModel by lazy { getViewModel<HomeViewModel>() }

    private val viewPagerAdapter = ViewPagerAdapter()



    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val binding = bind<FragmentHomeBinding>(inflater, R.layout.fragment_home, container)
        binding.viewModel = viewModel
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        vp_main.adapter = viewPagerAdapter
        tabs_vp_main.setupWithViewPager(vp_main)

        initialize()
    }

    private fun initialize(){
        initializeViewModel()
    }

    private fun initializeViewModel() {
        viewModel.qrScanPageRequest.observeIfTrue(this) {
            startActivity<QRScanActivity>()
        }
    }
}