package com.jrubiralta.portalbdn.ui.adapter

import android.content.Context
import android.view.View
import androidx.core.content.ContextCompat
import com.jrubiralta.portalbdn.R
import com.jrubiralta.portalbdn.model.PollItem
import kotlinx.android.synthetic.main.item_poll.view.*

class PollAdapter(val context: Context,
                  val listener: onPollAdapterListener)
    : BaseAdapter<PollItem>() {

    override val itemLayoutId: Int = R.layout.item_poll

    override fun viewHolder(view: View): BaseViewHolder<PollItem> = PollItemViewHolder(view)

    inner class PollItemViewHolder(itemView: View) : BaseViewHolder<PollItem>(itemView) {
        override fun bind(model: PollItem) {
            itemView.apply {
                tv_poll_question.text = model.title
                like.setOnClickListener {
                    updateYesAnswer()
                }
                dislike.setOnClickListener {
                    updateNoAnswer()
                }
            }
        }

        private fun updateYesAnswer() {
            itemView.like.setColorFilter(ContextCompat.getColor(context, R.color.green))
        }

        private fun updateNoAnswer() {
            itemView.dislike.setColorFilter(ContextCompat.getColor(context, R.color.red))
        }
    }

    interface onPollAdapterListener {
        fun updateYes()
        fun updateNo()
    }
}
