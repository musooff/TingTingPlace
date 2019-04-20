package com.ballboycorp.tingting.pocha.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import com.ballboycorp.tingting.pocha.game.GameFragment
import com.ballboycorp.tingting.pocha.home.HomeFragment
import com.ballboycorp.tingting.pocha.message.MessageFragment

/**
 * Created by musooff on 14/04/2019.
 */

class PochaAdapter(fragmentManager: FragmentManager): FragmentStatePagerAdapter(fragmentManager) {
    override fun getItem(position: Int): Fragment {
        return when (position) {
            0 -> HomeFragment()
            1 -> GameFragment()
            2 -> MessageFragment()
            else -> Fragment()
        }
    }

    override fun getCount(): Int {
        return 3
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return when(position) {
            0 -> "홈"
            1 -> "게임"
            2 -> "메세지"
            else -> ""
        }
    }
}