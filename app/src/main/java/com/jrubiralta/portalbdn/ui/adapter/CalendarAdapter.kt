package com.jrubiralta.portalbdn.ui.adapter

import android.content.Context
import android.view.View
import com.jrubiralta.domain.model.GetEventsResponseModel
import com.jrubiralta.portalbdn.R
import kotlinx.android.synthetic.main.item_calendar.view.*
import kotlinx.android.synthetic.main.item_incident.view.tv_description
import kotlinx.android.synthetic.main.item_incident.view.tv_location
import kotlinx.android.synthetic.main.item_incident.view.tv_title
import java.text.SimpleDateFormat
import java.util.*


class CalendarAdapter(val context: Context)
    : BaseAdapter<GetEventsResponseModel>() {

    override val itemLayoutId: Int = R.layout.item_calendar

    override fun viewHolder(view: View): BaseViewHolder<GetEventsResponseModel> = EventItemViewHolder(view)

    inner class EventItemViewHolder(itemView: View) : BaseViewHolder<GetEventsResponseModel>(itemView) {
        override fun bind(model: GetEventsResponseModel) {
            itemView.apply {
                tv_title.text = model.title
                tv_description.text = model.description
                tv_location.text = model.location
                tv_organizator.text = model.organizator
                tv_event_date.text = getDate(model.date)
            }
        }

        private fun getDate(date: Date?): String {
            val outputPattern = "dd/MM/yyyy HH:mm:ss"
            val outputFormat = SimpleDateFormat(outputPattern)
            return outputFormat.format(date)
        }
    }
}

