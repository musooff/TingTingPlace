package com.ballboycorp.tingting.pocha.home.dialog.settings

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.FragmentManager
import com.ballboycorp.tingting.R
import com.ballboycorp.tingting.databinding.DialogPochaSettingsBinding
import com.ballboycorp.tingting.utils.extensions.bind
import com.ballboycorp.tingting.utils.extensions.getViewModel

/**
 * Created by musooff on 2019-04-21.
 */

class SettingsDialog: DialogFragment() {

    companion object {

        private const val DIALOG_TAG = "SettingsDialog"

        fun show(fragmentManager: FragmentManager) {
            val dialog = SettingsDialog()
            dialog.show(fragmentManager, DIALOG_TAG)
        }
    }

    private val viewModel by lazy { getViewModel<SettingsViewModel>() }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val binding = bind<DialogPochaSettingsBinding>(inflater, R.layout.dialog_pocha_settings, container)
        binding.viewModel = viewModel
        binding.clickHandler = ClickHandler()
        return binding.root
    }

    inner class ClickHandler {
        fun onClickExit() {
            dismiss()
        }
    }
}