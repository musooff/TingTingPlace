package com.ballboycorp.tingting.event

import android.os.Bundle
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.ballboycorp.tingting.R
import com.ballboycorp.tingting.base.BaseActivity
import com.ballboycorp.tingting.databinding.ActivtyEventBinding
import com.ballboycorp.tingting.event.adapter.EventAdapter
import com.ballboycorp.tingting.event.model.Event
import com.ballboycorp.tingting.event.model.EventItemViewModel
import com.ballboycorp.tingting.event.viewer.EventViewerActivity
import com.ballboycorp.tingting.notice.model.Notice
import com.ballboycorp.tingting.notice.model.NoticeItemViewModel
import com.ballboycorp.tingting.utils.extensions.bind
import com.ballboycorp.tingting.utils.extensions.startActivity
import kotlinx.android.synthetic.main.activity_notice.*
import kotlinx.android.synthetic.main.activty_event.*

/**
 * Created by musooff on 18/04/2019.
 */

class EventActivity: BaseActivity() {

    private val clickHandler = ClickHandler()
    private val adapter = EventAdapter(clickHandler)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = bind<ActivtyEventBinding>(R.layout.activty_event)

        initToolbar("이벤트", true)

        rv_event.adapter = adapter
        rv_event.layoutManager = LinearLayoutManager(this)



        rv_event.addItemDecoration(DividerItemDecoration(this,
                DividerItemDecoration.VERTICAL))

        val testEvents = ArrayList<EventItemViewModel>()
        for (i in 1..3) {
            testEvents.add(EventItemViewModel(Event()))
        }
        adapter.submitList(testEvents)
    }

    inner class ClickHandler {
        fun onClickItem(viewModel: EventItemViewModel) {
            startActivity<EventViewerActivity>()
        }
    }
}