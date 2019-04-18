package com.ballboycorp.tingting.notice.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ballboycorp.tingting.R
import com.ballboycorp.tingting.databinding.ItemNoticeBinding
import com.ballboycorp.tingting.notice.NoticeActivity
import com.ballboycorp.tingting.notice.model.NoticeItemViewModel
import com.ballboycorp.tingting.utils.extensions.bind

/**
 * Created by musooff on 18/04/2019.
 */

class NoticeAdapter(private val clickHandler: NoticeActivity.ClickHandler): RecyclerView.Adapter<NoticeAdapter.NoticeViewHolder>() {

    private var mViewModels: List<NoticeItemViewModel> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoticeViewHolder {
        val binding = parent.bind<ItemNoticeBinding>(R.layout.item_notice, viewType)
        return NoticeViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return mViewModels.size
    }

    override fun onBindViewHolder(holder: NoticeViewHolder, position: Int) {
        holder.binding.viewModel = mViewModels[position]
        holder.binding.clickHandler = clickHandler
    }

    fun submitList(viewModels: List<NoticeItemViewModel>) {
        mViewModels = viewModels
        notifyDataSetChanged()
    }

    fun onClickItem(viewModel: NoticeItemViewModel) {
        val lastState = mViewModels.first { viewModel.id == it.id }.isOpen
        mViewModels.forEach { it.isOpen = false }
        mViewModels.first { viewModel.id == it.id }.isOpen = !lastState
    }

    inner class NoticeViewHolder(val binding: ItemNoticeBinding): RecyclerView.ViewHolder(binding.root)
}