package com.ballboycorp.tingting.pocha.dialog

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import com.ballboycorp.tingting.R
import com.ballboycorp.tingting.databinding.DialogNumberOfPeopleBinding
import com.ballboycorp.tingting.pocha.PochaActivity
import com.ballboycorp.tingting.utils.extensions.bind
import com.ballboycorp.tingting.utils.extensions.getViewModel

/**
 * Created by musooff on 20/04/2019.
 */

class NumberOfPeopleDialog : DialogFragment() {

    private val viewModel by lazy { getViewModel<NumberOfPeopleViewModel>() }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val binding = bind<DialogNumberOfPeopleBinding>(inflater, R.layout.dialog_number_of_people, container)
        binding.viewModel = viewModel
        binding.clickHandler = ClickHandler()
        dialog?.setCanceledOnTouchOutside(false)
        return binding.root
    }

    inner class ClickHandler {

        fun onClickConfirm() {
            (activity as PochaActivity).onNumberOfPeopleSelected(maleCount = viewModel.numberOfMale, femaleCount = viewModel.numberOfFemale)
            dismiss()
        }
    }
}