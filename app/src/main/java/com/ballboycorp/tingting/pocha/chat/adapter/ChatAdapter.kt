package com.ballboycorp.tingting.pocha.chat.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ballboycorp.tingting.R
import com.ballboycorp.tingting.databinding.ItemChatRoomBinding
import com.ballboycorp.tingting.pocha.chat.ChatFragment
import com.ballboycorp.tingting.pocha.chat.model.ChatItemViewModel
import com.ballboycorp.tingting.utils.extensions.bind

/**
 * Created by musooff on 2019-05-01.
 */
class ChatAdapter(private val clickHandler: ChatFragment.ClickHandler) : RecyclerView.Adapter<ChatAdapter.ChatViewHolder>() {

    private var mViewModels: List<ChatItemViewModel> = ArrayList()


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChatViewHolder {
        val binding = parent.bind<ItemChatRoomBinding>(R.layout.item_chat_room, viewType)
        return ChatViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return mViewModels.size
    }

    override fun onBindViewHolder(holder: ChatViewHolder, position: Int) {
        holder.binding.clickHandler = clickHandler
        holder.binding.viewModel = mViewModels[position]
    }

    fun submitList(viewModels: List<ChatItemViewModel>) {
        mViewModels = viewModels
        notifyDataSetChanged()
    }

    inner class ChatViewHolder(val binding: ItemChatRoomBinding): RecyclerView.ViewHolder(binding.root)
}
