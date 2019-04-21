package com.ballboycorp.tingting.pocha.home.dialog.hashtag

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.FragmentManager
import com.ballboycorp.tingting.R
import com.ballboycorp.tingting.databinding.DialogHashtagEditBinding
import com.ballboycorp.tingting.pocha.home.HomeFragment
import com.ballboycorp.tingting.utils.extensions.bind
import com.ballboycorp.tingting.utils.extensions.getViewModel

/**
 * Created by musooff on 2019-04-22.
 */

class HashtagEditDialog: DialogFragment() {

    companion object {

        private const val DIALOG_TAG = "HashtagEditDialog"

        fun show(fragmentManager: FragmentManager) {
            val dialog = HashtagEditDialog()
            dialog.show(fragmentManager, DIALOG_TAG)
        }
    }

    private val viewModel by lazy { getViewModel<HashtagEditViewModel>() }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val binding = bind<DialogHashtagEditBinding>(inflater, R.layout.dialog_hashtag_edit, container)
        binding.viewModel = viewModel
        binding.clickHandler = ClickHandler()
        return binding.root
    }

    inner class ClickHandler {
        fun onClickExit() {
            dismiss()
        }

        fun onClickConfirm() {
            viewModel.saveHashTag()
            (parentFragment as HomeFragment).onHashtagChanged()
            dismiss()
        }
    }
}