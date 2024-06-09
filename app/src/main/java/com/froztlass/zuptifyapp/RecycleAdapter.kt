package com.froztlass.zuptifyapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class DailyActivityAdapter(private val dailyActivityList: List<String>) :
    RecyclerView.Adapter<DailyActivityAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val activityTextView: TextView = itemView.findViewById(R.id.activityTextView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_daily_activity, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val activity = dailyActivityList[position]
        holder.activityTextView.text = activity
    }

    override fun getItemCount(): Int {
        return dailyActivityList.size
    }
}
