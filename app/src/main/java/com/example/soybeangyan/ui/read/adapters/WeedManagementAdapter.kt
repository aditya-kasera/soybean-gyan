package com.example.soybeangyan.ui.read.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.soybeangyan.ui.read.dataclasses.WeedManagementData

import com.example.soybeangyan.R

class WeedManagementAdapter(private val content: List<WeedManagementData>) :
    RecyclerView.Adapter<WeedManagementAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.weedmanagement_ways, parent, false)
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
