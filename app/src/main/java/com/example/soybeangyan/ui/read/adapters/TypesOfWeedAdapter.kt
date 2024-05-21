package com.example.soybeangyan.ui.read.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.soybeangyan.R
import com.example.soybeangyan.ui.read.dataclasses.TypesOfWeedData

class TypesOfWeedAdapter(
    private val itemList: List<TypesOfWeedData> // Assuming WeedData is a data class containing title and image properties
) : RecyclerView.Adapter<TypesOfWeedAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.weedimages, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = itemList[position]
        holder.bind(item)
    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val titleTextView: TextView = itemView.findViewById(R.id.title)
        private val imageView: ImageView = itemView.findViewById(R.id.logo)

        fun bind(weedData: TypesOfWeedData) {
            titleTextView.text = weedData.title
            imageView.setImageResource(weedData.image)
        }
    }
}
