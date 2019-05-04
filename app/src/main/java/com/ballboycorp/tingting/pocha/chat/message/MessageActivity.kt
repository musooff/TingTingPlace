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
import com.ballboycorp.tingting.pocha.chat.message.adapter.MessageAdapter
import com.ballboycorp.tingting.pocha.chat.message.model.Message
import com.ballboycorp.tingting.pocha.chat.message.model.MessageItemViewModel
import kotlinx.android.synthetic.main.activity_message.*
import kotlinx.android.synthetic.main.content_message.*
import android.graphics.Rect
import android.view.Gravity
import android.widget.PopupWindow
import android.widget.RelativeLayout
import androidx.databinding.DataBindingUtil
import com.ballboycorp.tingting.databinding.ViewPopupAddBinding
import com.ballboycorp.tingting.gift.GiftActivity
import com.ballboycorp.tingting.pocha.dialog.room.CreateRoomCallback
import com.ballboycorp.tingting.pocha.dialog.room.CreateRoomDialog
import com.ballboycorp.tingting.pocha.dialog.room.model.bet.Bet
import com.ballboycorp.tingting.pocha.dialog.room.model.game.Game
import com.ballboycorp.tingting.table.model.Table
import com.ballboycorp.tingting.table.profile.dialog.PreGameDialog
import com.ballboycorp.tingting.utils.extensions.*


/**
 * Created by musooff on 2019-05-01.
 */

class MessageActivity: BaseActivity(), YesNoCallback, CreateRoomCallback {

    companion object {
        private const val ALERT_LEAVE_CHAT = "leave_chat"
    }

    private val viewModel by lazy { getViewModel<MessageViewModel>() }

    private val clickHandler = ClickHandler()
    private val adapter = MessageAdapter(clickHandler)

    private lateinit var toggle: ActionBarDrawerToggle


    private var mKeyboardHeight: Int = 0
    private var mIsKeyBoardVisible: Boolean = false
    private var mIsPopupVisible: Boolean = false
    private lateinit var mAddPopup: PopupWindow
    private lateinit var addBinding: ViewPopupAddBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = bind<ActivityMessageBinding>(R.layout.activity_message)
        binding.clickHandler = clickHandler
        binding.viewModel = viewModel

        initCustomToolbar(toolbar)
        rv_messages.adapter = adapter
        val layoutManager = LinearLayoutManager(this)
        layoutManager.stackFromEnd = true
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

        initialize()

    }

    private fun initialize() {
        container_all.viewTreeObserver.addOnGlobalLayoutListener {

            val r = Rect()
            container_all.getWindowVisibleDisplayFrame(r)
            val screenHeight = container_all.rootView.height

            val keypadHeight = screenHeight - r.bottom

            mIsKeyBoardVisible = keypadHeight > screenHeight * 0.15

            if (mIsKeyBoardVisible) {
                mKeyboardHeight = screenHeight - (r.bottom + r.top)
            }
            if (!mIsKeyBoardVisible && ::mAddPopup.isInitialized){
                viewModel.isAddMode = false
                mAddPopup.dismiss()
            }

        }

        edittext_message.showKeyboard()
    }

    override fun onCreateRoom(game: Game, bet: Bet, isRandomJoin: Boolean) {
        showDialog(
                ::PreGameDialog,
                PreGameDialog.IS_REQUEST_KIND to true,
                PreGameDialog.GAME to Game(),
                PreGameDialog.GIFT to Bet())
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

        fun onClickClosePopup() {
            viewModel.isAddMode = false
            mAddPopup.dismiss()
        }

        fun onClickAdd() {
            viewModel.isAddMode = !viewModel.isAddMode
            if (mIsKeyBoardVisible) {
                showAddPopup()
            } else {
                edittext_message.showKeyboard()
                showAddPopup()
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

        fun onClickSendGift() {
            startActivity<GiftActivity>(
                    GiftActivity.TABLE to Table()
            )
        }

        fun onClickGameRequest() {

            showDialog(
                    ::CreateRoomDialog,
                    CreateRoomDialog.RANDOM_ROOM to false)
        }
    }

    private fun showAddPopup() {
        mIsPopupVisible = true
        addBinding = DataBindingUtil.inflate(layoutInflater, R.layout.view_popup_add, null, false)
        addBinding.clickHandler = clickHandler
        mAddPopup = PopupWindow(
                addBinding.root,
                RelativeLayout.LayoutParams.MATCH_PARENT,
                RelativeLayout.LayoutParams.MATCH_PARENT
        )

        val params = addBinding.containerAdd.layoutParams as RelativeLayout.LayoutParams
        params.height = mKeyboardHeight
        addBinding.containerAdd.layoutParams = params

        mAddPopup.showAtLocation(container_all, Gravity.CENTER, 0, 0)


    }
}