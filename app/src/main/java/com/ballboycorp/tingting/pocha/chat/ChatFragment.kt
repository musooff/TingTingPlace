package com.ballboycorp.tingting.pocha.chat

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.ballboycorp.tingting.R
import com.ballboycorp.tingting.base.BaseFragment
import com.ballboycorp.tingting.databinding.FragmentChatBinding
import com.ballboycorp.tingting.pocha.chat.adapter.ChatAdapter
import com.ballboycorp.tingting.pocha.chat.message.MessageActivity
import com.ballboycorp.tingting.pocha.chat.model.Chat
import com.ballboycorp.tingting.pocha.chat.model.ChatItemViewModel
import com.ballboycorp.tingting.utils.extensions.bind
import com.ballboycorp.tingting.utils.extensions.getViewModel
import com.ballboycorp.tingting.utils.extensions.startActivity
import kotlinx.android.synthetic.main.fragment_chat.*

/**
 * Created by musooff on 20/04/2019.
 */

class ChatFragment: BaseFragment() {

    private val viewModel by lazy { getViewModel<ChatViewModel>() }
    private val clickHandler = ClickHandler()
    private val adapter = ChatAdapter(clickHandler)

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val binding = bind<FragmentChatBinding>(inflater, R.layout.fragment_chat, container)
        binding.viewModel = viewModel
        binding.clickHandler = clickHandler
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        rv_chats.adapter = adapter
        rv_chats.layoutManager = LinearLayoutManager(context)

        val testPochas = ArrayList<ChatItemViewModel>()
        for (i in 1..10) {
            val table = Chat()
            testPochas.add(ChatItemViewModel(table))
        }
        adapter.submitList(testPochas)
    }

    inner class ClickHandler {
        fun onClickItem(chatItemViewModel: ChatItemViewModel) {
            startActivity<MessageActivity>()
        }
    }
}