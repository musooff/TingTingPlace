package com.ballboycorp.tingting.pocha.dialog.room.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ballboycorp.tingting.R
import com.ballboycorp.tingting.databinding.ItemGameKindBinding
import com.ballboycorp.tingting.pocha.dialog.room.CreateRoomDialog
import com.ballboycorp.tingting.pocha.dialog.room.model.game.GameViewModel
import com.ballboycorp.tingting.utils.extensions.bind

/**
 * Created by musooff on 2019-04-23.
 */

class GameKindAdapter(private val clickHandler: CreateRoomDialog.ClickHandler) : RecyclerView.Adapter<GameKindAdapter.GameKindViewHolder>() {

    private var mViewModels: List<GameViewModel> = ArrayList()


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GameKindViewHolder {
        val binding = parent.bind<ItemGameKindBinding>(R.layout.item_game_kind, viewType)
        return GameKindViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return mViewModels.size
    }

    override fun onBindViewHolder(holder: GameKindViewHolder, position: Int) {
        holder.binding.viewModel = mViewModels[position]
        holder.binding.clickHandler = clickHandler
    }

    fun submitList(viewModels: List<GameViewModel>) {
        mViewModels = viewModels
        notifyDataSetChanged()
    }

    fun onClickItem(viewModel: GameViewModel) {
        mViewModels.forEach { it.isSelected = false }
        mViewModels.first { viewModel.id == it.id }.isSelected = true
    }

    inner class GameKindViewHolder(val binding: ItemGameKindBinding): RecyclerView.ViewHolder(binding.root)
}