package com.example.soybeangyan.ui.read.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.soybeangyan.R
import com.example.soybeangyan.ui.read.dataclasses.ChildData


class ChildAdapter(
    private var childList: List<ChildData>,
    private val listener: OnChildItemClickListener
) :
    RecyclerView.Adapter<ChildAdapter.ChildViewHolder>() {

    interface OnChildItemClickListener {
        fun onChildItemClick(childPosition: Int, childItem: ChildData)
    }

    inner class ChildViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageView: ImageView = itemView.findViewById(R.id.childLogo)
        val title: TextView = itemView.findViewById(R.id.childTitle)

        init {
            itemView.setOnClickListener {
                val position = adapterPosition
                if (position != RecyclerView.NO_POSITION) {
                    listener.onChildItemClick(position, childList[position])
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChildViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.child_item, parent, false)
        return ChildViewHolder(view)
    }

    override fun getItemCount(): Int {
        return childList.size
    }

    override fun onBindViewHolder(holder: ChildViewHolder, position: Int) {
        val childItem = childList[position]
        holder.imageView.setImageResource(childItem.image)
        holder.title.text = childItem.title
    }
}