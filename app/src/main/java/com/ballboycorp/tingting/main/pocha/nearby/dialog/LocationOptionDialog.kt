package com.ballboycorp.tingting.main.pocha.nearby.dialog

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.FragmentManager
import com.ballboycorp.tingting.R
import com.ballboycorp.tingting.databinding.DialogLocationOptionBinding
import com.ballboycorp.tingting.main.pocha.PochaFragment
import com.ballboycorp.tingting.utils.extensions.bind
import com.ballboycorp.tingting.utils.extensions.getViewModel
import com.ballboycorp.tingting.utils.extensions.setWidthPercentage

/**
 * Created by musooff on 18/04/2019.
 */

class LocationOptionDialog: DialogFragment() {
    companion object {

        private const val DIALOG_TAG = "LocationOptionDialog"

        fun show(fragmentManager: FragmentManager) {
            val dialog = LocationOptionDialog()
            dialog.show(fragmentManager, DIALOG_TAG)
        }
    }

    private val viewModel by lazy { getViewModel<LocationOptionViewModel>() }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val binding = bind<DialogLocationOptionBinding>(inflater, R.layout.dialog_location_option, container)
        binding.viewModel = viewModel
        binding.clickHandler = ClickHandler()
        return binding.root
    }

    override fun onResume() {
        super.onResume()
        setWidthPercentage(.9)
    }

    inner class ClickHandler {
        fun onClickLocationType(type: Int) {
            (parentFragment as PochaFragment).onLocationTypeSelected(type)
            dismiss()
        }

        fun onClickExit() {
            dismiss()
        }
    }
}