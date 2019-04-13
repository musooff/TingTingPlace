package com.ballboycorp.tingting.recent.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ballboycorp.tingting.R
import com.ballboycorp.tingting.main.pocha.model.Pocha
import com.ballboycorp.tingting.pocha.details.PochaDetailsActivity
import com.ballboycorp.tingting.utils.extensions.startActivity
import kotlinx.android.synthetic.main.item_recent.view.*

/**
 * Created by musooff on 13/04/2019.
 */

class RecentAdapter: RecyclerView.Adapter<RecentAdapter.RecentViewHolder>() {

    private var mPochas: List<Pocha> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecentViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_recent, parent, false)
        return RecentViewHolder(view)
    }

    override fun getItemCount(): Int {
        return mPochas.size
    }

    override fun onBindViewHolder(holder: RecentViewHolder, position: Int) {
        holder.bind(mPochas[position])
    }

    fun submitList(pochas: List<Pocha>) {
        mPochas = pochas
        notifyDataSetChanged()
    }

    inner class RecentViewHolder(val view: View): RecyclerView.ViewHolder(view) {
        fun bind(pocha: Pocha) {
            view.text_title.text = pocha.title
            view.text_rating.text = pocha.rating.toString()
            view.rating_bar.rating = pocha.rating
            view.text_review_count.text = "리뷰 ${pocha.reviewCount}"
            view.text_comment_count.text = "사장님 댓글 ${pocha.commentCount}"

            view.setOnClickListener { view.context.startActivity<PochaDetailsActivity>() }
        }
    }
}