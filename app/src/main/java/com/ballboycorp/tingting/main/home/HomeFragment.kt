package com.ballboycorp.tingting.main.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.ballboycorp.tingting.R
import com.ballboycorp.tingting.base.BaseFragment
import com.ballboycorp.tingting.databinding.FragmentHomeBinding
import com.ballboycorp.tingting.main.home.adapter.HomeRecyclerViewAdapter
import com.ballboycorp.tingting.main.home.adapter.ViewPagerAdapter
import com.ballboycorp.tingting.main.home.utils.ItemDecorator
import kotlinx.android.synthetic.main.fragment_home.*

/**
 * Created by musooff on 08/04/2019.
 */

class HomeFragment: BaseFragment() {

    companion object {

        private const val FRAGMENT_TAG = "home_fragment"

        fun replace(fragmentActivity: FragmentActivity) {
            val manager = fragmentActivity.supportFragmentManager
            val transaction = manager.beginTransaction()
            val fragment = HomeFragment()
            transaction.replace(R.id.container_main, fragment, FRAGMENT_TAG)
                    .commit()
        }
    }

    private val viewPagerAdapter = ViewPagerAdapter()

    private val recentAdapter by lazy { HomeRecyclerViewAdapter().apply { setEmptyView(tv_empty_recent) } }
    private val likedAdapter by lazy { HomeRecyclerViewAdapter().apply { setEmptyView(tv_empty_liked) } }


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val binding = DataBindingUtil.inflate<FragmentHomeBinding>(inflater, R.layout.fragment_home, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        vp_main.adapter = viewPagerAdapter
        tabs_vp_main.setupWithViewPager(vp_main)

        rv_recent.adapter = recentAdapter
        rv_recent.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        rv_recent.addItemDecoration(ItemDecorator.emptyHorizontal(context!!))
        rv_liked.adapter = likedAdapter
        rv_liked.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        rv_liked.addItemDecoration(ItemDecorator.emptyHorizontal(context!!))
    }
}