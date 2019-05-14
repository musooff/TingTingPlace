package com.ballboycorp.tingting.my.orders.available

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.ballboycorp.tingting.R
import com.ballboycorp.tingting.base.BaseFragment
import com.ballboycorp.tingting.billing.model.ChattingSkuDetails
import com.ballboycorp.tingting.databinding.FragmentAvailableBinding
import com.ballboycorp.tingting.my.orders.available.adapter.AvailableAdapter
import com.ballboycorp.tingting.my.orders.model.Order
import com.ballboycorp.tingting.my.orders.model.OrderItemViewModel
import com.ballboycorp.tingting.shop.model.ShopItem
import com.ballboycorp.tingting.utils.extensions.bind
import com.ballboycorp.tingting.utils.extensions.showToast
import kotlinx.android.synthetic.main.fragment_available.*

/**
 * Created by musooff on 2019-05-11.
 */

class AvailableFragment: BaseFragment() {

    private val clickHandler = ClickHandler()
    private val adapter = AvailableAdapter(clickHandler)

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val binding = bind<FragmentAvailableBinding>(inflater, R.layout.fragment_available, container)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initialize()
    }

    private fun initialize() {
        rv_available.adapter = adapter
        rv_available.layoutManager = LinearLayoutManager(context)
        rv_available.addItemDecoration(DividerItemDecoration(mContext, LinearLayoutManager.VERTICAL))

        val shop = mutableListOf<OrderItemViewModel>()
        shop.add(OrderItemViewModel(Order(shopItem = ShopItem(duration = 30, amount = 1, price = "3,300", chattingSkuDetails = ChattingSkuDetails(
                canPurchase = false,
                sku = ChattingSkuDetails.ChattingSku.CHATTING_30_1,
                type = "",
                price = "3,300",
                title = "sd",
                description = "",
                originalJson = "")))))
        shop.add(OrderItemViewModel(Order(shopItem = ShopItem(duration = 30, amount = 2, price = "5,300", chattingSkuDetails = ChattingSkuDetails(
                canPurchase = false,
                sku = ChattingSkuDetails.ChattingSku.CHATTING_30_1,
                type = "",
                price = "5,300",
                title = "sd",
                description = "",
                originalJson = "")), status = 1)))
        shop.add(OrderItemViewModel(Order(shopItem = ShopItem(duration = 30, amount = 3, price = "7,300", chattingSkuDetails = ChattingSkuDetails(
                canPurchase = false,
                sku = ChattingSkuDetails.ChattingSku.CHATTING_30_1,
                type = "",
                price = "7,300",
                title = "sd",
                description = "",
                originalJson = "")))))
        shop.add(OrderItemViewModel(Order(shopItem = ShopItem(duration = 60, amount = 1, price = "11,300", chattingSkuDetails = ChattingSkuDetails(
                canPurchase = false,
                sku = ChattingSkuDetails.ChattingSku.CHATTING_30_1,
                type = "",
                price = "11,300",
                title = "sd",
                description = "",
                originalJson = "")))))
        shop.add(OrderItemViewModel(Order(shopItem = ShopItem(duration = 60, amount = 2, price = "15,300", chattingSkuDetails = ChattingSkuDetails(
                canPurchase = false,
                sku = ChattingSkuDetails.ChattingSku.CHATTING_30_1,
                type = "",
                price = "15,300",
                title = "sd",
                description = "",
                originalJson = "")))))
        shop.add(OrderItemViewModel(Order(shopItem = ShopItem(duration = 60, amount = 3, price = "20,300", chattingSkuDetails = ChattingSkuDetails(
                canPurchase = false,
                sku = ChattingSkuDetails.ChattingSku.CHATTING_30_1,
                type = "",
                price = "20,300",
                title = "sd",
                description = "",
                originalJson = "")))))

        adapter.submitList(shop)
    }

    inner class ClickHandler {
        fun onClickUse(order: Order) {
            showToast("사용하기 ${order.shopItem?.duration}")
        }
    }
}