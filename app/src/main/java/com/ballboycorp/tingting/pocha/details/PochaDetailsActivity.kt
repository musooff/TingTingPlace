package com.ballboycorp.tingting.pocha.details

import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import com.ballboycorp.tingting.R
import com.ballboycorp.tingting.base.BaseActivity
import com.ballboycorp.tingting.databinding.ActivityPochaDetailsBinding
import com.ballboycorp.tingting.pocha.details.adapter.MenuAdapter
import com.ballboycorp.tingting.utils.extensions.bind
import com.ballboycorp.tingting.utils.extensions.getViewModel
import com.ballboycorp.tingting.utils.extensions.observe
import kotlinx.android.synthetic.main.activity_pocha_details.*

/**
 * Created by musooff on 13/04/2019.
 */

class PochaDetailsActivity: BaseActivity() {

    private val viewModel by lazy { getViewModel<PochaDetailsViewModel>() }

    private val menuAdapter = MenuAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = bind<ActivityPochaDetailsBinding>(R.layout.activity_pocha_details)
        binding.viewModel = viewModel
        binding.clickHandler = ClickHandler()
        initialize()
    }

    private fun initialize() {
        viewModel.getPocha()


        viewModel.getMenus().observe(this) {
            menuAdapter.submitList(it)
        }
    }

    inner class ClickHandler {

        fun onClickBack() {
            this@PochaDetailsActivity.onBackPressed()
        }

        fun onClickLike() {
            viewModel.isLiked = !viewModel.isLiked
        }
    }
}