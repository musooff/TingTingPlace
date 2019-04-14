package com.ballboycorp.tingting.review

import android.os.Bundle
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.ballboycorp.tingting.R
import com.ballboycorp.tingting.base.BaseActivity
import com.ballboycorp.tingting.databinding.ActivityReviewBinding
import com.ballboycorp.tingting.review.adapter.ReviewAdapter
import com.ballboycorp.tingting.utils.extensions.bind
import com.ballboycorp.tingting.utils.extensions.getViewModel
import com.ballboycorp.tingting.utils.extensions.observe
import kotlinx.android.synthetic.main.activity_review.*
import kotlinx.android.synthetic.main.toolbar.*

/**
 * Created by musooff on 14/04/2019.
 */

class ReviewActivity: BaseActivity() {

    private val viewModel by lazy { getViewModel<ReviewViewModel>() }

    private val adapter = ReviewAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = bind<ActivityReviewBinding>(R.layout.activity_review)
        binding.viewModel = viewModel

        customToolbar(toolbar, "후기(1085개)", true)

        rv_reviews.adapter = adapter
        rv_reviews.layoutManager = LinearLayoutManager(this)
        rv_reviews.addItemDecoration(DividerItemDecoration(this,
                DividerItemDecoration.VERTICAL))

        viewModel.getReviews().observe(this) {
            adapter.submitList(it)
        }
    }
}