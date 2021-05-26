package com.jkuhail.androidexam.adapters

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.github.islamkhsh.CardSliderAdapter
import com.jkuhail.androidexam.R
import com.jkuhail.androidexam.models.Item

class MainAdapter(
    private val mContext: Context,
    private val mItems: List<Item>,
    private var listener: EventListener
) : CardSliderAdapter<RecyclerView.ViewHolder>() {
    override fun getItemCount(): Int {
        return mItems.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_main_card, parent, false)
        return MovieViewHolder(view)
    }

    @SuppressLint("ClickableViewAccessibility")
    override fun bindVH(holder: RecyclerView.ViewHolder, position: Int) {
        val img = holder.itemView.findViewById<ImageView>(R.id.item_image)
        val title = holder.itemView.findViewById<TextView>(R.id.item_title)
        val description = holder.itemView.findViewById<TextView>(R.id.item_about)
        Glide.with(mContext)
            .load(mItems[position].thumb)
            .into(img)
        description.text = mItems[position].content
        title.text = mItems[position].title
        holder.itemView.setOnTouchListener { v: View?, event: MotionEvent? ->
            listener.onSlide()
            false
        }
    }

    class MovieViewHolder(view: View?) : RecyclerView.ViewHolder(view!!)
    interface EventListener {
        fun onSlide()
    }

}