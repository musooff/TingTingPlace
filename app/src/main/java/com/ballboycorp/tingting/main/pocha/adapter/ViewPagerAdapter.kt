package com.ballboycorp.tingting.main.pocha.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import com.ballboycorp.tingting.main.pocha.nearby.NearbyFragment
import com.ballboycorp.tingting.main.pocha.region.RegionFragment
import com.ballboycorp.tingting.main.pocha.search.SearchFragment

/**
 * Created by musooff on 12/04/2019.
 */

class ViewPagerAdapter(fragmentManager: FragmentManager): FragmentStatePagerAdapter(fragmentManager) {
    override fun getItem(position: Int): Fragment {
        return when (position) {
            0 -> NearbyFragment()
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