package com.ballboycorp.tingting.review.add

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.provider.MediaStore
import com.ballboycorp.tingting.R
import com.ballboycorp.tingting.base.BaseActivity
import com.ballboycorp.tingting.databinding.ActivityAddReviewBinding
import com.ballboycorp.tingting.utils.extensions.bind
import com.ballboycorp.tingting.utils.extensions.getViewModel

/**
 * Created by musooff on 18/04/2019.
 */

class AddReviewActivity: BaseActivity() {

    companion object {
        private const val REQUEST_GALLERY = 1
    }

    private val viewModel by lazy { getViewModel<AddActivityViewModel>() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = bind<ActivityAddReviewBinding>(R.layout.activity_add_review)
        binding.viewModel = viewModel
        binding.clickHandler = ClickHandler()
        initToolbar("리뷰 작성", true)
    }

    inner class ClickHandler {
        fun onClickImage(index: Int) {
            val intent = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.INTERNAL_CONTENT_URI)
            viewModel.requestedImageIndex = index
            startActivityForResult(intent, REQUEST_GALLERY)
        }

        fun onClickSubmit() {
            finish()
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == REQUEST_GALLERY) {
            if (resultCode == Activity.RESULT_OK) {
                viewModel.addPicture(data?.data)
            }
        }
    }
}