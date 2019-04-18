package com.ballboycorp.tingting.review.my

import android.os.Bundle
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.ballboycorp.tingting.R
import com.ballboycorp.tingting.base.BaseActivity
import com.ballboycorp.tingting.databinding.ActivityMyReviewsBinding
import com.ballboycorp.tingting.main.pocha.model.Pocha
import com.ballboycorp.tingting.main.pocha.model.PochaItemViewModel
import com.ballboycorp.tingting.pocha.details.PochaDetailsActivity
import com.ballboycorp.tingting.review.add.AddReviewActivity
import com.ballboycorp.tingting.review.model.Review
import com.ballboycorp.tingting.review.my.adapter.CanReviewAdapter
import com.ballboycorp.tingting.review.my.adapter.MyReviewsAdapter
import com.ballboycorp.tingting.utils.extensions.bind
import com.ballboycorp.tingting.utils.extensions.getViewModel
import com.ballboycorp.tingting.utils.extensions.startActivity
import kotlinx.android.synthetic.main.activity_my_reviews.*

/**
 * Created by musooff on 18/04/2019.
 */

class MyReviewsActivity: BaseActivity() {

    private val clickHandler = ClickHandler()
    private val canReviewAdapter = CanReviewAdapter(clickHandler)
    private val myReviewsAdapter = MyReviewsAdapter(clickHandler)

    private val viewModel by lazy { getViewModel<MyReviewsViewModel>() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = bind<ActivityMyReviewsBinding>(R.layout.activity_my_reviews)
        binding.viewModel = viewModel

        initToolbar("나의 리뷰", true)

        rv_can_review.adapter = canReviewAdapter
        rv_can_review.layoutManager = LinearLayoutManager(this)

        rv_can_review.addItemDecoration(DividerItemDecoration(this,
                DividerItemDecoration.VERTICAL))

        val testPochas = ArrayList<PochaItemViewModel>()
        for (i in 1..2) {
            testPochas.add(PochaItemViewModel(
                    Pocha().apply { myReview = Review() }
            ))
        }
        canReviewAdapter.submitList(testPochas)
        viewModel.canReviewSize = canReviewAdapter.itemCount


        rv_reviewed.layoutManager = LinearLayoutManager(this)
        rv_reviewed.adapter = myReviewsAdapter
        rv_reviewed.addItemDecoration(DividerItemDecoration(this,
                DividerItemDecoration.VERTICAL))
        myReviewsAdapter.submitList(testPochas)
        viewModel.myReviewsSize = myReviewsAdapter.itemCount
    }


    inner class ClickHandler {
        fun onClickReviewedItem(viewModel: PochaItemViewModel) {
            startActivity<PochaDetailsActivity>()
        }

        fun onClickCanReviewItem(viewModel: PochaItemViewModel) {
            startActivity<PochaDetailsActivity>()
        }

        fun onClickReview(viewModel: PochaItemViewModel) {
            startActivity<AddReviewActivity>()
        }

        fun onClickRemove(viewModel: PochaItemViewModel) {

        }
    }
}