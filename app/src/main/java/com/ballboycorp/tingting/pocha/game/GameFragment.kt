package com.ballboycorp.tingting.pocha.game

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.ballboycorp.tingting.R
import com.ballboycorp.tingting.base.BaseFragment
import com.ballboycorp.tingting.databinding.FragmentGameBinding
import com.ballboycorp.tingting.main.home.utils.ItemDecorator
import com.ballboycorp.tingting.pocha.game.adapter.GameStatusAdapter
import com.ballboycorp.tingting.pocha.game.model.GameStatus
import com.ballboycorp.tingting.pocha.game.model.GameStatusItemViewModel
import com.ballboycorp.tingting.utils.extensions.bind
import com.ballboycorp.tingting.utils.extensions.getViewModel
import kotlinx.android.synthetic.main.fragment_game.*

/**
 * Created by musooff on 20/04/2019.
 */

class GameFragment: BaseFragment() {

    private val clickHandler = ClickHandler()
    private val adapter = GameStatusAdapter(clickHandler)

    private lateinit var binding: FragmentGameBinding

    private val viewModel by lazy { getViewModel<GameViewModel>() }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = bind(inflater, R.layout.fragment_game, container)
        binding.clickHandler = clickHandler
        binding.viewModel = viewModel
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        rv_games.adapter = adapter
        rv_games.layoutManager = LinearLayoutManager(context)
        rv_games.addItemDecoration(ItemDecorator.emptyVertical(context!!))


        val testPochas = ArrayList<GameStatusItemViewModel>()
        for (i in 1..10) {
            val table = GameStatus()
            testPochas.add(GameStatusItemViewModel(table))
        }
        adapter.submitList(testPochas)

        binding.viewMyRoom.viewModel = viewModel.myRoom
        binding.viewLastGameWinner.viewModel = viewModel.lastGameWinner

    }

    inner class ClickHandler {

    }
}