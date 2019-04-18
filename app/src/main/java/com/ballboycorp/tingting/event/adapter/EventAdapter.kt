package com.ballboycorp.tingting.event.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ballboycorp.tingting.R
import com.ballboycorp.tingting.databinding.ItemEventBinding
import com.ballboycorp.tingting.event.EventActivity
import com.ballboycorp.tingting.event.model.EventItemViewModel
import com.ballboycorp.tingting.utils.extensions.bind

/**
 * Created by musooff on 18/04/2019.
 */

class EventAdapter(private val clickHandler: EventActivity.ClickHandler): RecyclerView.Adapter<EventAdapter.EventViewHolder>() {

    private var mViewModels: List<EventItemViewModel> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EventViewHolder {
        val binding = parent.bind<ItemEventBinding>(R.layout.item_event, viewType)
        return EventViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return mViewModels.size
    }

    override fun onBindViewHolder(holder: EventViewHolder, position: Int) {
        holder.binding.viewModel = mViewModels[position]
        holder.binding.clickHandler = clickHandler
    }

    fun submitList(viewModels: List<EventItemViewModel>) {
        mViewModels = viewModels
        notifyDataSetChanged()
    }

    inner class EventViewHolder(val binding: ItemEventBinding): RecyclerView.ViewHolder(binding.root)

}
