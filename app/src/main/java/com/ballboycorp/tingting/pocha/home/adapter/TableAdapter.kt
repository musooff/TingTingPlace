package com.ballboycorp.tingting.pocha.home.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ballboycorp.tingting.R
import com.ballboycorp.tingting.databinding.ItemTableBinding
import com.ballboycorp.tingting.pocha.home.HomeFragment
import com.ballboycorp.tingting.pocha.home.utils.ThumbnailsView
import com.ballboycorp.tingting.table.model.Table
import com.ballboycorp.tingting.table.model.TableItemViewModel
import com.ballboycorp.tingting.utils.extensions.bind

/**
 * Created by musooff on 2019-04-20.
 */

class TableAdapter(private val clickHandler: HomeFragment.ClickHandler) : RecyclerView.Adapter<TableAdapter.TableViewHolder>() {

    private var mViewModels: List<TableItemViewModel> = ArrayList()


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TableViewHolder {
        val binding = parent.bind<ItemTableBinding>(R.layout.item_table, viewType)
        return TableViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return mViewModels.size
    }

    override fun onBindViewHolder(holder: TableViewHolder, position: Int) {
        holder.binding.viewModel = mViewModels[position]
        holder.binding.clickHandler = clickHandler
        holder.addThumbs(mViewModels[position].table)
    }

    fun submitList(viewModels: List<TableItemViewModel>) {
        mViewModels = viewModels
        notifyDataSetChanged()
    }

    inner class TableViewHolder(val binding: ItemTableBinding): RecyclerView.ViewHolder(binding.root) {
        fun addThumbs(table: Table) {
            binding.containerThumbs.addView(ThumbnailsView.createThumbnails(binding.root.context, table))
        }
    }
}