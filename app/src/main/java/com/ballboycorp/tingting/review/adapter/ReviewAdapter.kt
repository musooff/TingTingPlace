package com.ballboycorp.tingting.review.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ballboycorp.tingting.R
import com.ballboycorp.tingting.databinding.ItemReviewBinding
import com.ballboycorp.tingting.review.model.ReviewItemViewModel
import com.ballboycorp.tingting.utils.extensions.bind

/**
 * Created by musooff on 14/04/2019.
 */

class ReviewAdapter: RecyclerView.Adapter<ReviewAdapter.ReviewViewHolder>() {

    private var mViewModels: List<ReviewItemViewModel> = ArrayList()


    override fun getItemCount(): Int {
        return mViewModels.size
    }

    override fun onBindViewHolder(holder: ReviewViewHolder, position: Int) {
        holder.binding.viewModel = mViewModels[position]
    }

    fun submitList(viewModels: List<ReviewItemViewModel>) {
        mViewModels = viewModels
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ReviewViewHolder {
        val binding = parent.bind<ItemReviewBinding>(R.layout.item_review, viewType)
        return ReviewViewHolder(binding)
    }

    inner class ReviewViewHolder(val binding: ItemReviewBinding): RecyclerView.ViewHolder(binding.root)
}