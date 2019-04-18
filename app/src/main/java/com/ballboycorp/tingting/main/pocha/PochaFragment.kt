package com.ballboycorp.tingting.main.pocha

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentActivity
import androidx.viewpager.widget.ViewPager
import com.ballboycorp.tingting.R
import com.ballboycorp.tingting.base.BaseFragment
import com.ballboycorp.tingting.databinding.FragmentPochaBinding
import com.ballboycorp.tingting.main.pocha.adapter.ViewPagerAdapter
import com.ballboycorp.tingting.main.pocha.nearby.dialog.LocationOptionDialog
import com.ballboycorp.tingting.utils.extensions.bind
import com.ballboycorp.tingting.utils.extensions.getViewModel
import com.ballboycorp.tingting.utils.extensions.onPageChange
import kotlinx.android.synthetic.main.fragment_pocha.*
import kotlinx.android.synthetic.main.toolbar.*
import kotlinx.android.synthetic.main.toolbar.view.*

/**
 * Created by musooff on 08/04/2019.
 */

class PochaFragment : BaseFragment() {

    companion object {

        private const val FRAGMENT_TAG = "pocha_fragment"

        fun replace(fragmentActivity: FragmentActivity) {
            val manager = fragmentActivity.supportFragmentManager
            val transaction = manager.beginTransaction()
            val fragment = PochaFragment()
            transaction.replace(R.id.container_main, fragment, FRAGMENT_TAG)
                    .commit()
        }
    }

    private val viewModel by lazy { getViewModel<PochaViewModel>() }

    private lateinit var adapter: ViewPagerAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val binding = bind<FragmentPochaBinding>(inflater, R.layout.fragment_pocha, container)
        binding.viewModel = viewModel
        binding.clickHandler = ClickHandler()
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.viewPagerPosition = 0

        tabs_vp_pocha.setupWithViewPager(vp_pocha)
        adapter = ViewPagerAdapter(childFragmentManager)
        vp_pocha.adapter = adapter
        vp_pocha.offscreenPageLimit = 2

        vp_pocha.onPageChange {
            viewModel.viewPagerPosition = it
        }
    }

    fun onLocationTypeSelected(type: Int) {

    }

    inner class ClickHandler {
        fun onClickToolbarTitle() {
            if (viewModel.viewPagerPosition != 0) return
            LocationOptionDialog.show(childFragmentManager)
        }
    }
}