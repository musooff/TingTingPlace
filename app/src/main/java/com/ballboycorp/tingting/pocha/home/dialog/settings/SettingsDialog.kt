package com.ballboycorp.tingting.pocha.home.dialog.settings

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import com.ballboycorp.tingting.R
import com.ballboycorp.tingting.databinding.DialogPochaSettingsBinding
import com.ballboycorp.tingting.utils.extensions.bind
import com.ballboycorp.tingting.utils.extensions.getViewModel
import com.ballboycorp.tingting.utils.extensions.setWidthPercentage

/**
 * Created by musooff on 2019-04-21.
 */

class SettingsDialog: DialogFragment() {

    private val viewModel by lazy { getViewModel<SettingsViewModel>() }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val binding = bind<DialogPochaSettingsBinding>(inflater, R.layout.dialog_pocha_settings, container)
        binding.viewModel = viewModel
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