package com.example.soybeangyan.ui.read.adapters


import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.soybeangyan.R
import com.example.soybeangyan.ui.read.dataclasses.TableData

class TableAdapter(private val context: Context, private val tableList: List<TableData>?) :
    RecyclerView.Adapter<TableAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view: View = LayoutInflater.from(context).inflate(R.layout.table_layout, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        tableList?.let { tableList ->
            if (tableList.isNotEmpty()) {
                val model: TableData = tableList[position]
                holder.no.text = model.no
                holder.weedcideTv.text = model.weedicide
                holder.cnameTv.text = model.cName
                holder.comNameTv.text = model.comName
                holder.quantityTv.text=model.quantity
            }
        }
    }

    override fun getItemCount(): Int {
        return tableList?.size ?: 0
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val no: TextView = itemView.findViewById(R.id.no_tv)
        val weedcideTv: TextView = itemView.findViewById(R.id.name_weedicide)
        val cnameTv: TextView = itemView.findViewById(R.id.cname_tv)
        val comNameTv: TextView= itemView.findViewById(R.id.comName_tv)
        val quantityTv: TextView = itemView.findViewById(R.id.quantity_tv)

    }
}