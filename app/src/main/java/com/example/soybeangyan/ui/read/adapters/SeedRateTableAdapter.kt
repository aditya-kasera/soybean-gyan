package com.example.soybeangyan.ui.read.adapters


import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.soybeangyan.R
import com.example.soybeangyan.ui.read.dataclasses.SeedRateTableData

class SeedRateTableAdapter(private val context: Context, private val tableList: List<SeedRateTableData>?) :
    RecyclerView.Adapter<SeedRateTableAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view: View = LayoutInflater.from(context).inflate(R.layout.table_seedrate, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        tableList?.let { tableList ->
            if (tableList.isNotEmpty()) {
                val model: SeedRateTableData = tableList[position]
                holder.zone.text = model.zone
                holder.seedrate.text = model.seedrate
                holder.spacing.text = model.spacing
            }
        }
    }

    override fun getItemCount(): Int {
        return tableList?.size ?: 0
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val zone: TextView = itemView.findViewById(R.id.zone)
        val seedrate: TextView = itemView.findViewById(R.id.seedrate)
        val spacing: TextView= itemView.findViewById(R.id.spacing)
    }
}