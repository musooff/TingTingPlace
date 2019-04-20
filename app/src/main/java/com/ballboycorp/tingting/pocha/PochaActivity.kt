package com.ballboycorp.tingting.pocha

import android.os.Bundle
import androidx.viewpager.widget.ViewPager
import com.ballboycorp.tingting.R
import com.ballboycorp.tingting.base.BaseActivity
import com.ballboycorp.tingting.databinding.ActivityPochaBinding
import com.ballboycorp.tingting.pocha.adapter.PochaAdapter
import com.ballboycorp.tingting.pocha.details.PochaDetailsActivity
import com.ballboycorp.tingting.pocha.dialog.NumberOfPeopleDialog
import com.ballboycorp.tingting.utils.extensions.bind
import com.ballboycorp.tingting.utils.extensions.startActivity
import kotlinx.android.synthetic.main.activity_pocha.*
import kotlinx.android.synthetic.main.activity_pocha.view.*



/**
 * Created by musooff on 13/04/2019.
 */

class PochaActivity: BaseActivity() {

    private lateinit var binding: ActivityPochaBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = bind(R.layout.activity_pocha)
        binding.clickHandler = ClickHandler()

        toolbar.tb_title.text = "한신포차 부평점"

        vp_pocha.adapter = PochaAdapter(supportFragmentManager)
        tabs_vp_pocha.setupWithViewPager(vp_pocha)
        tabs_vp_pocha.getTabAt(0)?.setIcon(R.drawable.ic_home_black)
        tabs_vp_pocha.getTabAt(1)?.setIcon(R.drawable.ic_game)
        tabs_vp_pocha.getTabAt(2)?.setIcon(R.drawable.ic_message)
        setCurrentTab(0)
        vp_pocha.addOnPageChangeListener(object : ViewPager.OnPageChangeListener{
            override fun onPageScrollStateChanged(state: Int) {
            }

            override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {
            }

            override fun onPageSelected(position: Int) {
                setCurrentTab(position)
            }
        })

        //NumberOfPeopleDialog.show(supportFragmentManager)
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
}