package com.ballboycorp.tingting.main.pocha.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ballboycorp.tingting.R
import com.ballboycorp.tingting.main.pocha.model.Pocha
import com.ballboycorp.tingting.pocha.details.PochaDetailsActivity
import com.ballboycorp.tingting.utils.extensions.startActivity
import kotlinx.android.synthetic.main.item_pocha_item.view.*

/**
 * Created by musooff on 12/04/2019.
 */

class PochaRecyclerViewAdapter: RecyclerView.Adapter<PochaRecyclerViewAdapter.PochaRecyclerViewHolder>() {

    private var mPochas: List<Pocha> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PochaRecyclerViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_pocha_item, parent, false)
        return PochaRecyclerViewHolder(view)
    }

    override fun getItemCount(): Int {
        return mPochas.size
    }

    override fun onBindViewHolder(holder: PochaRecyclerViewHolder, position: Int) {
        holder.bind(mPochas[position])
    }

    fun submitList(pochas: List<Pocha>) {
        mPochas = pochas
        notifyDataSetChanged()
    }

    inner class PochaRecyclerViewHolder(val view: View): RecyclerView.ViewHolder(view) {
        fun bind(pocha: Pocha) {
            view.text_title.text = pocha.title
            view.text_rating.text = pocha.rating.toString()
            view.rating_bar.rating = pocha.rating
            view.text_review_count.text = "리뷰 ${pocha.reviewCount}"
            view.text_comment_count.text = "사장님 댓글 ${pocha.commentCount}"
            view.text_distance.text = "${pocha.distance}m"

            view.setOnClickListener { view.context.startActivity<PochaDetailsActivity>() }

        }
    }
}