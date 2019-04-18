package com.ballboycorp.tingting.contact.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ballboycorp.tingting.R
import com.ballboycorp.tingting.contact.ContactActivity
import com.ballboycorp.tingting.contact.model.QuestionItemViewModel
import com.ballboycorp.tingting.databinding.ItemContactBinding
import com.ballboycorp.tingting.databinding.ItemNoticeBinding
import com.ballboycorp.tingting.notice.NoticeActivity
import com.ballboycorp.tingting.notice.model.NoticeItemViewModel
import com.ballboycorp.tingting.utils.extensions.bind

/**
 * Created by musooff on 18/04/2019.
 */

class ContactAdapter(private val clickHandler: ContactActivity.ClickHandler): RecyclerView.Adapter<ContactAdapter.ContactViewHolder>() {

    private var mViewModels: List<QuestionItemViewModel> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactViewHolder {
        val binding = parent.bind<ItemContactBinding>(R.layout.item_contact, viewType)
        return ContactViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return mViewModels.size
    }

    override fun onBindViewHolder(holder: ContactViewHolder, position: Int) {
        holder.binding.viewModel = mViewModels[position]
        holder.binding.clickHandler = clickHandler
    }

    fun submitList(viewModels: List<QuestionItemViewModel>) {
        mViewModels = viewModels
        notifyDataSetChanged()
    }

    fun onClickItem(viewModel: QuestionItemViewModel) {
        val lastState = mViewModels.first { viewModel.id == it.id }.isOpen
        mViewModels.forEach { it.isOpen = false }
        mViewModels.first { viewModel.id == it.id }.isOpen = !lastState
    }

    inner class ContactViewHolder(val binding: ItemContactBinding): RecyclerView.ViewHolder(binding.root)
}