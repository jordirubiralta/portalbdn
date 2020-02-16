package edu.jrubiralta.portalbdn.ui.adapter

import android.view.View
import edu.jrubiralta.portalbdn.R
import edu.jrubiralta.portalbdn.model.MenuItemView
import kotlinx.android.synthetic.main.item_menu.view.*

class DrawerListAdapter(onItemClick: (MenuItemView) -> Unit)
    : BaseAdapter<MenuItemView>(onItemClickListener = onItemClick) {

    override val itemLayoutId: Int = R.layout.item_menu

    override fun viewHolder(view: View): BaseViewHolder<MenuItemView> = MenuItemViewHolder(view)

    class MenuItemViewHolder(itemView: View) : BaseViewHolder<MenuItemView>(itemView) {
        override fun bind(model: MenuItemView) {
            itemView.apply {
                icon.setImageResource(model.iconId)
                name.setText(model.name)
            }
        }
    }
}