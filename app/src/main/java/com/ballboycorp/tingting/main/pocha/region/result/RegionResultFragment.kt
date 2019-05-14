package com.ballboycorp.tingting.main.pocha.region.result

import com.ballboycorp.tingting.base.BaseFragment
import com.ballboycorp.tingting.main.pocha.dialog.PochaSortDialog
import com.ballboycorp.tingting.main.pocha.dialog.SortDialogListener
import com.ballboycorp.tingting.main.pocha.model.SortType
import com.ballboycorp.tingting.utils.extensions.getViewModel

/**
 * Created by musooff on 2019-05-13.
 */

class RegionResultFragment: BaseFragment(), SortDialogListener {

    private val viewModel by lazy { getViewModel<RegionResultViewModel>() }


    override fun onResult(sortType: SortType) {
        viewModel.sortType = sortType
    }

    inner class ClickHandler {
        fun onClickSortType() {
            PochaSortDialog.show(childFragmentManager, viewModel.sortType, false)
        }

    }
}