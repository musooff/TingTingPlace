package com.ballboycorp.tingting.shop

import android.os.Bundle
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.ballboycorp.tingting.R
import com.ballboycorp.tingting.base.BaseActivity
import com.ballboycorp.tingting.billing.BillingViewModel
import com.ballboycorp.tingting.billing.model.ChattingSkuDetails
import com.ballboycorp.tingting.databinding.ActivityShopBinding
import com.ballboycorp.tingting.shop.adapter.ShopAdapter
import com.ballboycorp.tingting.shop.model.ShopItemViewModel
import com.ballboycorp.tingting.utils.extensions.bind
import com.ballboycorp.tingting.utils.extensions.getViewModel
import com.ballboycorp.tingting.utils.extensions.observe
import kotlinx.android.synthetic.main.activity_shop.*

/**
 * Created by musooff on 2019-05-11.
 */

class ShopActivity: BaseActivity() {

    private val clickHandler = ClickHandler()
    private val adapter = ShopAdapter(clickHandler)
    private val viewModel by lazy { getViewModel<ShopViewModel>() }
    private val billingViewModel by lazy { getViewModel<BillingViewModel>() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = bind<ActivityShopBinding>(R.layout.activity_shop)
        binding.clickHandler = clickHandler
        binding.viewModel = viewModel

        initToolbar("아이템 상점", true)

        initialize()
    }

    private fun initialize() {
        rv_shop.adapter = adapter
        rv_shop.layoutManager = LinearLayoutManager(this)
        rv_shop.addItemDecoration(DividerItemDecoration(this, LinearLayoutManager.VERTICAL))



        billingViewModel.inappSkuDetailsListLiveData.observe(this) {
            adapter.submitList(it.map { ShopItemViewModel(it) })
        }
    }


    inner class ClickHandler {

        fun onClickBuy(chattingSkuDetails: ChattingSkuDetails) {
            billingViewModel.makePurchase(this@ShopActivity, chattingSkuDetails)
        }
    }
}