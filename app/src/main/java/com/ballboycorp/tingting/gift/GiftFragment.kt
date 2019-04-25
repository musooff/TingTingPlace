package com.ballboycorp.tingting.gift

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.ballboycorp.tingting.R
import com.ballboycorp.tingting.base.BaseFragment
import com.ballboycorp.tingting.databinding.FragmentGiftBinding
import com.ballboycorp.tingting.gift.adapter.GiftAdapter
import com.ballboycorp.tingting.pocha.dialog.room.model.gift.Gift
import com.ballboycorp.tingting.pocha.dialog.room.model.gift.GiftItemViewModel
import com.ballboycorp.tingting.utils.extensions.bind
import kotlinx.android.synthetic.main.fragment_gift.*

/**
 * Created by musooff on 2019-04-24.
 */

class GiftFragment : BaseFragment() {

    private val adapter = GiftAdapter(ClickHandler())

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val binding = bind<FragmentGiftBinding>(inflater, R.layout.fragment_gift, container)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        rv_gift.adapter = adapter
        rv_gift.layoutManager = LinearLayoutManager(context)
        rv_gift.addItemDecoration(DividerItemDecoration(context, DividerItemDecoration.VERTICAL))

        val testPochas = ArrayList<GiftItemViewModel>()
        for (i in 1..5) {
            val table = Gift()
            testPochas.add(GiftItemViewModel(table))
        }

        adapter.submitList(testPochas)
    }

    fun restoreEverything() {
        adapter.restoreEverything()
    }

    inner class ClickHandler {

        fun onClickAdd(viewModel: GiftItemViewModel) {
            viewModel.count ++
            (activity as GiftActivity).onItemAdded(viewModel)
        }

        fun onClickRemove(viewModel: GiftItemViewModel) {
            if (viewModel.count > 0) {
                viewModel.count --
                (activity as GiftActivity).onItemRemoved(viewModel)
            }
        }
    }
}