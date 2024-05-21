package com.example.soybeangyan.ui.read.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.soybeangyan.R
import com.example.soybeangyan.ui.read.dataclasses.CropManagementData

class CropManagementAdapter(private val content: List<CropManagementData>) :
    RecyclerView.Adapter<CropManagementAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.cropmanagement_ways, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = content[position]
        holder.textViewContent.text = item.content
    }

    override fun getItemCount(): Int = content.size

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val textViewContent: TextView = view.findViewById(R.id.content)
    }
}
