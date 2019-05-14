package com.ballboycorp.tingting.main

import android.content.Context
import android.content.Intent
import android.os.Bundle
import com.ballboycorp.tingting.R
import com.ballboycorp.tingting.base.BaseActivity
import com.ballboycorp.tingting.databinding.ActivityMainBinding
import com.ballboycorp.tingting.main.home.HomeFragment
import com.ballboycorp.tingting.main.more.MoreFragment
import com.ballboycorp.tingting.main.pocha.PochaFragment
import com.ballboycorp.tingting.my.MyProfileFragment
import com.ballboycorp.tingting.my.orders.OrdersActivity
import com.ballboycorp.tingting.pocha.home.dialog.help.coin.CoinHelpDialog
import com.ballboycorp.tingting.pocha.home.dialog.nocoin.NoCoinDialog
import com.ballboycorp.tingting.shop.ShopActivity
import com.ballboycorp.tingting.table.model.Table
import com.ballboycorp.tingting.utils.extensions.bind
import com.ballboycorp.tingting.utils.extensions.getViewModel
import com.ballboycorp.tingting.utils.extensions.showDialog
import com.ballboycorp.tingting.utils.extensions.startActivity
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_main.*

/**
 * Created by musooff on 07/04/2019.
 */

class MainActivity : BaseActivity() {

    companion object {

        fun newIntent(context: Context) {
            val intent = Intent(context, MainActivity::class.java)
            context.startActivity(intent)
        }
    }

    private val viewModel by lazy { getViewModel<MainViewModel>() }

    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.navigation_home -> {
                HomeFragment.replace(this)
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_pocha -> {
                PochaFragment.replace(this)
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_profile -> {
                MyProfileFragment.replace(this)
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_more -> {
                MoreFragment.replace(this)
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = bind<ActivityMainBinding>(R.layout.activity_main)
        binding.viewModel = viewModel
        binding.clickHandler = ClickHandler()
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
        navigation.selectedItemId = R.id.navigation_home

        val table = Table(maleCount = 2, femaleCount = 1)
        table.addTestPeople()
        //startActivity<OrdersActivity>()

        viewModel.checkFirstRun()
        //showDialog(::CoinHelpDialog)
        //startActivity<ShopActivity>()
    }

    inner class ClickHandler {
        fun onClickFirstImage() {
            viewModel.isFirstRun = false
            viewModel.appPref.setFirstRun(false)
        }

    }
}