package com.ballboycorp.tingting.gift.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ballboycorp.tingting.R
import com.ballboycorp.tingting.databinding.ItemGiftBinding
import com.ballboycorp.tingting.gift.GiftFragment
import com.ballboycorp.tingting.gift.model.GiftItemViewModel
import com.ballboycorp.tingting.utils.extensions.bind

/**
 * Created by musooff on 2019-04-24.
 */

class GiftAdapter(private val clickHandler: GiftFragment.ClickHandler) : RecyclerView.Adapter<GiftAdapter.GiftViewHolder>() {

    private var mViewModels: List<GiftItemViewModel> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GiftViewHolder {
        val binding = parent.bind<ItemGiftBinding>(R.layout.item_gift, viewType)
        return GiftViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return mViewModels.size
    }

    override fun onBindViewHolder(holder: GiftViewHolder, position: Int) {
        holder.binding.viewModel = mViewModels[position]
        holder.binding.clickHandler = clickHandler
    }

    fun submitList(viewModels: List<GiftItemViewModel>) {
        mViewModels = viewModels
        notifyDataSetChanged()
    }

    fun restoreEverything() {
        mViewModels.forEach { it.count = 0 }
        notifyDataSetChanged()
    }

    inner class GiftViewHolder(val binding: ItemGiftBinding): RecyclerView.ViewHolder(binding.root)
}