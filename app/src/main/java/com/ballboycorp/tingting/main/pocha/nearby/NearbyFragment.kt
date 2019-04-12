package com.ballboycorp.tingting.main.pocha.nearby

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.ballboycorp.tingting.R
import com.ballboycorp.tingting.base.BaseFragment
import com.ballboycorp.tingting.databinding.FragmentNearbyBinding
import com.ballboycorp.tingting.main.pocha.adapter.PochaRecyclerViewAdapter
import com.ballboycorp.tingting.main.pocha.model.Pocha
import com.ballboycorp.tingting.utils.extensions.bind
import com.ballboycorp.tingting.utils.extensions.getViewModel
import kotlinx.android.synthetic.main.fragment_nearby.*

/**
 * Created by musooff on 12/04/2019.
 */

class NearbyFragment: BaseFragment() {
    private val adapter = PochaRecyclerViewAdapter()
    private val viewModel by lazy { getViewModel<NearbyViewModel>() }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val binding = bind<FragmentNearbyBinding>(inflater, R.layout.fragment_nearby, container)
        binding.viewModel = viewModel
        binding.clickHandler = ClickHandler()
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        rv_main.adapter = adapter
        rv_main.layoutManager = LinearLayoutManager(context)

        rv_main.addItemDecoration(DividerItemDecoration(context!!,
                DividerItemDecoration.VERTICAL))

        val testPochas = ArrayList<Pocha>()
        for (i in 1..10) {
            testPochas.add(Pocha())
        }
        adapter.submitList(testPochas)

    }

    inner class ClickHandler {

    }
}