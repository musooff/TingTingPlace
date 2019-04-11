package com.ballboycorp.tingting.main.pocha.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.fragment.app.FragmentStatePagerAdapter

/**
 * Created by musooff on 12/04/2019.
 */

class ViewPagerAdapter(fragmentManager: FragmentManager): FragmentStatePagerAdapter(fragmentManager) {
    override fun getItem(position: Int): Fragment {
        return Fragment()
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