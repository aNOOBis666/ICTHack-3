package com.length.icthack3.presentation.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.length.icthack3.R
import com.length.icthack3.domain.model.User
import org.w3c.dom.Text

class RateAdapter(private var users: List<User>):
    RecyclerView.Adapter<RateAdapter.ScheduleViewHolder>()  {

    class ScheduleViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){


        val userPosition: TextView = itemView.findViewById(R.id.userPosition)
        val userName: TextView = itemView.findViewById(R.id.userName)
        val userPoints: TextView = itemView.findViewById(R.id.userPoints)

    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ScheduleViewHolder {
        val itemView =
            LayoutInflater.from(parent.context)
                .inflate(R.layout.rate_recycler_item, parent, false)
        return ScheduleViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ScheduleViewHolder, position: Int) {
        holder.userPosition.text = users[position].id
        holder.userName.text = users[position].username
        holder.userPoints.text = users[position].balance.toString()
    }

    override fun getItemCount() = users.size

}