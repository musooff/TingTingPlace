package com.ballboycorp.tingting.pocha.game.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ballboycorp.tingting.R
import com.ballboycorp.tingting.databinding.ItemGameStatusBinding
import com.ballboycorp.tingting.pocha.dialog.room.model.game.GameItemViewModel
import com.ballboycorp.tingting.pocha.dialog.room.model.bet.BetItemViewModel
import com.ballboycorp.tingting.pocha.game.GameFragment
import com.ballboycorp.tingting.pocha.game.model.GameStatusItemViewModel
import com.ballboycorp.tingting.table.model.TableItemViewModel
import com.ballboycorp.tingting.utils.extensions.bind

/**
 * Created by musooff on 2019-04-27.
 */

class GameStatusAdapter(private val clickHandler: GameFragment.ClickHandler) : RecyclerView.Adapter<GameStatusAdapter.GameStatusViewHolder>() {

    private var mViewModel = mutableListOf<GameStatusItemViewModel>()


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GameStatusViewHolder {
        val binding = parent.bind<ItemGameStatusBinding>(R.layout.item_game_status, viewType)
        return GameStatusViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return mViewModel.size
    }

    override fun onBindViewHolder(holder: GameStatusViewHolder, position: Int) {
        holder.binding.viewModel = mViewModel[position]

    }


    fun submitList(viewModels: List<GameStatusItemViewModel>) {
        mViewModel = viewModels.toMutableList()
        notifyDataSetChanged()

    }

    inner class GameStatusViewHolder(val binding: ItemGameStatusBinding): RecyclerView.ViewHolder(binding.root)
}