package com.jrubiralta.portalbdn.ui.adapter

import android.content.Context
import android.view.View
import androidx.appcompat.content.res.AppCompatResources.getDrawable
import com.jrubiralta.domain.model.Incidencia
import com.jrubiralta.portalbdn.R
import com.jrubiralta.portalbdn.domain.constants.Constants
import kotlinx.android.synthetic.main.item_incident.view.*
import java.text.SimpleDateFormat
import java.util.*

class IncidentAdapter(val context: Context)
    : BaseAdapter<Incidencia>() {

    override val itemLayoutId: Int = R.layout.item_incident

    override fun viewHolder(view: View): BaseViewHolder<Incidencia> = PollItemViewHolder(view)

    inner class PollItemViewHolder(itemView: View) : BaseViewHolder<Incidencia>(itemView) {
        override fun bind(model: Incidencia) {
            itemView.apply {
                tv_title.text = model.titol
                tv_description.text = model.descripcio
                tv_location.text = model.ubicacio
                tv_date.text = getDate(model.data)
                if (model.resolt == true) incident_background.background = getDrawable(context, R.drawable.zz_card_background)
            }
        }

        private fun getDate(date: Date?): String {
            val outputPattern = "dd/MM/yyyy HH:mm:ss"
            val outputFormat = SimpleDateFormat(outputPattern)
            return outputFormat.format(date)
        }
    }
}
