package com.ballboycorp.tingting.my.orders.available.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ballboycorp.tingting.R
import com.ballboycorp.tingting.databinding.ItemAvailableBinding
import com.ballboycorp.tingting.my.orders.available.AvailableFragment
import com.ballboycorp.tingting.my.orders.model.OrderItemViewModel
import com.ballboycorp.tingting.utils.extensions.bind

/**
 * Created by musooff on 2019-05-11.
 */

class AvailableAdapter(private val clickHandler: AvailableFragment.ClickHandler) : RecyclerView.Adapter<AvailableAdapter.AvailableViewHolder>() {

    private var mViewModels: List<OrderItemViewModel> = arrayListOf()


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AvailableViewHolder {
        val binding = parent.bind<ItemAvailableBinding>(R.layout.item_available, viewType)
        return AvailableViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return mViewModels.size
    }

    override fun onBindViewHolder(holder: AvailableViewHolder, position: Int) {
        holder.binding.viewModel = mViewModels[position]
        holder.binding.clickHandler = clickHandler
    }

    fun submitList(viewModels: List<OrderItemViewModel>) {
        mViewModels = viewModels
        notifyDataSetChanged()
    }

    inner class AvailableViewHolder(val binding: ItemAvailableBinding): RecyclerView.ViewHolder(binding.root)
}