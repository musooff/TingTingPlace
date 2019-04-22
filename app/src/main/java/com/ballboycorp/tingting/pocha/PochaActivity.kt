package com.ballboycorp.tingting.pocha

import android.os.Bundle
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import androidx.viewpager.widget.ViewPager
import com.ballboycorp.tingting.R
import com.ballboycorp.tingting.base.BaseActivity
import com.ballboycorp.tingting.databinding.ActivityPochaBinding
import com.ballboycorp.tingting.pocha.details.PochaDetailsActivity
import com.ballboycorp.tingting.pocha.dialog.NumberOfPeopleDialog
import com.ballboycorp.tingting.pocha.game.GameFragment
import com.ballboycorp.tingting.pocha.home.HomeFragment
import com.ballboycorp.tingting.pocha.home.dialog.hashtag.HashtagEditDialog
import com.ballboycorp.tingting.pocha.message.MessageFragment
import com.ballboycorp.tingting.utils.extensions.bind
import com.ballboycorp.tingting.utils.extensions.startActivity
import kotlinx.android.synthetic.main.activity_pocha.*
import kotlinx.android.synthetic.main.activity_pocha.view.*


/**
 * Created by musooff on 13/04/2019.
 */

class PochaActivity : BaseActivity() {

    private lateinit var binding: ActivityPochaBinding

    private lateinit var adapter: PochaAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = bind(R.layout.activity_pocha)
        binding.clickHandler = ClickHandler()

        toolbar.tb_title.text = "한신포차 부평점"

        adapter = PochaAdapter(supportFragmentManager)
        vp_pocha.adapter = adapter
        vp_pocha.offscreenPageLimit = 2
        tabs_vp_pocha.setupWithViewPager(vp_pocha)
        tabs_vp_pocha.getTabAt(0)?.setIcon(R.drawable.ic_home_black)
        tabs_vp_pocha.getTabAt(1)?.setIcon(R.drawable.ic_game)
        tabs_vp_pocha.getTabAt(2)?.setIcon(R.drawable.ic_message)
        setCurrentTab(0)
        vp_pocha.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
            override fun onPageScrollStateChanged(state: Int) {
            }

            override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {
            }

            override fun onPageSelected(position: Int) {
                setCurrentTab(position)
            }
        })

        NumberOfPeopleDialog.show(supportFragmentManager)
        //HashtagEditDialog.show(supportFragmentManager)
    }

    fun onNumberOfPeopleSelected(maleCount: Int, femaleCount: Int) {
        adapter.homeFragment?.onNumberOfPeopleSelected(maleCount, femaleCount)
    }

    private fun setCurrentTab(position: Int) {
        val values = arrayListOf(0, 1, 2)
        tabs_vp_pocha.getTabAt(position)?.icon?.alpha = 225
        values.remove(position)
        tabs_vp_pocha.getTabAt(values[0])?.icon?.alpha = 128
        tabs_vp_pocha.getTabAt(values[1])?.icon?.alpha = 128

    }

    inner class ClickHandler {

        fun onClickBack() {
            this@PochaActivity.onBackPressed()
        }

        fun onClickDetails() {
            startActivity<PochaDetailsActivity>()
        }
    }

    inner class PochaAdapter(fragmentManager: FragmentManager): FragmentStatePagerAdapter(fragmentManager) {


        var homeFragment: HomeFragment? = null
        var gameFragment: GameFragment? = null
        var messageFragment: MessageFragment? = null


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

        override fun getItemPosition(`object`: Any): Int {
            return super.getItemPosition(`object`)
        }

        override fun setPrimaryItem(container: ViewGroup, position: Int, `object`: Any) {
            when (position) {
                0 -> homeFragment = `object` as HomeFragment
                1 -> gameFragment = `object` as GameFragment
                2 -> messageFragment = `object` as MessageFragment
            }
            super.setPrimaryItem(container, position, `object`)
        }
    }

    override fun onBackPressed() {
        super.onBackPressed()
    }
}