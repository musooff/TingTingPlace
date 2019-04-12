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
import com.ballboycorp.tingting.utils.extensions.bind
import kotlinx.android.synthetic.main.fragment_search.*
import androidx.recyclerview.widget.DividerItemDecoration
import com.ballboycorp.tingting.utils.extensions.getViewModel
import android.content.Context
import android.view.inputmethod.InputMethodManager


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

        rv_main.adapter = adapter
        rv_main.layoutManager = LinearLayoutManager(context)

        rv_main.addItemDecoration(DividerItemDecoration(context!!,
                DividerItemDecoration.VERTICAL))


    }

    inner class ClickHandler {

        fun onClickSearch() {
            if (et_search.text.isNullOrBlank()) {
                view_empty.visibility = View.VISIBLE
                adapter.submitList(emptyList())
            }
            else {
                view_empty.visibility = View.INVISIBLE
                adapter.submitList(arrayListOf(Pocha(), Pocha()))
            }
            et_search.clearFocus()
            (activity?.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager)
                    .apply { hideSoftInputFromWindow(et_search.windowToken, 0) }
        }
    }
}