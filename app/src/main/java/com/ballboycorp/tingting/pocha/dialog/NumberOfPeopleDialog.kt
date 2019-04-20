package com.ballboycorp.tingting.pocha.dialog

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.FragmentManager
import com.ballboycorp.tingting.R
import com.ballboycorp.tingting.databinding.DialogNumberOfPeopleBinding
import com.ballboycorp.tingting.utils.extensions.bind
import com.ballboycorp.tingting.utils.extensions.getViewModel

/**
 * Created by musooff on 20/04/2019.
 */

class NumberOfPeopleDialog: DialogFragment() {

    companion object {

        private const val DIALOG_TAG = "NumberOfPeopleDialog"

        fun show(fragmentManager: FragmentManager) {
            val dialog = NumberOfPeopleDialog()
            dialog.show(fragmentManager, DIALOG_TAG)
        }
    }

    private val viewModel by lazy { getViewModel<NumberOfPeopleViewModel>() }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val binding = bind<DialogNumberOfPeopleBinding>(inflater, R.layout.dialog_number_of_people, container)
        binding.viewModel = viewModel
        binding.clickHandler = ClickHandler()
        return binding.root
    }

    inner class ClickHandler {

        fun onClickConfirm() {
            dismiss()
        }

        fun onClickExit() {
            dismiss()
        }
    }
}