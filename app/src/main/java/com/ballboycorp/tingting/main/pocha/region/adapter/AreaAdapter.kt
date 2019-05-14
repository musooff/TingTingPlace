package com.ballboycorp.tingting.main.pocha.region.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ballboycorp.tingting.R
import com.ballboycorp.tingting.databinding.ItemAreaBinding
import com.ballboycorp.tingting.main.pocha.region.RegionFragment
import com.ballboycorp.tingting.main.pocha.region.model.AreaItemViewModel
import com.ballboycorp.tingting.utils.extensions.bind

/**
 * Created by musooff on 2019-05-13.
 */

class AreaAdapter(private val clickHandler: RegionFragment.ClickHandler) : RecyclerView.Adapter<AreaAdapter.AreaViewHolder>() {

    private var mViewModels: List<AreaItemViewModel> = arrayListOf()


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AreaViewHolder {
        val binding = parent.bind<ItemAreaBinding>(R.layout.item_area, viewType)
        return AreaViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return mViewModels.size
    }

    override fun onBindViewHolder(holder: AreaViewHolder, position: Int) {
        holder.binding.viewModel = mViewModels[position]
        holder.binding.clickHandler = clickHandler
    }

    fun submitList(viewModels: List<AreaItemViewModel>) {
        mViewModels = viewModels
        notifyDataSetChanged()
    }

    fun setSelected(id: Long) {
        mViewModels.forEach { it.isSelected = false }
        mViewModels.first { it.area.id == id}.isSelected = true
    }

    inner class AreaViewHolder(val binding: ItemAreaBinding): RecyclerView.ViewHolder(binding.root)
}