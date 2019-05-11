package com.ballboycorp.tingting.my.orders.history.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ballboycorp.tingting.R
import com.ballboycorp.tingting.databinding.ItemHistoryBinding
import com.ballboycorp.tingting.my.orders.history.HistoryFragment
import com.ballboycorp.tingting.my.orders.model.OrderItemViewModel
import com.ballboycorp.tingting.utils.extensions.bind

/**
 * Created by musooff on 2019-05-11.
 */

class HistoryAdapter(private val clickHandler: HistoryFragment.ClickHandler) : RecyclerView.Adapter<HistoryAdapter.HistoryViewHolder>() {

    private var mViewModels: List<OrderItemViewModel> = arrayListOf()


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HistoryViewHolder {
        val binding = parent.bind<ItemHistoryBinding>(R.layout.item_history, viewType)
        return HistoryViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return mViewModels.size
    }

    override fun onBindViewHolder(holder: HistoryViewHolder, position: Int) {
        holder.binding.viewModel = mViewModels[position]
        holder.binding.clickHandler = clickHandler
    }

    fun submitList(viewModels: List<OrderItemViewModel>) {
        mViewModels = viewModels
        notifyDataSetChanged()
    }

    inner class HistoryViewHolder(val binding: ItemHistoryBinding): RecyclerView.ViewHolder(binding.root)
}