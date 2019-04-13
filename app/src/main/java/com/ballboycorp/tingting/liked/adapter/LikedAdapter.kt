package com.ballboycorp.tingting.liked.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.RecyclerView
import com.ballboycorp.tingting.R
import com.ballboycorp.tingting.main.pocha.model.Pocha
import com.ballboycorp.tingting.utils.extensions.add
import com.ballboycorp.tingting.utils.extensions.contains
import com.ballboycorp.tingting.utils.extensions.remove
import kotlinx.android.synthetic.main.item_liked.view.*

/**
 * Created by musooff on 13/04/2019.
 */

class LikedAdapter: RecyclerView.Adapter<LikedAdapter.RecentViewHolder>() {

    private var mPochas: List<Pocha> = ArrayList()
    private var mEditMode = false

    var selected: MutableLiveData<ArrayList<Pocha>> = MutableLiveData()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecentViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_liked, parent, false)
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

    fun editMode(value: Boolean) {
        mEditMode = value
        selected.value = null
        notifyDataSetChanged()
    }

    fun deleteSelected() {

    }

    inner class RecentViewHolder(val view: View): RecyclerView.ViewHolder(view) {
        fun bind(pocha: Pocha) {
            view.text_title.text = pocha.title
            view.text_rating.text = pocha.rating.toString()
            view.rating_bar.rating = pocha.rating
            view.text_review_count.text = "리뷰 ${pocha.reviewCount}"
            view.text_comment_count.text = "사장님 댓글 ${pocha.commentCount}"
            view.checkbox.isChecked = selected.contains(pocha)

            if (mEditMode) {
                view.checkbox.visibility = View.VISIBLE
            }
            else {
                view.checkbox.visibility = View.INVISIBLE
            }

            view.setOnClickListener {
                if (mEditMode) {
                    view.checkbox.isChecked = !view.checkbox.isChecked
                    if (selected.contains(pocha)) selected.remove(pocha) else selected.add(pocha)
                }
                else {

                }
            }
        }
    }
}