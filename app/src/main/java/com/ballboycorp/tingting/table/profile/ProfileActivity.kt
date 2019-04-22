package com.ballboycorp.tingting.table.profile

import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import com.ballboycorp.tingting.R
import com.ballboycorp.tingting.base.BaseActivity
import com.ballboycorp.tingting.databinding.ActivityTableProfileBinding
import com.ballboycorp.tingting.table.model.Table
import com.ballboycorp.tingting.table.model.TableItemViewModel
import com.ballboycorp.tingting.table.profile.adapter.TablePeopleAdapter
import com.ballboycorp.tingting.utils.extensions.bind
import com.ballboycorp.tingting.utils.extensions.getViewModel
import com.ballboycorp.tingting.utils.extensions.showShortToast
import com.ballboycorp.tingting.utils.extensions.startActivity
import kotlinx.android.synthetic.main.activity_table_profile.*

/**
 * Created by musooff on 2019-04-21.
 */

class ProfileActivity: BaseActivity(){

    companion object {
        const val TABLE = "table"
        const val GAME_SELECTION_MODE = "game_selection_mode"
        const val CHAT_SELECTION_MODE = "chat_selection_mode"
    }

    private val viewModel by lazy { getViewModel<ProfileViewModel>() }
    private lateinit var binding: ActivityTableProfileBinding

    private val clickHandler = ClickHandler()
    private val adapter = TablePeopleAdapter(clickHandler)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = bind(R.layout.activity_table_profile)
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
            viewModel.gameSelectionMode = it.getBoolean(GAME_SELECTION_MODE)
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
            if (viewModel.chatSelectionMode || viewModel.gameSelectionMode) {
                showShortToast("selected")
            }
        }
    }
}