package com.ballboycorp.tingting.table.single

import android.os.Bundle
import com.ballboycorp.tingting.R
import com.ballboycorp.tingting.base.BaseActivity
import com.ballboycorp.tingting.databinding.ActivityTableProfileBinding
import com.ballboycorp.tingting.databinding.ActivityTableSingleProfileBinding
import com.ballboycorp.tingting.profile.model.User
import com.ballboycorp.tingting.table.model.Table
import com.ballboycorp.tingting.table.model.TableItemViewModel
import com.ballboycorp.tingting.table.profile.ProfileActivity
import com.ballboycorp.tingting.table.profile.ProfileViewModel
import com.ballboycorp.tingting.utils.extensions.bind
import com.ballboycorp.tingting.utils.extensions.getViewModel
import com.ballboycorp.tingting.utils.extensions.startActivity

/**
 * Created by musooff on 2019-04-21.
 */

class SingleProfileActivity: BaseActivity() {
    companion object {
        const val TABLE = "table"
        const val USER_INDEX = "user_index"
    }

    private val viewModel by lazy { getViewModel<SingleProfileViewModel>() }
    private lateinit var binding: ActivityTableSingleProfileBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = bind(R.layout.activity_table_single_profile)
        binding.viewModel = viewModel
        binding.clickHandler = ClickHandler()

        initialize()
    }

    private fun initialize() {
        val table = intent!!.extras!!.getParcelable<Table>(TABLE)!!
        viewModel.userIndex = intent!!.extras!!.getInt(USER_INDEX)
        binding.tableViewModel = TableItemViewModel(table)

    }

    inner class ClickHandler {
        fun onClickBack() {
            onBackPressed()
        }

        fun onClickProfile() {
        }

        fun onClickOneToChatting() {

        }

        fun onClickGameRequest() {

        }
    }
}