package com.ballboycorp.tingting.gift

import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.recyclerview.widget.LinearLayoutManager
import com.ballboycorp.tingting.R
import com.ballboycorp.tingting.base.BaseActivity
import com.ballboycorp.tingting.databinding.ActivityGiftBinding
import com.ballboycorp.tingting.gift.adapter.SelectedGiftAdapter
import com.ballboycorp.tingting.pocha.dialog.room.model.gift.GiftItemViewModel
import com.ballboycorp.tingting.utils.extensions.bind
import com.ballboycorp.tingting.utils.extensions.getViewModel
import com.google.android.material.bottomsheet.BottomSheetBehavior
import kotlinx.android.synthetic.main.activity_gift.*
import kotlinx.android.synthetic.main.bottom_sheet_gift.*

/**
 * Created by musooff on 2019-04-24.
 */

class GiftActivity: BaseActivity() {

    private lateinit var pagerAdapter: GiftViewPagerAdapter

    private val viewModel by lazy { getViewModel<GiftViewModel>() }

    private val selectedAdapter = SelectedGiftAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = bind<ActivityGiftBinding>(R.layout.activity_gift)
        binding.viewModel = viewModel

        initToolbar("선물하기", true)

        pagerAdapter = GiftViewPagerAdapter(supportFragmentManager)
        vp_gift.adapter = pagerAdapter
        vp_gift.offscreenPageLimit = 2
        tabs_vp_gift.setupWithViewPager(vp_gift)

        initialize()
    }

    fun onItemAdded(giftItemViewModel: GiftItemViewModel) {
        viewModel.selectedGifts.add(giftItemViewModel)
        selectedAdapter.addGift(giftItemViewModel)
        viewModel.updateTotal()
    }

    fun onItemRemoved(giftItemViewModel: GiftItemViewModel) {
        viewModel.selectedGifts.remove(giftItemViewModel)
        selectedAdapter.removeGift(giftItemViewModel)
        viewModel.updateTotal()
    }

    private fun initialize() {

        BottomSheetBehavior.from(bottom_sheet)
                .setBottomSheetCallback(object :BottomSheetBehavior.BottomSheetCallback(){
                    override fun onSlide(bottomSheet: View, slideOffset: Float) {}

                    override fun onStateChanged(bottomSheet: View, newState: Int) {
                        viewModel.isBottomSheepOpen = newState == BottomSheetBehavior.STATE_EXPANDED
                    }
                })

        rv_basket.layoutManager = LinearLayoutManager(this)
        rv_basket.adapter = selectedAdapter
    }

    inner class ClickHandler {

    }

    inner class GiftViewPagerAdapter(fragmentManager: FragmentManager): FragmentPagerAdapter(fragmentManager) {


        var snackFragment: GiftFragment? = null
        var liquorFragment: GiftFragment? = null
        var drinkFragment: GiftFragment? = null

        override fun getItem(position: Int): Fragment {
            return when(position) {
                0 -> GiftFragment()
                1 -> GiftFragment()
                2 -> GiftFragment()
                else -> Fragment()
            }
        }

        override fun getCount(): Int {
            return 3
        }


        override fun getItemPosition(`object`: Any): Int {
            return super.getItemPosition(`object`)
        }

        override fun setPrimaryItem(container: ViewGroup, position: Int, `object`: Any) {
            when (position) {
                0 -> snackFragment = `object` as GiftFragment
                1 -> liquorFragment = `object` as GiftFragment
                2 -> drinkFragment = `object` as GiftFragment
            }
            super.setPrimaryItem(container, position, `object`)
        }

        override fun getPageTitle(position: Int): CharSequence? {
            return when(position) {
                0 -> "안주"
                1 -> "주류"
                2 -> "음료"
                else -> ""
            }
        }
    }
}