package com.ballboycorp.tingting.pocha.chat.message.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ballboycorp.tingting.R
import com.ballboycorp.tingting.databinding.ItemMessageReceiverBinding
import com.ballboycorp.tingting.databinding.ItemMessageSenderBinding
import com.ballboycorp.tingting.pocha.chat.message.MessageActivity
import com.ballboycorp.tingting.pocha.chat.message.model.MessageItemViewModel
import com.ballboycorp.tingting.utils.extensions.bind


/**
 * Created by musooff on 2019-05-01.
 */

class MessageAdapter(private val clickHandler: MessageActivity.ClickHandler) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    companion object {
        private const val VIEW_TYPE_MESSAGE_SENT = 1
        private const val VIEW_TYPE_MESSAGE_RECEIVED = 2
    }

    private var mViewModels: List<MessageItemViewModel> = ArrayList()


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val messageReceiver = parent.bind<ItemMessageReceiverBinding>(R.layout.item_message_receiver, viewType)
        val messageSender = parent.bind<ItemMessageSenderBinding>(R.layout.item_message_sender, viewType)
        return if (viewType == VIEW_TYPE_MESSAGE_SENT)
            MessageSenderViewHolder(messageSender)
        else
            MessageReceiverViewHolder(messageReceiver)
    }

    override fun getItemViewType(position: Int): Int {
        val messageItemViewModel = mViewModels[position]
        // TODO compare id of sender and current user to identify the sender and receiver
        return if (position % 3 == 0) VIEW_TYPE_MESSAGE_SENT
        else VIEW_TYPE_MESSAGE_RECEIVED
    }

    override fun getItemCount(): Int {
        return mViewModels.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when(holder) {
            is MessageSenderViewHolder -> holder.binding.viewModel = mViewModels[position]
            is MessageReceiverViewHolder -> {
                if (position % 3 == 2) {
                    holder.binding.isAttached = true
                }
                holder.binding.viewModel = mViewModels[position]
            }
        }
    }

    fun submitList(viewModels: List<MessageItemViewModel>) {
        mViewModels = viewModels
        notifyDataSetChanged()
    }

    inner class MessageSenderViewHolder(val binding: ItemMessageSenderBinding) : RecyclerView.ViewHolder(binding.root)

    inner class MessageReceiverViewHolder(val binding: ItemMessageReceiverBinding) : RecyclerView.ViewHolder(binding.root)
}