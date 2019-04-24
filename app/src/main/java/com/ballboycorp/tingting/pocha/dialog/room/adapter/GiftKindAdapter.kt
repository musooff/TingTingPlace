package com.ballboycorp.tingting.pocha.dialog.room.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ballboycorp.tingting.R
import com.ballboycorp.tingting.databinding.ItemGiftKindBinding
import com.ballboycorp.tingting.pocha.dialog.room.CreateRoomDialog
import com.ballboycorp.tingting.pocha.dialog.room.model.gift.GiftItemViewModel
import com.ballboycorp.tingting.utils.extensions.bind

/**
 * Created by musooff on 2019-04-23.
 */

class GiftKindAdapter(private val clickHandler: CreateRoomDialog.ClickHandler) : RecyclerView.Adapter<GiftKindAdapter.GiftKindViewHolder>() {

    private var mViewModels: List<GiftItemViewModel> = ArrayList()


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GiftKindViewHolder {
        val binding = parent.bind<ItemGiftKindBinding>(R.layout.item_gift_kind, viewType)
        return GiftKindViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return mViewModels.size
    }

    override fun onBindViewHolder(holder: GiftKindViewHolder, position: Int) {
        holder.binding.viewModel = mViewModels[position]
        holder.binding.clickHandler = clickHandler
    }

    fun submitList(viewModels: List<GiftItemViewModel>) {
        mViewModels = viewModels
        notifyDataSetChanged()
    }

    fun onClickItem(viewModel: GiftItemViewModel) {
        mViewModels.forEach { it.isSelected = false }
        mViewModels.first { viewModel.id == it.id }.isSelected = true
    }

    inner class GiftKindViewHolder(val binding: ItemGiftKindBinding): RecyclerView.ViewHolder(binding.root)
}