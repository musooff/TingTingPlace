package com.ballboycorp.tingting.pocha.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.ballboycorp.tingting.R
import com.ballboycorp.tingting.base.BaseFragment
import com.ballboycorp.tingting.common.adapter.ImagePagerAdapter
import com.ballboycorp.tingting.common.dialog.YesNoCallback
import com.ballboycorp.tingting.common.dialog.YesNoDialog
import com.ballboycorp.tingting.databinding.FragmentPochaHomeBinding
import com.ballboycorp.tingting.gift.GiftActivity
import com.ballboycorp.tingting.main.home.utils.ItemDecorator
import com.ballboycorp.tingting.my.orders.OrdersActivity
import com.ballboycorp.tingting.pocha.PochaActivity
import com.ballboycorp.tingting.pocha.dialog.room.CreateRoomDialog
import com.ballboycorp.tingting.pocha.dialog.room.model.game.Game
import com.ballboycorp.tingting.pocha.dialog.room.model.bet.Bet
import com.ballboycorp.tingting.pocha.home.adapter.NearbyTableAdapter
import com.ballboycorp.tingting.pocha.home.adapter.TableAdapter
import com.ballboycorp.tingting.pocha.home.description.GameGiftDescriptionActivity
import com.ballboycorp.tingting.pocha.home.dialog.hashtag.HashtagEditDialog
import com.ballboycorp.tingting.pocha.home.dialog.settings.SettingsDialog
import com.ballboycorp.tingting.shop.ShopActivity
import com.ballboycorp.tingting.table.model.Table
import com.ballboycorp.tingting.table.model.TableItemViewModel
import com.ballboycorp.tingting.table.my.MyTableProfileActivity
import com.ballboycorp.tingting.table.nearby.profile.NearbyProfileActivity
import com.ballboycorp.tingting.table.profile.ProfileActivity
import com.ballboycorp.tingting.utils.extensions.*
import kotlinx.android.synthetic.main.fragment_pocha_home.*

/**
 * Created by musooff on 20/04/2019.
 */

class HomeFragment : BaseFragment(),
        YesNoCallback {

    companion object {
        private const val ALERT_EXIT = "alert_exit"
    }

    private lateinit var binding: FragmentPochaHomeBinding

    private val clickHandler = ClickHandler()
    private var tableAdapter = TableAdapter(clickHandler)
    private var nearbyTableAdapter = NearbyTableAdapter(clickHandler)
    private val viewPagerAdapter = ImagePagerAdapter()


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
            if (table.people.size != 0) {
                testPochas.add(TableItemViewModel(table))
            }
        }

        viewPagerAdapter.submitList(arrayListOf("", "", ""))

        tableAdapter.submitList(testPochas)

        rv_table_nearby.adapter = nearbyTableAdapter
        rv_table_nearby.layoutManager = LinearLayoutManager(context)
        rv_table_nearby.addItemDecoration(ItemDecorator.emptyVertical(context!!))

        nearbyTableAdapter.submitList(testPochas)


        vp_pocha_home.adapter = viewPagerAdapter
        tabs_vp_pocha_home.setupWithViewPager(vp_pocha_home)
    }

    fun onNumberOfPeopleSelected(maleCount: Int, femaleCount: Int) {
        val table = Table(
                maleCount = maleCount,
                femaleCount = femaleCount
        )
        table.addTestPeople()
        if (table.people.size != 0) {
            viewModel.myTableItemViewModel = TableItemViewModel(table)
        }
        binding.myTable.itemViewModel = viewModel.myTableItemViewModel

    }

    fun onHashtagChanged() {

    }

    override fun onYes(reason: String) {
        if (reason == ALERT_EXIT) {
            activity?.onBackPressed()
        }
    }

    fun onCreateRoom(game: Game, bet: Bet, isRandomJoin: Boolean) {
        viewModel.isGameCreated = true
    }

    inner class ClickHandler {

        fun onClickSettings() {
            showDialog(::SettingsDialog)
        }

        fun onClickItem(tableItemViewModel: TableItemViewModel, isChatMode: Boolean, isGameMode: Boolean) {
            startActivity<ProfileActivity>(
                    ProfileActivity.TABLE to tableItemViewModel.table,
                    ProfileActivity.CHAT_SELECTION_MODE to isChatMode,
                    ProfileActivity.GAME_SELECTION_MODE to isGameMode
            )
        }

        fun onClickGift(tableItemViewModel: TableItemViewModel) {
            startActivity<GiftActivity>(
                    GiftActivity.TABLE to tableItemViewModel.table
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
            showDialog(::HashtagEditDialog)
        }

        fun onClickExit() {
            showDialogOnActivity(
                    ::YesNoDialog,
                    YesNoDialog.REASON to ALERT_EXIT,
                    YesNoDialog.TITLE to getString(R.string.exit_title),
                    YesNoDialog.TEXT to getString(R.string.exit_message))
        }

        fun onClickMyTable() {
            startActivity<MyTableProfileActivity>(
                    MyTableProfileActivity.TABLE to viewModel.myTableItemViewModel?.table
            )
        }

        fun onClickGame() {
            if (viewModel.isGameCreated) {
                (activity as PochaActivity).moveToPage(1)
            } else {
                showDialog(
                        ::CreateRoomDialog,
                        CreateRoomDialog.RANDOM_ROOM to true
                )
            }
        }

        fun onClickShop() {
            startActivity<ShopActivity>()
        }

        fun onClickOrders() {
            startActivity<OrdersActivity>()
        }
    }
}