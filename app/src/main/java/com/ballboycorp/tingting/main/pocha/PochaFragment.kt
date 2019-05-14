package com.ballboycorp.tingting.main.pocha

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import com.ballboycorp.tingting.base.BaseFragment
import com.ballboycorp.tingting.databinding.FragmentPochaBinding
import com.ballboycorp.tingting.main.pocha.nearby.dialog.LocationOptionDialog
import com.ballboycorp.tingting.utils.extensions.*
import kotlinx.android.synthetic.main.fragment_pocha.*
import com.ballboycorp.tingting.R
import com.ballboycorp.tingting.main.pocha.nearby.NearbyFragment
import com.ballboycorp.tingting.main.pocha.region.RegionFragment
import com.ballboycorp.tingting.main.pocha.search.SearchFragment

/**
 * Created by musooff on 08/04/2019.
 */

class PochaFragment : BaseFragment() {

    companion object {

        private const val FRAGMENT_TAG = "pocha_fragment"

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
        adapter.nearbyFragment?.onLocationTypeSelected(type)
    }

    fun setNearbyLocationName(title: String?) {
        viewModel.nearbyLocationName = title
    }

    fun setAreaLocationName(title: String?) {
        viewModel.areaLocationName = title
    }

    inner class ClickHandler {
        fun onClickToolbarTitle() {
            if (viewModel.viewPagerPosition != 0) return
            LocationOptionDialog.show(childFragmentManager)
        }
    }

    inner class ViewPagerAdapter(fragmentManager: FragmentManager): FragmentStatePagerAdapter(fragmentManager) {
        var nearbyFragment: NearbyFragment? = null

        override fun getItem(position: Int): Fragment {
            return when (position) {
                0 -> NearbyFragment()
                        .also { nearbyFragment = it }
                1 -> RegionFragment()
                2 -> SearchFragment()
                else -> Fragment()
            }
        }

        override fun getPageTitle(position: Int): CharSequence? {
            return when(position) {
                0 -> "내주변"
                1 -> "지역별"
                2 -> "포차이름 검색"
                else -> ""
            }
        }

        override fun getCount(): Int {
            return 3
        }
    }
}