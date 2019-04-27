package com.ballboycorp.tingting.gift

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.recyclerview.widget.LinearLayoutManager
import com.ballboycorp.tingting.R
import com.ballboycorp.tingting.base.BaseActivity
import com.ballboycorp.tingting.common.dialog.YesNoCallback
import com.ballboycorp.tingting.common.dialog.YesNoDialog
import com.ballboycorp.tingting.databinding.ActivityGiftBinding
import com.ballboycorp.tingting.gift.adapter.SelectedGiftAdapter
import com.ballboycorp.tingting.pocha.dialog.room.model.gift.GiftItemViewModel
import com.ballboycorp.tingting.utils.extensions.bind
import com.ballboycorp.tingting.utils.extensions.getViewModel
import com.ballboycorp.tingting.utils.extensions.showDialog
import com.google.android.material.bottomsheet.BottomSheetBehavior
import kotlinx.android.synthetic.main.activity_gift.*
import kotlinx.android.synthetic.main.bottom_sheet_gift.*

/**
 * Created by musooff on 2019-04-24.
 */

class GiftActivity: BaseActivity(), YesNoCallback {

    companion object {
        const val TABLE = "table"
        private const val ALERT_SEND_GIFT = "alert_send_gift"
    }

    private lateinit var pagerAdapter: GiftViewPagerAdapter

    private val viewModel by lazy { getViewModel<GiftViewModel>() }

    private val selectedAdapter = SelectedGiftAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = bind<ActivityGiftBinding>(R.layout.activity_gift)
        binding.viewModel = viewModel
        binding.clickHandler = ClickHandler()

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

        intent.extras?.let {
            viewModel.table = it.getParcelable(TABLE)
        }

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
        fun onClickSendGift() {
            showDialog(
                    ::YesNoDialog,
                    YesNoDialog.REASON to ALERT_SEND_GIFT,
                    YesNoDialog.TITLE to getString(R.string.text_send_gift),
                    YesNoDialog.TEXT to String.format(getString(R.string.confirm_send_gift), viewModel.table?.tableNumber))

        }
    }

    override fun onYes(reason: String) {
        if (reason == ALERT_SEND_GIFT) {
            viewModel.selectedGifts = mutableListOf()
            selectedAdapter.removeGifts()
            viewModel.updateTotal()
            pagerAdapter.snackFragment?.restoreEverything()
            pagerAdapter.liquorFragment?.restoreEverything()
            pagerAdapter.drinkFragment?.restoreEverything()
        }
    }

    inner class GiftViewPagerAdapter(fragmentManager: FragmentManager): FragmentPagerAdapter(fragmentManager) {


        var snackFragment: GiftFragment? = null
        var liquorFragment: GiftFragment? = null
        var drinkFragment: GiftFragment? = null

        override fun getItem(position: Int): Fragment {
            return when(position) {
                0 -> GiftFragment()
                        .also { snackFragment = it }
                1 -> GiftFragment()
                        .also { liquorFragment = it }
                2 -> GiftFragment()
                        .also { drinkFragment = it }
                else -> Fragment()
            }
        }

        override fun getCount(): Int {
            return 3
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