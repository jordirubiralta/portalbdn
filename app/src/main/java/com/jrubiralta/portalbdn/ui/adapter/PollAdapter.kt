package com.jrubiralta.portalbdn.ui.adapter

import android.content.Context
import android.view.View
import androidx.core.content.ContextCompat
import com.jrubiralta.domain.model.GetPollsResponseModel
import com.jrubiralta.portalbdn.R
import kotlinx.android.synthetic.main.item_poll.view.*

class PollAdapter(val context: Context,
                  val listener: onPollAdapterListener)
    : BaseAdapter<GetPollsResponseModel>() {

    override val itemLayoutId: Int = R.layout.item_poll

    override fun viewHolder(view: View): BaseViewHolder<GetPollsResponseModel> = PollItemViewHolder(view)

    inner class PollItemViewHolder(itemView: View) : BaseViewHolder<GetPollsResponseModel>(itemView) {
        override fun bind(model: GetPollsResponseModel) {
            itemView.apply {
                tv_poll_question.text = model.question
                if (model.answer == true) {
                    updateYesAnswer()
                } else if (model.answer == false) {
                    updateNoAnswer()
                }
                like.setOnClickListener {
                    updateYesAnswer()
                    listener.updateYes(model.pollId)
                }
                dislike.setOnClickListener {
                    updateNoAnswer()
                    listener.updateNo(model.pollId)
                }
            }
        }

        private fun updateYesAnswer() {
            itemView.like.setColorFilter(ContextCompat.getColor(context, R.color.green))
            itemView.dislike.setColorFilter(ContextCompat.getColor(context, R.color.darkx_grey))
        }

        private fun updateNoAnswer() {
            itemView.like.setColorFilter(ContextCompat.getColor(context, R.color.darkx_grey))
            itemView.dislike.setColorFilter(ContextCompat.getColor(context, R.color.red))
        }
    }

    interface onPollAdapterListener {
        fun updateYes(pollId: String?)
        fun updateNo(pollId: String?)
    }
}
