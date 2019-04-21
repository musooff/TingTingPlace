package com.ballboycorp.tingting.table.profile

import android.os.Bundle
import com.ballboycorp.tingting.R
import com.ballboycorp.tingting.base.BaseActivity
import com.ballboycorp.tingting.databinding.ActivityTableProfileBinding
import com.ballboycorp.tingting.table.model.Table
import com.ballboycorp.tingting.table.model.TableItemViewModel
import com.ballboycorp.tingting.table.single.SingleProfileActivity
import com.ballboycorp.tingting.utils.extensions.bind
import com.ballboycorp.tingting.utils.extensions.getViewModel
import com.ballboycorp.tingting.utils.extensions.startActivity

/**
 * Created by musooff on 2019-04-21.
 */

class ProfileActivity: BaseActivity(){

    companion object {
        const val TABLE = "table"
    }

    private val viewModel by lazy { getViewModel<ProfileViewModel>() }
    private lateinit var binding: ActivityTableProfileBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = bind(R.layout.activity_table_profile)
        binding.clickHandler = ClickHandler()

        initialize()
    }

    private fun initialize() {
        val table = intent!!.extras!!.getParcelable<Table>(TABLE)!!
        viewModel.tableItemViewModel = TableItemViewModel(table)
        binding.tableViewModel = viewModel.tableItemViewModel

    }

    inner class ClickHandler {
        fun onClickBack() {
            onBackPressed()
        }

        fun onClickCancel() {

        }

        fun onClickProfile(number: Int) {
            viewModel.tableItemViewModel?.let {
                startActivity<SingleProfileActivity>(
                        SingleProfileActivity.USER_INDEX to number,
                        SingleProfileActivity.TABLE to it.table)
            }
        }

        fun onClickChatting() {

        }

        fun onClickGameRequest() {

        }
    }
}