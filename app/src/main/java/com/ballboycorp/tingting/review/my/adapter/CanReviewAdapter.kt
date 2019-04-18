package com.ballboycorp.tingting.review.my.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ballboycorp.tingting.R
import com.ballboycorp.tingting.databinding.ItemCanReviewBinding
import com.ballboycorp.tingting.main.pocha.model.PochaItemViewModel
import com.ballboycorp.tingting.review.my.MyReviewsActivity
import com.ballboycorp.tingting.utils.extensions.bind

/**
 * Created by musooff on 18/04/2019.
 */

class CanReviewAdapter(private val clickHandler: MyReviewsActivity.ClickHandler): RecyclerView.Adapter<CanReviewAdapter.CanReviewViewHolder>() {

    private var mViewModels: List<PochaItemViewModel> = ArrayList()


    override fun getItemCount(): Int {
        return mViewModels.size
    }

    override fun onBindViewHolder(holder: CanReviewViewHolder, position: Int) {
        holder.binding.viewModel = mViewModels[position]
        holder.binding.clickHandler = clickHandler
    }

    fun submitList(viewModels: List<PochaItemViewModel>) {
        mViewModels = viewModels
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CanReviewViewHolder {
        val binding = parent.bind<ItemCanReviewBinding>(R.layout.item_can_review, viewType)
        return CanReviewViewHolder(binding)
    }

    inner class CanReviewViewHolder(val binding: ItemCanReviewBinding): RecyclerView.ViewHolder(binding.root)
}