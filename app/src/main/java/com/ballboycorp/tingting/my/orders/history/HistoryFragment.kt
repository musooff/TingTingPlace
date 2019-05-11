package com.ballboycorp.tingting.my.orders.history

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.ballboycorp.tingting.R
import com.ballboycorp.tingting.base.BaseFragment
import com.ballboycorp.tingting.databinding.FragmentHistoryBinding
import com.ballboycorp.tingting.my.orders.history.adapter.HistoryAdapter
import com.ballboycorp.tingting.my.orders.model.Order
import com.ballboycorp.tingting.my.orders.model.OrderItemViewModel
import com.ballboycorp.tingting.shop.model.ShopItem
import com.ballboycorp.tingting.utils.extensions.bind
import com.ballboycorp.tingting.utils.extensions.getViewModel
import kotlinx.android.synthetic.main.fragment_history.*

/**
 * Created by musooff on 2019-05-11.
 */

class HistoryFragment: BaseFragment() {

    private val clickHandler = ClickHandler()
    private val adapter = HistoryAdapter(clickHandler)
    private val viewModel by lazy { getViewModel<HistoryViewModel>() }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val binding = bind<FragmentHistoryBinding>(inflater, R.layout.fragment_history, container)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initialize()
    }

    private fun initialize() {
        rv_history.adapter = adapter
        rv_history.layoutManager = LinearLayoutManager(context)
        rv_history.addItemDecoration(DividerItemDecoration(mContext, LinearLayoutManager.VERTICAL))

        val shop = mutableListOf<OrderItemViewModel>()
        shop.add(OrderItemViewModel(Order(shopItem = ShopItem(duration = 30, amount = 1, price = "3,300"))))
        shop.add(OrderItemViewModel(Order(shopItem = ShopItem(duration = 30, amount = 2, price = "5,300"), status = 1)))
        shop.add(OrderItemViewModel(Order(shopItem = ShopItem(duration = 30, amount = 3, price = "7,300"))))

        adapter.submitList(shop)
    }

    inner class ClickHandler {

    }
}