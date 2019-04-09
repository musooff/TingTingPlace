package com.ballboycorp.tingting.main.home.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.ballboycorp.tingting.R
import kotlinx.android.synthetic.main.item_home_rv.view.*
import kotlin.random.Random

/**
 * Created by musooff on 09/04/2019.
 */

class HomeRecyclerViewAdapter: RecyclerView.Adapter<HomeRecyclerViewAdapter.HomeRecyclerViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeRecyclerViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_home_rv, parent, false)
        return HomeRecyclerViewHolder(view)
    }

    override fun getItemCount(): Int {
        return 5
    }

    override fun onBindViewHolder(holder: HomeRecyclerViewHolder, position: Int) {
        holder.bind()
    }

    inner class HomeRecyclerViewHolder(val view: View): RecyclerView.ViewHolder(view) {
        fun bind() {
            view.tv_date.text = "18.01.01"
            view.tv_name.text = "포차 이름"
            view.rating_bar.rating = Random.nextInt(5).toFloat()

        }
    }

    fun setEmptyView(textView: TextView) {
        textView.visibility = View.GONE
    }
}