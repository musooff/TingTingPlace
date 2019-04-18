package com.ballboycorp.tingting.main.pocha.region

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.ballboycorp.tingting.R
import com.ballboycorp.tingting.base.BaseFragment
import com.ballboycorp.tingting.databinding.FragmentRegionBinding
import com.ballboycorp.tingting.main.pocha.model.SortType
import com.ballboycorp.tingting.main.pocha.dialog.PochaSortDialog
import com.ballboycorp.tingting.main.pocha.dialog.SortDialogListener
import com.ballboycorp.tingting.utils.extensions.bind
import com.ballboycorp.tingting.utils.extensions.getViewModel

/**
 * Created by musooff on 12/04/2019.
 */

class RegionFragment: BaseFragment(), SortDialogListener {

    private val viewModel by lazy { getViewModel<RegionViewModel>() }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val binding = bind<FragmentRegionBinding>(inflater, R.layout.fragment_region, container)
        binding.viewModel = viewModel
        binding.clickHandler = ClickHandler()
        return binding.root
    }

    override fun onResult(sortType: SortType) {
        viewModel.sortType = sortType
    }

    inner class ClickHandler {

        fun onClickSortType() {
            PochaSortDialog.show(childFragmentManager, viewModel.sortType, false)
        }
    }
}