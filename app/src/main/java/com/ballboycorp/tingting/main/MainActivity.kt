package com.ballboycorp.tingting.main

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import com.ballboycorp.tingting.R
import com.ballboycorp.tingting.base.BaseActivity
import com.ballboycorp.tingting.databinding.ActivityMainBinding
import com.ballboycorp.tingting.main.home.HomeFragment
import com.ballboycorp.tingting.main.more.MoreFragment
import com.ballboycorp.tingting.main.pocha.PochaFragment
import com.ballboycorp.tingting.main.profile.ProfileFragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_main.*

/**
 * Created by musooff on 07/04/2019.
 */

class MainActivity: BaseActivity() {

    companion object {

        fun newIntent(context: Context) {
            val intent = Intent(context, MainActivity::class.java)
            context.startActivity(intent)
        }
    }

    private val viewModel by lazy {
        ViewModelProviders
                .of(this)
                .get(MainViewModel::class.java)
    }

    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.navigation_home -> {
                HomeFragment.add(this)
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_pocha -> {
                PochaFragment.add(this)
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_profile -> {
                ProfileFragment.add(this)
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_more -> {
                MoreFragment.add(this)
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)
        binding.viewModel = viewModel
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
    }
}