package com.ballboycorp.tingting.liked

import android.os.Bundle
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.ballboycorp.tingting.R
import com.ballboycorp.tingting.base.BaseActivity
import com.ballboycorp.tingting.databinding.ActivityLikedBinding
import com.ballboycorp.tingting.liked.adapter.LikedAdapter
import com.ballboycorp.tingting.main.pocha.model.Pocha
import com.ballboycorp.tingting.utils.extensions.bind
import com.ballboycorp.tingting.utils.extensions.getViewModel
import com.ballboycorp.tingting.utils.extensions.observe
import kotlinx.android.synthetic.main.activity_liked.*

/**
 * Created by musooff on 13/04/2019.
 */

class LikedActivity: BaseActivity() {

    private val adapter = LikedAdapter()

    private val viewModel by lazy { getViewModel<LikedViewModel>() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = bind<ActivityLikedBinding>(R.layout.activity_liked)
        binding.viewModel = viewModel
        binding.clickHandler = ClickHandler()

        setSupportActionBar(toolbar)
        viewModel.toolbarTitle = "찜한 포차"

        rv_main.adapter = adapter
        rv_main.layoutManager = LinearLayoutManager(this)

        rv_main.addItemDecoration(DividerItemDecoration(this,
                DividerItemDecoration.VERTICAL))

        val testPochas = ArrayList<Pocha>()
        for (i in 1..10) {
            testPochas.add(Pocha())
        }

        adapter.submitList(testPochas)

        adapter.selected.observe(this) {
            button_delete.isEnabled = !it.isNullOrEmpty()
        }

    }

    inner class ClickHandler {

        fun onClickEdit() {
            switchMode()
        }

        fun onClickDelete() {
            adapter.deleteSelected()
            switchMode()
        }

        private fun switchMode() {
            viewModel.isEditMode = !viewModel.isEditMode
            adapter.editMode(viewModel.isEditMode)
        }

        fun onClickBack() {
            onBackPressed()
        }
    }
}