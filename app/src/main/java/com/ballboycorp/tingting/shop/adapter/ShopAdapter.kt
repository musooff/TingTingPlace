package com.ballboycorp.tingting.shop.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ballboycorp.tingting.R
import com.ballboycorp.tingting.databinding.ItemShopBinding
import com.ballboycorp.tingting.shop.ShopActivity
import com.ballboycorp.tingting.shop.model.ShopItemViewModel
import com.ballboycorp.tingting.utils.extensions.bind

/**
 * Created by musooff on 2019-05-11.
 */

class ShopAdapter(private val clickHandler: ShopActivity.ClickHandler) : RecyclerView.Adapter<ShopAdapter.ShopViewHolder>() {

    private var mViewModels: List<ShopItemViewModel> = arrayListOf()


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShopViewHolder {
        val binding = parent.bind<ItemShopBinding>(R.layout.item_shop, viewType)
        return ShopViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return mViewModels.size
    }

    override fun onBindViewHolder(holder: ShopViewHolder, position: Int) {
        holder.binding.viewModel = mViewModels[position]
        holder.binding.clickHandler = clickHandler
    }

    fun submitList(viewModels: List<ShopItemViewModel>) {
        mViewModels = viewModels
        notifyDataSetChanged()
    }

    inner class ShopViewHolder(val binding: ItemShopBinding): RecyclerView.ViewHolder(binding.root)
}