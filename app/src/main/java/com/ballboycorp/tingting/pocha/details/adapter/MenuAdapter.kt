package com.ballboycorp.tingting.pocha.details.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ballboycorp.tingting.R
import com.ballboycorp.tingting.pocha.details.model.Menu
import kotlinx.android.synthetic.main.item_pocha_menu.view.*

/**
 * Created by musooff on 13/04/2019.
 */

class MenuAdapter: RecyclerView.Adapter<MenuAdapter.MenuViewHolder>() {

    private var mMenus: List<Menu> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MenuViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_pocha_menu, parent, false)
        return MenuViewHolder(view)
    }

    override fun getItemCount(): Int {
        return mMenus.size
    }

    fun submitList(menus: List<Menu>) {
        mMenus = menus
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: MenuViewHolder, position: Int) {
        holder.bind(mMenus[position])
    }

    inner class MenuViewHolder(val view: View): RecyclerView.ViewHolder(view) {
        fun bind(menu: Menu) {
            view.text_title.text = menu.title
            view.text_price.text = menu.price
        }
    }
}