package com.ballboycorp.tingting.table.my

import android.content.Intent
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import com.ballboycorp.tingting.R
import com.ballboycorp.tingting.base.BaseActivity
import com.ballboycorp.tingting.databinding.ActivityMyTableProfileBinding
import com.ballboycorp.tingting.profile.edit.EditProfileActivity
import com.ballboycorp.tingting.table.model.Table
import com.ballboycorp.tingting.table.model.TableItemViewModel
import com.ballboycorp.tingting.table.my.adapter.MyTablePeopleAdapter
import com.ballboycorp.tingting.utils.extensions.bind
import com.ballboycorp.tingting.utils.extensions.getViewModel
import com.ballboycorp.tingting.utils.extensions.startActivityForResult
import kotlinx.android.synthetic.main.activity_table_profile.*

/**
 * Created by musooff on 2019-04-23.
 */

class MyTableProfileActivity: BaseActivity() {

    companion object {
        const val TABLE = "table"
        private const val EDIT_REQUEST = 1
    }

    private val viewModel by lazy { getViewModel<MyTableProfileViewModel>() }
    private lateinit var binding: ActivityMyTableProfileBinding

    private val clickHandler = ClickHandler()
    private val adapter = MyTablePeopleAdapter(clickHandler)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = bind(R.layout.activity_my_table_profile)
        binding.viewModel = viewModel
        binding.clickHandler = ClickHandler()
        initToolbar("내 테이블 프로필", true)

        rv_table_people.layoutManager = GridLayoutManager(this, 2)
        rv_table_people.adapter = adapter

        initialize()
    }

    private fun initialize() {
        intent?.extras?.let {
            val table = it.getParcelable<Table>(TABLE)!!
            viewModel.tableItemViewModel = TableItemViewModel(table)

            adapter.submitList(viewModel.tableItemViewModel, 0)
        }

    }

    inner class ClickHandler {

        fun onClickProfile(number: Int) {
            if (number == 0) {
                startActivityForResult<EditProfileActivity>(EDIT_REQUEST)
            }
        }

        fun onClickEditMyProfile() {
            startActivityForResult<EditProfileActivity>(EDIT_REQUEST)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        // TODO update my profile
    }
}
