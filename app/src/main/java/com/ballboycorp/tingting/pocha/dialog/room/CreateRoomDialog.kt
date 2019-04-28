package com.ballboycorp.tingting.pocha.dialog.room

import android.os.Bundle
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.fragment.app.DialogFragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.ballboycorp.tingting.R
import com.ballboycorp.tingting.databinding.DialogCreateRoomBinding
import com.ballboycorp.tingting.pocha.dialog.room.adapter.GameKindAdapter
import com.ballboycorp.tingting.pocha.dialog.room.adapter.GiftKindAdapter
import com.ballboycorp.tingting.pocha.dialog.room.model.game.Game
import com.ballboycorp.tingting.pocha.dialog.room.model.game.GameItemViewModel
import com.ballboycorp.tingting.pocha.dialog.room.model.bet.Bet
import com.ballboycorp.tingting.pocha.dialog.room.model.bet.BetItemViewModel
import com.ballboycorp.tingting.utils.extensions.bind
import com.ballboycorp.tingting.utils.extensions.getScreenWidth
import com.ballboycorp.tingting.utils.extensions.getViewModel
import kotlinx.android.synthetic.main.dialog_create_room.*



/**
 * Created by musooff on 2019-04-23.
 */

class CreateRoomDialog : DialogFragment() {

    companion object {
        const val RANDOM_ROOM = "random_room"
    }

    private val viewModel by lazy { getViewModel<CreateRoomViewModel>() }

    private val clickHandler = ClickHandler()
    private val gameKindAdapter = GameKindAdapter(clickHandler)
    private val giftKindAdapter = GiftKindAdapter(clickHandler)

    private var testPochas = arrayListOf<GameItemViewModel>()
    private var testPochas1 = arrayListOf<BetItemViewModel>()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val binding = bind<DialogCreateRoomBinding>(inflater, R.layout.dialog_create_room, container)
        binding.viewModel = viewModel
        binding.clickHandler = clickHandler
        return binding.root
    }

    override fun onResume() {
        super.onResume()
        dialog?.window?.setLayout((activity!!.getScreenWidth() * .9).toInt(), ViewGroup.LayoutParams.WRAP_CONTENT)
        dialog?.window?.setGravity(Gravity.CENTER)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        arguments?.let { viewModel.isRandomRoom = it.getBoolean(RANDOM_ROOM) }

        rv_game_kind.layoutManager = LinearLayoutManager(context, LinearLayout.HORIZONTAL, false)
        rv_game_kind.adapter = gameKindAdapter

        for (i in 1..10) {
            val game = Game()
                    .apply { id = i }
            testPochas.add(GameItemViewModel(game))
        }
        gameKindAdapter.submitList(testPochas)

        rv_gift_kind.layoutManager = LinearLayoutManager(context, LinearLayout.HORIZONTAL, false)
        rv_gift_kind.adapter = giftKindAdapter

        for (i in 1..10) {
            val game = Bet()
                    .apply { id = i }
            testPochas1.add(BetItemViewModel(game))
        }
        giftKindAdapter.submitList(testPochas1)
    }

    inner class ClickHandler {

        fun onClickExit() {
            dismiss()
        }

        fun onClickCreateRoom() {
            val callback: CreateRoomCallback = if (targetFragment != null) {
                targetFragment as CreateRoomCallback
            } else {
                activity as CreateRoomCallback
            }

            callback.onCreateRoom(
                    testPochas[viewModel.selectedGameId].game,
                    testPochas1[viewModel.selectedGiftId].bet,
                    viewModel.isRandomJoin
            )
            dismiss()
        }

        fun onClickGameKind(gameItemViewModel: GameItemViewModel) {
            gameKindAdapter.onClickItem(gameItemViewModel)
            viewModel.selectedGameId = gameItemViewModel.id
            viewModel.verifyCanCreateRoom()
        }

        fun onClickGiftKind(betItemViewModel: BetItemViewModel) {
            giftKindAdapter.onClickItem(betItemViewModel)
            viewModel.selectedGiftId = betItemViewModel.id
            viewModel.verifyCanCreateRoom()
        }
    }
}