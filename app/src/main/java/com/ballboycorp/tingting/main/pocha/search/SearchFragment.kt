package com.ballboycorp.tingting.main.pocha.search

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.ballboycorp.tingting.R
import com.ballboycorp.tingting.base.BaseFragment
import com.ballboycorp.tingting.databinding.FragmentSearchBinding
import com.ballboycorp.tingting.main.pocha.adapter.PochaRecyclerViewAdapter
import com.ballboycorp.tingting.main.pocha.model.Pocha
import kotlinx.android.synthetic.main.fragment_search.*
import androidx.recyclerview.widget.DividerItemDecoration
import android.content.Context
import android.view.inputmethod.InputMethodManager
import com.ballboycorp.tingting.utils.extensions.*


/**
 * Created by musooff on 12/04/2019.
 */

class SearchFragment: BaseFragment() {

    private val adapter = PochaRecyclerViewAdapter()
    private val viewModel by lazy { getViewModel<SearchViewFragment>() }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val binding = bind<FragmentSearchBinding>(inflater, R.layout.fragment_search, container)
        binding.viewModel = viewModel
        binding.clickHandler = ClickHandler()
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        rv_main.apply {
            adapter = adapter
            layoutManager = LinearLayoutManager(context)
            addItemDecoration(DividerItemDecoration(context!!, DividerItemDecoration.VERTICAL))
        }

        initialize()

    }

    private fun initialize() {

        viewModel.pochas.observe(this) {
            adapter.submitList(it)
        }

        viewModel.error.observe(this) {
            showToast(it.message)
        }
    }

    inner class ClickHandler {

        fun onClickSearch() {
            et_search.clearFocus()
            et_search.hideKeyboard()
            viewModel.searchRestaurants()

        }
    }
}