package com.ballboycorp.tingting.table.nearby.profile.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ballboycorp.tingting.R
import com.ballboycorp.tingting.databinding.ItemNearbyTableProfileBinding
import com.ballboycorp.tingting.table.model.TableItemViewModel
import com.ballboycorp.tingting.table.nearby.profile.NearbyProfileActivity
import com.ballboycorp.tingting.utils.extensions.bind

/**
 * Created by musooff on 2019-04-23.
 */

class NearbyTablePeopleAdapter(private val clickHandler: NearbyProfileActivity.ClickHandler) : RecyclerView.Adapter<NearbyTablePeopleAdapter.NearbyTablePeopleViewHolder>() {

    private var mViewModel: TableItemViewModel? = null


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NearbyTablePeopleViewHolder {
        val binding = parent.bind<ItemNearbyTableProfileBinding>(R.layout.item_nearby_table_profile, viewType)
        return NearbyTablePeopleViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return mViewModel?.people?.size ?: 0
    }

    override fun onBindViewHolder(holder: NearbyTablePeopleViewHolder, position: Int) {
        holder.binding.tableViewModel = mViewModel
        holder.binding.userIndex = position
        holder.binding.clickHandler = clickHandler
    }

    fun submitList(viewModel: TableItemViewModel?) {
        mViewModel = viewModel
        notifyDataSetChanged()
    }

    inner class NearbyTablePeopleViewHolder(val binding: ItemNearbyTableProfileBinding) : RecyclerView.ViewHolder(binding.root)
}
