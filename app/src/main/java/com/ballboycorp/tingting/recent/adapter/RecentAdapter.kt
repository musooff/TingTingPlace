package com.ballboycorp.tingting.recent.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ballboycorp.tingting.R
import com.ballboycorp.tingting.databinding.ItemRecentBinding
import com.ballboycorp.tingting.main.pocha.model.PochaItemViewModel
import com.ballboycorp.tingting.utils.extensions.bind

/**
 * Created by musooff on 13/04/2019.
 */

class RecentAdapter: RecyclerView.Adapter<RecentAdapter.RecentViewHolder>() {

    private var mViewModels: List<PochaItemViewModel> = ArrayList()


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecentViewHolder {
        val binding = parent.bind<ItemRecentBinding>(R.layout.item_recent, viewType)
        return RecentViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return mViewModels.size
    }

    override fun onBindViewHolder(holder: RecentViewHolder, position: Int) {
        holder.binding.viewModel = mViewModels[position]
    }

    fun submitList(viewModels: List<PochaItemViewModel>) {
        mViewModels = viewModels
        notifyDataSetChanged()
    }

    inner class RecentViewHolder(val binding: ItemRecentBinding): RecyclerView.ViewHolder(binding.root)
}