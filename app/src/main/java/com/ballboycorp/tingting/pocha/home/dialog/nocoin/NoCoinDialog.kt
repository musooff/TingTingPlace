package com.ballboycorp.tingting.pocha.home.dialog.nocoin

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import com.ballboycorp.tingting.R
import com.ballboycorp.tingting.databinding.DialogNoCoinBinding
import com.ballboycorp.tingting.utils.extensions.bind
import com.ballboycorp.tingting.utils.extensions.setWidthPercentage
import com.ballboycorp.tingting.utils.extensions.showToast

/**
 * Created by musooff on 2019-05-12.
 */

class NoCoinDialog: DialogFragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val binding = bind<DialogNoCoinBinding>(inflater, R.layout.dialog_no_coin, container)
        binding.clickHandler = ClickHandler()
        return binding.root
    }

    override fun onResume() {
        super.onResume()
        setWidthPercentage(.9)
    }

    inner class ClickHandler {

        fun onClickConfirm() {
            dismiss()
        }

        fun onClickHelp() {
            showToast("코인")
        }
    }
}