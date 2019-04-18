package com.ballboycorp.tingting.event.viewer

import android.os.Bundle
import com.ballboycorp.tingting.R
import com.ballboycorp.tingting.base.BaseActivity
import com.ballboycorp.tingting.databinding.ActivityEventViewerBinding
import com.ballboycorp.tingting.utils.extensions.bind
import com.ballboycorp.tingting.utils.extensions.getViewModel

/**
 * Created by musooff on 18/04/2019.
 */

class EventViewerActivity: BaseActivity() {

    private val viewModel by lazy { getViewModel<EventViewerViewModel>() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = bind<ActivityEventViewerBinding>(R.layout.activity_event_viewer)
        binding.viewModel = viewModel
        initToolbar("이벤트", true)
    }
}