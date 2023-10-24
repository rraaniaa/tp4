package com.example.tp4

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MyViewHolder (val itemview: View):
    RecyclerView.ViewHolder(itemview){
    val vText = itemView.findViewById(R.id.word) as TextView
}