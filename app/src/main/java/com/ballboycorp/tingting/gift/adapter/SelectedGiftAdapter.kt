package com.ballboycorp.tingting.gift.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ballboycorp.tingting.R
import com.ballboycorp.tingting.databinding.ItemSelectedGiftBinding
import com.ballboycorp.tingting.pocha.dialog.room.model.gift.GiftItemViewModel
import com.ballboycorp.tingting.utils.extensions.bind

/**
 * Created by musooff on 2019-04-25.
 */

class SelectedGiftAdapter : RecyclerView.Adapter<SelectedGiftAdapter.SelectedGiftViewHolder>() {

    private var mViewModels: MutableList<GiftItemViewModel> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SelectedGiftViewHolder {
        val binding = parent.bind<ItemSelectedGiftBinding>(R.layout.item_selected_gift, viewType)
        return SelectedGiftViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return mViewModels.size
    }

    override fun onBindViewHolder(holder: SelectedGiftViewHolder, position: Int) {
        holder.binding.viewModel = mViewModels[position]
    }

    fun addGift(viewModel: GiftItemViewModel){
        mViewModels.add(viewModel)
        notifyDataSetChanged()
    }

    fun removeGift(viewModel: GiftItemViewModel) {
        mViewModels.remove(viewModel)
        notifyDataSetChanged()
    }

    inner class SelectedGiftViewHolder(val binding: ItemSelectedGiftBinding): RecyclerView.ViewHolder(binding.root)
}