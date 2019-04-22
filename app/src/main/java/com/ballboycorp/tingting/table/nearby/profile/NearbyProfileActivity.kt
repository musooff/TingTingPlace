package com.ballboycorp.tingting.table.nearby.profile

import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import com.ballboycorp.tingting.R
import com.ballboycorp.tingting.base.BaseActivity
import com.ballboycorp.tingting.databinding.ActivityNearbyTableProfileBinding
import com.ballboycorp.tingting.table.model.Table
import com.ballboycorp.tingting.table.model.TableItemViewModel
import com.ballboycorp.tingting.table.nearby.profile.adapter.NearbyTablePeopleAdapter
import com.ballboycorp.tingting.utils.extensions.bind
import com.ballboycorp.tingting.utils.extensions.getViewModel
import com.ballboycorp.tingting.utils.extensions.showShortToast
import kotlinx.android.synthetic.main.activity_table_profile.*

/**
 * Created by musooff on 2019-04-23.
 */

class NearbyProfileActivity: BaseActivity(){

    companion object {
        const val TABLE = "table"
        const val CHAT_SELECTION_MODE = "chat_selection_mode"
    }

    private val viewModel by lazy { getViewModel<NearbyProfileViewModel>() }
    private lateinit var binding: ActivityNearbyTableProfileBinding

    private val clickHandler = ClickHandler()
    private val adapter = NearbyTablePeopleAdapter(clickHandler)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = bind(R.layout.activity_nearby_table_profile)
        binding.viewModel = viewModel
        binding.clickHandler = ClickHandler()

        rv_table_people.layoutManager = GridLayoutManager(this, 2)
        rv_table_people.adapter = adapter

        initialize()
    }

    private fun initialize() {
        intent?.extras?.let {
            val table = it.getParcelable<Table>(TABLE)!!
            viewModel.tableItemViewModel = TableItemViewModel(table)
            viewModel.chatSelectionMode = it.getBoolean(CHAT_SELECTION_MODE)
            viewModel.updateGuide()

            adapter.submitList(viewModel.tableItemViewModel)
        }

    }

    inner class ClickHandler {
        fun onClickBack() {
            onBackPressed()
        }

        fun onClickProfile(number: Int) {
            if (viewModel.chatSelectionMode) {
                showShortToast("selected")
            }
        }
    }
}