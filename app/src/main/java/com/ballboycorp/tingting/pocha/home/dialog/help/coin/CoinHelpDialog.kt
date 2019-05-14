package com.ballboycorp.tingting.pocha.home.dialog.help.coin

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import com.ballboycorp.tingting.R
import com.ballboycorp.tingting.databinding.DialogCoinHelpBinding
import com.ballboycorp.tingting.utils.extensions.bind
import com.ballboycorp.tingting.utils.extensions.setWidthPercentage

/**
 * Created by musooff on 2019-05-12.
 */

class CoinHelpDialog: DialogFragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val binding = bind<DialogCoinHelpBinding>(inflater, R.layout.dialog_coin_help, container)
        binding.clickHandler = ClickHandler()
        return binding.root
    }

    override fun onResume() {
        super.onResume()
        setWidthPercentage(.9)
    }

    inner class ClickHandler {
        fun onClickExit() {
            dismiss()
        }
    }
}