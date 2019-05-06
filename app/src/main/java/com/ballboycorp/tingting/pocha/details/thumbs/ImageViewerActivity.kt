package com.ballboycorp.tingting.pocha.details.thumbs

import android.os.Bundle
import com.ballboycorp.tingting.R
import com.ballboycorp.tingting.base.BaseActivity
import com.ballboycorp.tingting.common.adapter.ImagePagerAdapter
import com.ballboycorp.tingting.databinding.ActivityImageViewerBinding
import com.ballboycorp.tingting.utils.extensions.bind
import com.ballboycorp.tingting.utils.extensions.getViewModel
import com.ballboycorp.tingting.utils.extensions.makeTransparentStatus
import com.ballboycorp.tingting.utils.extensions.onPageChange
import kotlinx.android.synthetic.main.activity_image_viewer.*

/**
 * Created by musooff on 2019-05-06.
 */

class ImageViewerActivity : BaseActivity() {

    companion object {
        const val THUMBS = "thumbs"
        const val TITLE = "title"
    }

    private val adapter = ImagePagerAdapter()

    private val viewModel by lazy { getViewModel<ImageViewerViewModel>() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        makeTransparentStatus()

        val binding = bind<ActivityImageViewerBinding>(R.layout.activity_image_viewer)
        binding.clickHandler = ClickHandler()
        binding.viewModel = viewModel

        initialize()
    }

    private fun initialize() {

        initializeExtras()
        vp_thumb.adapter = adapter

        vp_thumb.onPageChange { viewModel.currentItem = it }

        adapter.submitList(viewModel.thumbs)
    }

    private fun initializeExtras() {
        intent.extras?.let {
            viewModel.title = it.getString(TITLE)
            viewModel.thumbs = it.getStringArrayList(THUMBS) ?: arrayListOf()
        }
    }

    inner class ClickHandler {
        fun onClickExit() {
            finish()
        }
    }


}