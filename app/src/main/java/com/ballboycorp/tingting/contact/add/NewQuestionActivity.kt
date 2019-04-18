package com.ballboycorp.tingting.contact.add

import android.os.Bundle
import com.ballboycorp.tingting.R
import com.ballboycorp.tingting.base.BaseActivity
import com.ballboycorp.tingting.databinding.ActivityNewQuestionBinding
import com.ballboycorp.tingting.utils.extensions.bind
import com.ballboycorp.tingting.utils.extensions.getViewModel

/**
 * Created by musooff on 18/04/2019.
 */

class NewQuestionActivity: BaseActivity() {

    private val viewModel by lazy { getViewModel<NewQuestionViewModel>() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = bind<ActivityNewQuestionBinding>(R.layout.activity_new_question)
        binding.viewModel = viewModel
        binding.clickHandler = ClickHandler()
        initToolbar("새 문의 작성", true)
    }

    inner class ClickHandler {
        fun onClickSubmit() {
            finish()
        }
    }
}