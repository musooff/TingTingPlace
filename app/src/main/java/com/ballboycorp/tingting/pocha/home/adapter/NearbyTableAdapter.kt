package com.ballboycorp.tingting.pocha.home.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ballboycorp.tingting.R
import com.ballboycorp.tingting.databinding.ItemNearbyTableBinding
import com.ballboycorp.tingting.pocha.home.HomeFragment
import com.ballboycorp.tingting.table.model.TableItemViewModel
import com.ballboycorp.tingting.utils.extensions.bind

/**
 * Created by musooff on 2019-04-23.
 */

class NearbyTableAdapter(private val clickHandler: HomeFragment.ClickHandler) : RecyclerView.Adapter<NearbyTableAdapter.NearbyTableViewHolder>() {

    private var mViewModels: List<TableItemViewModel> = ArrayList()


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NearbyTableViewHolder {
        val binding = parent.bind<ItemNearbyTableBinding>(R.layout.item_nearby_table, viewType)
        return NearbyTableViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return mViewModels.size
    }

    override fun onBindViewHolder(holder: NearbyTableViewHolder, position: Int) {
        holder.binding.viewModel = mViewModels[position]
        holder.binding.clickHandler = clickHandler
    }

    fun submitList(viewModels: List<TableItemViewModel>) {
        mViewModels = viewModels
        notifyDataSetChanged()
    }

    inner class NearbyTableViewHolder(val binding: ItemNearbyTableBinding): RecyclerView.ViewHolder(binding.root)
}