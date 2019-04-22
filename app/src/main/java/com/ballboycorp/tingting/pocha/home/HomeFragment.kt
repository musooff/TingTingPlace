package com.ballboycorp.tingting.pocha.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.ballboycorp.tingting.R
import com.ballboycorp.tingting.base.BaseFragment
import com.ballboycorp.tingting.common.dialog.YesNoDialog
import com.ballboycorp.tingting.databinding.FragmentPochaHomeBinding
import com.ballboycorp.tingting.main.home.utils.ItemDecorator
import com.ballboycorp.tingting.pocha.home.adapter.NearbyTableAdapter
import com.ballboycorp.tingting.pocha.home.adapter.TableAdapter
import com.ballboycorp.tingting.pocha.home.description.GameGiftDescriptionActivity
import com.ballboycorp.tingting.pocha.home.dialog.hashtag.HashtagEditDialog
import com.ballboycorp.tingting.pocha.home.dialog.settings.SettingsDialog
import com.ballboycorp.tingting.table.model.Table
import com.ballboycorp.tingting.table.model.TableItemViewModel
import com.ballboycorp.tingting.table.nearby.profile.NearbyProfileActivity
import com.ballboycorp.tingting.table.profile.ProfileActivity
import com.ballboycorp.tingting.utils.extensions.bind
import com.ballboycorp.tingting.utils.extensions.getViewModel
import com.ballboycorp.tingting.utils.extensions.startActivity
import kotlinx.android.synthetic.main.fragment_pocha_home.*

/**
 * Created by musooff on 20/04/2019.
 */

class HomeFragment: BaseFragment() {

    private lateinit var binding: FragmentPochaHomeBinding

    private val clickHandler = ClickHandler()
    private var tableAdapter = TableAdapter(clickHandler)
    private var nearbyTableAdapter = NearbyTableAdapter(clickHandler)

    private val viewModel by lazy { getViewModel<HomeViewModel>() }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = bind(inflater, R.layout.fragment_pocha_home, container)
        binding.viewModel = viewModel
        binding.clickHandler = ClickHandler()
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        rv_table.adapter = tableAdapter
        rv_table.layoutManager = LinearLayoutManager(context)
        rv_table.addItemDecoration(ItemDecorator.emptyVertical(context!!))

        val testPochas = ArrayList<TableItemViewModel>()
        for (i in 1..10) {
            val table = Table()
            table.addTestPeople()
            testPochas.add(TableItemViewModel(table))
        }
        tableAdapter.submitList(testPochas)

        rv_table_nearby.adapter = nearbyTableAdapter
        rv_table_nearby.layoutManager = LinearLayoutManager(context)
        rv_table_nearby.addItemDecoration(ItemDecorator.emptyVertical(context!!))

        nearbyTableAdapter.submitList(testPochas)
    }

    fun onNumberOfPeopleSelected(maleCount: Int, femaleCount: Int) {
        val table = Table(
                maleCount = maleCount,
                femaleCount = femaleCount
        )
        table.addTestPeople()
        binding.myTable.itemViewModel = TableItemViewModel(table)

    }

    fun onHashtagChanged() {
    }

    inner class ClickHandler {

        fun onClickSettings() {
            SettingsDialog.show(childFragmentManager)
        }

        fun onClickItem(tableItemViewModel: TableItemViewModel, isChatMode: Boolean, isGameMode: Boolean) {
            startActivity<ProfileActivity>(
                    ProfileActivity.TABLE to tableItemViewModel.table,
                    ProfileActivity.CHAT_SELECTION_MODE to isChatMode,
                    ProfileActivity.GAME_SELECTION_MODE to isGameMode
            )
        }
        fun onClickNearbyItem(tableItemViewModel: TableItemViewModel, isChatMode: Boolean) {
            startActivity<NearbyProfileActivity>(
                    NearbyProfileActivity.TABLE to tableItemViewModel.table,
                    NearbyProfileActivity.CHAT_SELECTION_MODE to isChatMode
            )
        }


        fun onClickGameGiftDescription() {
            startActivity<GameGiftDescriptionActivity>()
        }

        fun onClickHashtag() {
            HashtagEditDialog.show(childFragmentManager)
        }

        fun onClickExit() {
            YesNoDialog.show(childFragmentManager, getString(R.string.exit_title), getString(R.string.exit_message))
        }
    }
}