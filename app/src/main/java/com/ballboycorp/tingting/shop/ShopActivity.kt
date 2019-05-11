package com.ballboycorp.tingting.shop

import android.os.Bundle
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.ballboycorp.tingting.R
import com.ballboycorp.tingting.base.BaseActivity
import com.ballboycorp.tingting.databinding.ActivityShopBinding
import com.ballboycorp.tingting.shop.adapter.ShopAdapter
import com.ballboycorp.tingting.shop.model.ShopItem
import com.ballboycorp.tingting.shop.model.ShopItemViewModel
import com.ballboycorp.tingting.utils.extensions.bind
import com.ballboycorp.tingting.utils.extensions.getViewModel
import com.ballboycorp.tingting.utils.extensions.showToast
import kotlinx.android.synthetic.main.activity_shop.*

/**
 * Created by musooff on 2019-05-11.
 */

class ShopActivity: BaseActivity() {

    private val clickHandler = ClickHandler()
    private val adapter = ShopAdapter(clickHandler)
    private val viewModel by lazy { getViewModel<ShopViewModel>() }

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

        val shop = mutableListOf<ShopItemViewModel>()
        shop.add(ShopItemViewModel(ShopItem(duration = 30, amount = 1, price = "3,300")))
        shop.add(ShopItemViewModel(ShopItem(duration = 30, amount = 2, price = "5,300")))
        shop.add(ShopItemViewModel(ShopItem(duration = 30, amount = 3, price = "7,300")))
        shop.add(ShopItemViewModel(ShopItem(duration = 60, amount = 1, price = "11,300")))
        shop.add(ShopItemViewModel(ShopItem(duration = 60, amount = 2, price = "15,300")))
        shop.add(ShopItemViewModel(ShopItem(duration = 60, amount = 3, price = "20,300")))

        adapter.submitList(shop)
    }

    inner class ClickHandler {

        fun onClickBuy(shopItem: ShopItem) {
            showToast("구매하기 ${shopItem.duration}")
        }
    }
}