package com.example.soybeangyan.ui.read.adapters


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.soybeangyan.R
import com.example.soybeangyan.ui.read.activities.PDFActivity
import com.example.soybeangyan.ui.read.dataclasses.PDFData

class PDFAdapter(
    private val itemList: List<PDFData>,
    private val clickListener: PDFActivity
) : RecyclerView.Adapter<PDFAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_pdf, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = itemList[position]
        holder.bind(item)
    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView), View.OnClickListener {
        private val titleTextView: TextView = itemView.findViewById(R.id.title)
        init {
            itemView.setOnClickListener(this)
        }

        fun bind(dataPDF: PDFData) {
            titleTextView.text = dataPDF.title
        }

        override fun onClick(v: View?) {
            val position = adapterPosition
            if (position != RecyclerView.NO_POSITION) {
                clickListener.onItemClick(itemList[position])
            }
        }
    }

}