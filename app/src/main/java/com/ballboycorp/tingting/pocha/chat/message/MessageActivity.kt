package com.ballboycorp.tingting.pocha.chat.message

import android.os.Bundle
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.ballboycorp.tingting.R
import com.ballboycorp.tingting.base.BaseActivity
import com.ballboycorp.tingting.common.dialog.YesNoCallback
import com.ballboycorp.tingting.common.dialog.YesNoDialog
import com.ballboycorp.tingting.databinding.ActivityMessageBinding
import com.ballboycorp.tingting.gift.GiftActivity
import com.ballboycorp.tingting.pocha.chat.message.adapter.MessageAdapter
import com.ballboycorp.tingting.pocha.chat.message.model.Message
import com.ballboycorp.tingting.pocha.chat.message.model.MessageItemViewModel
import kotlinx.android.synthetic.main.activity_message.*
import kotlinx.android.synthetic.main.content_message.*
import android.graphics.Rect
import com.ballboycorp.tingting.utils.extensions.*


/**
 * Created by musooff on 2019-05-01.
 */

class MessageActivity: BaseActivity(), YesNoCallback {

    companion object {
        private const val ALERT_LEAVE_CHAT = "leave_chat"
    }

    private val viewModel by lazy { getViewModel<MessageViewModel>() }

    private val clickHandler = ClickHandler()
    private val adapter = MessageAdapter(clickHandler)

    private lateinit var toggle: ActionBarDrawerToggle


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = bind<ActivityMessageBinding>(R.layout.activity_message)
        binding.clickHandler = clickHandler
        binding.viewModel = viewModel

        initCustomToolbar(toolbar)
        rv_messages.adapter = adapter
        val layoutManager = LinearLayoutManager(this)
        rv_messages.layoutManager = layoutManager

        toggle = ActionBarDrawerToggle(this, drawer_layout, R.string.navigation_drawer_open, R.string.navigation_drawer_close)
        drawer_layout.addDrawerListener(toggle)
        toggle.syncState()

        val testPochas = ArrayList<MessageItemViewModel>()
        for (i in 1..10) {
            val table = Message()
            testPochas.add(MessageItemViewModel(table))
        }
        adapter.submitList(testPochas)
        layoutManager.smoothScrollToPosition(rv_messages, null, adapter.itemCount)

    }

    override fun onYes(reason: String) {
        if (reason == ALERT_LEAVE_CHAT) {
            //TODO leave chat
            finish()
        }
    }


    inner class ClickHandler {
        fun onClickSend() {
            viewModel.sendMessage()
        }

        fun onClickAdd() {
            viewModel.isAddMode = !viewModel.isAddMode
            if (viewModel.isAddMode) {
                container_add.setHeight(getKeyboardHeight())
                edittext_message.hideKeyboard()
            }
            else {
                edittext_message.showKeyboard()
            }
        }

        fun onClickBack() {
            finish()
        }

        fun onClickOpenDrawer() {
            drawer_layout.openDrawer(GravityCompat.END)
        }

        fun onClickLeave() {
            showDialog(
                    ::YesNoDialog,
                    YesNoDialog.REASON to ALERT_LEAVE_CHAT,
                    YesNoDialog.TITLE to getString(R.string.text_leave_chat_title),
                    YesNoDialog.TEXT to getString(R.string.text_leave_chat))
        }

        fun onClickSettings() {

        }
    }
}