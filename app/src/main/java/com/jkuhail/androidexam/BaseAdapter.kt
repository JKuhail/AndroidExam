package com.jkuhail.androidexam

import android.content.Context
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

abstract class BaseAdapter<T>(
    private val context: Context?,
    private var data: ArrayList<T>
): RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    abstract fun setViewHolder(parent: ViewGroup): RecyclerView.ViewHolder

    abstract fun onBindData(holder: RecyclerView.ViewHolder, value: T, position: Int)
    
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return setViewHolder(parent)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        onBindData(holder, data[position], position)
    }


    override fun getItemCount(): Int {
        return data.size
    }

    fun addItems(items: List<T>){
        data.addAll(items)
        this.notifyDataSetChanged()
    }

    fun updateList(newData: List<T>) {
        data.clear()
        this.data.addAll(newData)
        notifyDataSetChanged()
    }

    fun getItem(position: Int): T{
        return data[position]
    }

}