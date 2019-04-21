package com.ballboycorp.tingting.main

import android.content.Context
import android.content.Intent
import android.os.Bundle
import com.ballboycorp.tingting.R
import com.ballboycorp.tingting.base.BaseActivity
import com.ballboycorp.tingting.contact.ContactActivity
import com.ballboycorp.tingting.contact.add.NewQuestionActivity
import com.ballboycorp.tingting.databinding.ActivityMainBinding
import com.ballboycorp.tingting.event.EventActivity
import com.ballboycorp.tingting.event.viewer.EventViewerActivity
import com.ballboycorp.tingting.main.home.HomeFragment
import com.ballboycorp.tingting.main.more.MoreFragment
import com.ballboycorp.tingting.main.pocha.PochaFragment
import com.ballboycorp.tingting.notice.NoticeActivity
import com.ballboycorp.tingting.pocha.PochaActivity
import com.ballboycorp.tingting.pocha.details.PochaDetailsActivity
import com.ballboycorp.tingting.pocha.details.map.PochaMapActivity
import com.ballboycorp.tingting.profile.ProfileFragment
import com.ballboycorp.tingting.review.add.AddReviewActivity
import com.ballboycorp.tingting.review.my.MyReviewsActivity
import com.ballboycorp.tingting.settings.SettingsActivity
import com.ballboycorp.tingting.table.model.Table
import com.ballboycorp.tingting.table.profile.ProfileActivity
import com.ballboycorp.tingting.utils.extensions.bind
import com.ballboycorp.tingting.utils.extensions.getViewModel
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
                ProfileFragment.replace(this)
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
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
        navigation.selectedItemId = R.id.navigation_home

        //
        val table = Table(
                maleCount = 2,
                femaleCount = 1
        )
        table.addTestPeople()
        startActivity<PochaActivity>()
    }
}