package com.ballboycorp.tingting.main.pocha.region

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.ballboycorp.tingting.R
import com.ballboycorp.tingting.base.BaseFragment
import com.ballboycorp.tingting.databinding.FragmentRegionBinding
import com.ballboycorp.tingting.main.pocha.region.adapter.AreaAdapter
import com.ballboycorp.tingting.main.pocha.region.model.AreaItemViewModel
import com.ballboycorp.tingting.utils.extensions.bind
import com.ballboycorp.tingting.utils.extensions.getViewModel
import com.ballboycorp.tingting.utils.extensions.showToast
import kotlinx.android.synthetic.main.fragment_region.*

/**
 * Created by musooff on 12/04/2019.
 */

class RegionFragment : BaseFragment() {

    private val viewModel by lazy { getViewModel<RegionViewModel>() }

    private val clickHandler = ClickHandler()
    private val areaAdapter = AreaAdapter(clickHandler)

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val binding = bind<FragmentRegionBinding>(inflater, R.layout.fragment_region, container)
        binding.viewModel = viewModel
        binding.clickHandler = ClickHandler()
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        rv_area.adapter = areaAdapter
        rv_area.layoutManager = LinearLayoutManager(mContext)

        initialize()
    }

    private fun initialize() {
        addDisposable(viewModel.getAreas()
                .subscribe({
                    areaAdapter.submitList(it)
                    if (it.isNotEmpty())
                        areaAdapter.setSelected(it[0].area.id)
                }, {
                    showToast("Error loading areas")
                })
        )
    }

    inner class ClickHandler {


        fun onClickArea(id: Long) {
            areaAdapter.setSelected(id)
        }
    }
}