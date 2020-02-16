package edu.jrubiralta.portalbdn.ui.adapter

import android.content.Context
import android.support.v4.content.ContextCompat
import android.view.View
import edu.jrubiralta.portalbdn.R
import edu.jrubiralta.portalbdn.model.PollItemView
import kotlinx.android.synthetic.main.item_poll.view.*

class PollAdapter(val context: Context,
                  val listener: onPollAdapterListener)
    : BaseAdapter<PollItemView>() {

    override val itemLayoutId: Int = R.layout.item_poll

    override fun viewHolder(view: View): BaseViewHolder<PollItemView> = PollItemViewHolder(view)

    inner class PollItemViewHolder(itemView: View) : BaseViewHolder<PollItemView>(itemView) {
        override fun bind(model: PollItemView) {
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