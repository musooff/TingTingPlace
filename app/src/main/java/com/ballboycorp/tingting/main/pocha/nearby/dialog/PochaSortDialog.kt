package com.ballboycorp.tingting.main.pocha.nearby.dialog

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.FragmentManager
import com.ballboycorp.tingting.R
import com.ballboycorp.tingting.databinding.DialogPochaSortBinding
import com.ballboycorp.tingting.main.pocha.model.SortType
import com.ballboycorp.tingting.utils.extensions.bind
import com.ballboycorp.tingting.utils.extensions.getViewModel

/**
 * Created by musooff on 18/04/2019.
 */

class PochaSortDialog : DialogFragment() {

    companion object {

        private const val SORT_TYPE = "sort_type"
        private const val DIALOG_TAG = "PochaSortDialog"
        private const val HAS_DISTANCE = "has_distance"

        fun show(fragmentManager: FragmentManager, sortType: SortType, hasDistance: Boolean) {
            val dialog = PochaSortDialog()
            dialog.arguments = Bundle()
                    .apply {
                        putString(SORT_TYPE, sortType.text)
                        putBoolean(HAS_DISTANCE, hasDistance)
                    }
            dialog.show(fragmentManager, DIALOG_TAG)
        }
    }

    private val viewModel by lazy { getViewModel<PochaSortViewModel>() }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val binding = bind<DialogPochaSortBinding>(inflater, R.layout.dialog_pocha_sort, container)
        binding.viewModel = viewModel
        binding.clickHandler = ClickHandler()
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        arguments?.let {
            viewModel.sortType = SortType.getSortType(it.getString(SORT_TYPE)!!)
            viewModel.hasDistance = it.getBoolean(HAS_DISTANCE)
        }

    }

    inner class ClickHandler {
        fun onClickSort(sortType: SortType) {
            viewModel.sortType = sortType
            (parentFragment as SortDialogListener).onResult(sortType)
            dismiss()
        }

        fun onClickExit() {
            dismiss()
        }
    }
}