package com.ballboycorp.tingting.profile.edit

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import com.ballboycorp.tingting.R
import com.ballboycorp.tingting.base.BaseActivity
import com.ballboycorp.tingting.databinding.ActivityEditProfileBinding
import com.ballboycorp.tingting.utils.PermissionUtils
import com.ballboycorp.tingting.utils.extensions.bind
import com.ballboycorp.tingting.utils.extensions.getViewModel
import kotlinx.android.synthetic.main.toolbar.*
import java.io.File

/**
 * Created by musooff on 16/04/2019.
 */

class EditProfileActivity: BaseActivity() {
    companion object {
        private const val REQUEST_GALLERY = 1
    }

    private val viewModel by lazy { getViewModel<EditProfileViewModel>() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = bind<ActivityEditProfileBinding>(R.layout.activity_edit_profile)
        binding.viewModel = viewModel
        binding.clickHandler = ClickHandler()

        customToolbar(toolbar, "프로필 수정", true)

        viewModel.getUser()
    }

    inner class ClickHandler {

        fun onClickSave() {
            viewModel.saveUser()
            finish()
        }

        fun onClickGender(gender: Int) {
            viewModel.gender = gender
            viewModel.verifyCanSave()
        }

        fun onClickImage() {
            val intent = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.INTERNAL_CONTENT_URI)
            startActivityForResult(intent, REQUEST_GALLERY)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == REQUEST_GALLERY) {
            if (resultCode == Activity.RESULT_OK) {
                viewModel.thumb = data?.data
            }
        }
    }
}