package com.jrubiralta.portalbdn.ui.adapter

import android.view.View
import com.jrubiralta.portalbdn.R
import com.jrubiralta.portalbdn.model.MenuItem
import kotlinx.android.synthetic.main.item_menu.view.*

class DrawerListAdapter(onItemClick: (MenuItem) -> Unit)
    : BaseAdapter<MenuItem>(onItemClickListener = onItemClick) {

    override val itemLayoutId: Int = R.layout.item_menu

    override fun viewHolder(view: View): BaseViewHolder<MenuItem> = MenuItemViewHolder(view)

    class MenuItemViewHolder(itemView: View) : BaseViewHolder<MenuItem>(itemView) {
        override fun bind(model: MenuItem) {
            itemView.apply {
                icon.setImageResource(model.iconId)
                name.setText(model.name)
            }
        }
    }
}