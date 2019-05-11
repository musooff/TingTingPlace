package com.ballboycorp.tingting.table.profile.dialog

import android.os.Bundle
import android.os.CountDownTimer
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import com.ballboycorp.tingting.R
import com.ballboycorp.tingting.databinding.DialogPreGameBinding
import com.ballboycorp.tingting.utils.extensions.bind
import com.ballboycorp.tingting.utils.extensions.getViewModel
import com.ballboycorp.tingting.utils.extensions.setWidthPercentage

/**
 * Created by musooff on 2019-04-26.
 */

class PreGameDialog : DialogFragment() {

    companion object {
        const val GAME = "game"
        const val GIFT = "bet"
        const val IS_REQUEST_KIND = "is_request_kind"
    }

    private val viewModel by lazy { getViewModel<PreGameViewModel>() }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val binding = bind<DialogPreGameBinding>(inflater, R.layout.dialog_pre_game, container)
        binding.clickHandler = ClickHandler()
        binding.viewModel = viewModel
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        arguments?.let {
            viewModel.isRequestKind = it.getBoolean(IS_REQUEST_KIND)
            viewModel.game = it.getParcelable(GAME)
            viewModel.bet = it.getParcelable(GIFT)
        }
    }

    override fun onResume() {
        super.onResume()
        setWidthPercentage(.9)
    }

    inner class ClickHandler {
        fun onClickNo() {
            dismiss()
        }

        fun onClickYes() {
            viewModel.isLoading = true
            object : CountDownTimer(10000, 1000) {
                override fun onFinish() {
                    dismiss()
                }

                override fun onTick(millisUntilFinished: Long) {
                    viewModel.countDownTime--
                }

            }.start()


        }

        fun onClickCancel() {
            dismiss()
        }
    }
}