package com.ballboycorp.tingting.my.orders

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentPagerAdapter
import androidx.fragment.app.FragmentStatePagerAdapter
import com.ballboycorp.tingting.R
import com.ballboycorp.tingting.base.BaseActivity
import com.ballboycorp.tingting.databinding.ActivityOrdersBinding
import com.ballboycorp.tingting.my.orders.available.AvailableFragment
import com.ballboycorp.tingting.my.orders.history.HistoryFragment
import com.ballboycorp.tingting.shop.ShopActivity
import com.ballboycorp.tingting.utils.extensions.bind
import com.ballboycorp.tingting.utils.extensions.getViewModel
import com.ballboycorp.tingting.utils.extensions.startActivity
import kotlinx.android.synthetic.main.activity_orders.*

/**
 * Created by musooff on 2019-05-11.
 */

class OrdersActivity: BaseActivity() {

    private val clickHandler = ClickHandler()
    private val viewModel by lazy { getViewModel<OrdersViewModel>() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = bind<ActivityOrdersBinding>(R.layout.activity_orders)
        binding.clickHandler = clickHandler
        binding.viewModel = viewModel

        initToolbar("아이템 보관함", true)

        initialize()
    }

    private fun initialize() {
        vp_orders.adapter = OrdersPagerAdapter()
        tabs_vp_orders.setupWithViewPager(vp_orders)
    }

    inner class ClickHandler {
        fun onClickShop() {
            startActivity<ShopActivity>()
        }
    }

    inner class OrdersPagerAdapter : FragmentStatePagerAdapter(supportFragmentManager){
        override fun getItem(position: Int): Fragment {
            return when (position) {
                0 -> AvailableFragment()
                1 -> HistoryFragment()
                else -> Fragment()
            }
        }

        override fun getCount(): Int {
            return 2
        }

        override fun getPageTitle(position: Int): CharSequence? {
            return when (position) {
                0 -> "아이템"
                1 -> "사용내역"
                else -> ""
            }
        }
    }
}