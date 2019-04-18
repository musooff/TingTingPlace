package com.ballboycorp.tingting.contact

import android.os.Bundle
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.ballboycorp.tingting.R
import com.ballboycorp.tingting.base.BaseActivity
import com.ballboycorp.tingting.contact.adapter.ContactAdapter
import com.ballboycorp.tingting.contact.add.NewQuestionActivity
import com.ballboycorp.tingting.contact.model.Answer
import com.ballboycorp.tingting.contact.model.Question
import com.ballboycorp.tingting.contact.model.QuestionItemViewModel
import com.ballboycorp.tingting.databinding.ActivityContactBinding
import com.ballboycorp.tingting.utils.extensions.bind
import com.ballboycorp.tingting.utils.extensions.startActivity
import kotlinx.android.synthetic.main.activity_contact.*

/**
 * Created by musooff on 18/04/2019.
 */

class ContactActivity : BaseActivity(){

    private val clickHandler = ClickHandler()
    private val adapter = ContactAdapter(clickHandler)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = bind<ActivityContactBinding>(R.layout.activity_contact)
        binding.clickHandler = ClickHandler()
        rv_contact.adapter = adapter
        rv_contact.layoutManager = LinearLayoutManager(this)



        rv_contact.addItemDecoration(DividerItemDecoration(this,
                DividerItemDecoration.VERTICAL))

        val testNotices = ArrayList<QuestionItemViewModel>()
        for (i in 1..3) {
            testNotices.add(QuestionItemViewModel(Question().apply {
                id = i
                if (i == 1) {
                    answer = Answer()
                    isAnswered = true
                }
            }))
        }
        adapter.submitList(testNotices)
    }

    inner class ClickHandler {
        fun onClickItem(viewModel: QuestionItemViewModel) {
            adapter.onClickItem(viewModel)
        }

        fun onClickBack() {
            onBackPressed()
        }

        fun onClickNew() {
            startActivity<NewQuestionActivity>()
        }
    }
}