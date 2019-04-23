package com.ballboycorp.tingting.table.my.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ballboycorp.tingting.R
import com.ballboycorp.tingting.databinding.ItemMyTableProfileBinding
import com.ballboycorp.tingting.databinding.ItemNearbyTableProfileBinding
import com.ballboycorp.tingting.table.model.TableItemViewModel
import com.ballboycorp.tingting.table.my.MyTableProfileActivity
import com.ballboycorp.tingting.utils.extensions.bind

/**
 * Created by musooff on 2019-04-23.
 */

class MyTablePeopleAdapter(private val clickHandler: MyTableProfileActivity.ClickHandler) : RecyclerView.Adapter<MyTablePeopleAdapter.MyTablePeopleViewHolder>() {

    private var mViewModel: TableItemViewModel? = null
    private var myIndex: Int = -1


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyTablePeopleViewHolder {
        val binding = parent.bind<ItemMyTableProfileBinding>(R.layout.item_my_table_profile, viewType)
        return MyTablePeopleViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return mViewModel?.people?.size ?: 0
    }

    override fun onBindViewHolder(holder: MyTablePeopleViewHolder, position: Int) {
        holder.binding.tableViewModel = mViewModel
        holder.binding.userIndex = position
        holder.binding.myIndex = myIndex
        holder.binding.clickHandler = clickHandler
    }

    fun submitList(viewModel: TableItemViewModel?, myIndex: Int) {
        mViewModel = viewModel
        this.myIndex = myIndex
        notifyDataSetChanged()
    }

    inner class MyTablePeopleViewHolder(val binding: ItemMyTableProfileBinding) : RecyclerView.ViewHolder(binding.root)
}
