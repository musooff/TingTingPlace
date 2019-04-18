package com.ballboycorp.tingting.notice

import android.os.Bundle
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.ballboycorp.tingting.R
import com.ballboycorp.tingting.base.BaseActivity
import com.ballboycorp.tingting.databinding.ActivityNoticeBinding
import com.ballboycorp.tingting.main.pocha.model.Pocha
import com.ballboycorp.tingting.main.pocha.model.PochaItemViewModel
import com.ballboycorp.tingting.notice.adapter.NoticeAdapter
import com.ballboycorp.tingting.notice.model.Notice
import com.ballboycorp.tingting.notice.model.NoticeItemViewModel
import com.ballboycorp.tingting.utils.extensions.bind
import com.ballboycorp.tingting.utils.extensions.getViewModel
import kotlinx.android.synthetic.main.activity_notice.*

/**
 * Created by musooff on 18/04/2019.
 */

class NoticeActivity: BaseActivity() {

    private val clickHandler = ClickHandler()
    private val adapter =  NoticeAdapter(clickHandler)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = bind<ActivityNoticeBinding>(R.layout.activity_notice)

        initToolbar("공지사항", true)

        rv_notice.adapter = adapter
        rv_notice.layoutManager = LinearLayoutManager(this)



        rv_notice.addItemDecoration(DividerItemDecoration(this,
                DividerItemDecoration.VERTICAL))

        val testNotices = ArrayList<NoticeItemViewModel>()
        for (i in 1..3) {
            testNotices.add(NoticeItemViewModel(Notice().apply { id = i }))
        }
        adapter.submitList(testNotices)
    }

    inner class ClickHandler {
        fun onClickItem(viewModel: NoticeItemViewModel) {
            adapter.onClickItem(viewModel)
        }
    }
}