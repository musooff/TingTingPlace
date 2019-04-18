package com.ballboycorp.tingting.review.my.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ballboycorp.tingting.R
import com.ballboycorp.tingting.databinding.ItemMyReviewBinding
import com.ballboycorp.tingting.databinding.ItemPochaItemBinding
import com.ballboycorp.tingting.databinding.ItemReviewBinding
import com.ballboycorp.tingting.main.pocha.model.PochaItemViewModel
import com.ballboycorp.tingting.review.model.ReviewItemViewModel
import com.ballboycorp.tingting.review.my.MyReviewsActivity
import com.ballboycorp.tingting.utils.extensions.bind

/**
 * Created by musooff on 18/04/2019.
 */

class MyReviewsAdapter(private val clickHandler: MyReviewsActivity.ClickHandler) :RecyclerView.Adapter<MyReviewsAdapter.MyReviewsViewHolder>() {

    private var mViewModels: List<PochaItemViewModel> = ArrayList()


    override fun getItemCount(): Int {
        return mViewModels.size
    }

    override fun onBindViewHolder(holder: MyReviewsViewHolder, position: Int) {
        holder.binding.viewModel = mViewModels[position]
        holder.binding.clickHandler = clickHandler
    }

    fun submitList(viewModels: List<PochaItemViewModel>) {
        mViewModels = viewModels
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyReviewsViewHolder {
        val binding = parent.bind<ItemMyReviewBinding>(R.layout.item_my_review, viewType)
        return MyReviewsViewHolder(binding)
    }

    inner class MyReviewsViewHolder(val binding: ItemMyReviewBinding): RecyclerView.ViewHolder(binding.root)
}