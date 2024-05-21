package com.example.soybeangyan.ui.read.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.soybeangyan.R
import com.example.soybeangyan.ui.read.dataclasses.DiseaseManagementData

class DiseaseManagementAdapter(
    private val itemList: List<DiseaseManagementData>,
    private val clickListener: OnItemClickListener // Use the interface here
) : RecyclerView.Adapter<DiseaseManagementAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.disease_type, parent, false)
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
        private val imageView: ImageView = itemView.findViewById(R.id.logo)

        init {
            itemView.setOnClickListener(this)
        }

        fun bind(dataDisease: DiseaseManagementData) {
            titleTextView.text = dataDisease.title
            imageView.setImageResource(dataDisease.image)
        }

        override fun onClick(v: View?) {
            val position = adapterPosition
            if (position != RecyclerView.NO_POSITION) {
                clickListener.onItemClick(itemList[position])
            }
        }
    }


    interface OnItemClickListener {
        fun onItemClick(item: DiseaseManagementData)
    }
}
