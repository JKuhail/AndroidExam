package com.jkuhail.androidexam

import android.content.Context
import android.view.View
import android.widget.ImageView
import android.widget.TextView

import androidx.recyclerview.widget.RecyclerView

class ItemHolder(context: Context?, itemView: View) : RecyclerView.ViewHolder(itemView) {
    var thumb: ImageView? = itemView.findViewById(R.id.item_image)
    var title: TextView? = itemView.findViewById(R.id.item_title)
    var content: TextView? = itemView.findViewById(R.id.item_about)
}