package com.example.soybeangyan.ui.read.adapters


import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.soybeangyan.R
import com.example.soybeangyan.ui.read.dataclasses.SoybeanVarietiesTableData

class SoybeanVarietiesTableAdapter(private val context: Context, private val tableList: List<SoybeanVarietiesTableData>?) :
    RecyclerView.Adapter<SoybeanVarietiesTableAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view: View = LayoutInflater.from(context).inflate(R.layout.table_soybeabvarieties, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        tableList?.let { tableList ->
            if (tableList.isNotEmpty()) {
                val model: SoybeanVarietiesTableData = tableList[position]
                holder.sno.text = model.sno
                holder.zone.text = model.zone
                holder.state.text = model.state
                holder.varieties.text=model.varieties
            }
        }
    }

    override fun getItemCount(): Int {
        return tableList?.size ?: 0
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val sno: TextView = itemView.findViewById(R.id.sno)
        val zone: TextView = itemView.findViewById(R.id.zone)
        val state: TextView= itemView.findViewById(R.id.state)
        var varieties:TextView=itemView.findViewById(R.id.varieties)
    }
}