package com.ballboycorp.tingting.recent

import android.os.Bundle
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.ballboycorp.tingting.R
import com.ballboycorp.tingting.base.BaseActivity
import com.ballboycorp.tingting.databinding.ActivityRecentBinding
import com.ballboycorp.tingting.main.pocha.model.Pocha
import com.ballboycorp.tingting.recent.adapter.RecentAdapter
import com.ballboycorp.tingting.utils.extensions.bind
import kotlinx.android.synthetic.main.fragment_search.*
import kotlinx.android.synthetic.main.toolbar.*

/**
 * Created by musooff on 13/04/2019.
 */

class RecentActivity: BaseActivity() {

    private val adapter = RecentAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = bind<ActivityRecentBinding>(R.layout.activity_recent)

        customToolbar(toolbar, "최근 간 포차",  true)


        rv_main.adapter = adapter
        rv_main.layoutManager = LinearLayoutManager(this)

        rv_main.addItemDecoration(DividerItemDecoration(this,
                DividerItemDecoration.VERTICAL))

        val testPochas = ArrayList<Pocha>()
        for (i in 1..10) {
            testPochas.add(Pocha())
        }
        adapter.submitList(testPochas)
    }
}