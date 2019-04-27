package com.ballboycorp.tingting.common.dialog

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.FragmentManager
import com.ballboycorp.tingting.R
import com.ballboycorp.tingting.databinding.DialogYesNoBinding
import com.ballboycorp.tingting.utils.extensions.bind
import com.ballboycorp.tingting.utils.extensions.getViewModel

/**
 * Created by musooff on 2019-04-23.
 */

class YesNoDialog: DialogFragment() {

    companion object {

        private const val DIALOG_TAG = "YesNoDialog"
        const val REASON = "reason"
        const val TITLE = "title"
        const val TEXT = "text"

        fun show(fragmentManager: FragmentManager, title: String, text: String) {
            val dialog = YesNoDialog()
            dialog.arguments = Bundle().apply {
                putString(TITLE, title)
                putString(TEXT, text)
            }
            dialog.show(fragmentManager, DIALOG_TAG)
        }
    }

    private lateinit var yesNoCallback: YesNoCallback
    private lateinit var reason: String


    private val viewModel by lazy { getViewModel<YesNoViewModel>() }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        targetFragment?.let {
            yesNoCallback = it as YesNoCallback
            return
        }
        yesNoCallback = context as YesNoCallback
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val binding = bind<DialogYesNoBinding>(inflater, R.layout.dialog_yes_no, container)
        binding.clickHandler = ClickHandler()
        binding.viewModel = viewModel
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        arguments?.let {
            reason = it.getString(REASON)!!
            viewModel.title = it.getString(TITLE)
            viewModel.text = it.getString(TEXT)
        }
    }

    inner class ClickHandler {

        fun onClickNo() {
            yesNoCallback.onNo(reason)
            dismiss()
        }

        fun onClickYes() {
            yesNoCallback.onYes(reason)
            dismiss()
        }
    }
}