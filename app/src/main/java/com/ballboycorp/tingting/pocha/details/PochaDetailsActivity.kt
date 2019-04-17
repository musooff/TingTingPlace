package com.ballboycorp.tingting.pocha.details

import android.os.Bundle
import com.ballboycorp.tingting.R
import com.ballboycorp.tingting.base.BaseActivity
import com.ballboycorp.tingting.databinding.ActivityPochaDetailsBinding
import com.ballboycorp.tingting.pocha.details.adapter.MenuAdapter
import com.ballboycorp.tingting.review.ReviewActivity
import com.ballboycorp.tingting.review.model.ReviewItemViewModel
import com.ballboycorp.tingting.utils.extensions.bind
import com.ballboycorp.tingting.utils.extensions.getViewModel
import com.ballboycorp.tingting.utils.extensions.observe
import com.ballboycorp.tingting.utils.extensions.startActivity
import com.kakao.kakaonavi.Location

/**
 * Created by musooff on 13/04/2019.
 */

class PochaDetailsActivity: BaseActivity() {

    private val viewModel by lazy { getViewModel<PochaDetailsViewModel>() }

    private val menuAdapter = MenuAdapter()

    private lateinit var binding: ActivityPochaDetailsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = bind(R.layout.activity_pocha_details)
        binding.viewModel = viewModel
        binding.clickHandler = ClickHandler()
        initialize()
    }

    private fun initialize() {
        viewModel.getPocha()


        viewModel.getMenus().observe(this) {
            menuAdapter.submitList(it)
        }

        viewModel.getReviews().observe(this) {
            val reviewViewModel = ReviewItemViewModel(it[0])
            binding.review1.viewModel = reviewViewModel
            binding.review2.viewModel = reviewViewModel
        }



    }

    inner class ClickHandler {

        fun onClickBack() {
            this@PochaDetailsActivity.onBackPressed()
        }

        fun onClickLike() {
            viewModel.isLiked = !viewModel.isLiked
        }

        fun onClickMoreReviews() {
            startActivity<ReviewActivity>()
        }
    }
}