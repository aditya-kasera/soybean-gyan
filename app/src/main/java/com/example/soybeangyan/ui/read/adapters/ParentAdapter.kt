package com.example.soybeangyan.ui.read.adapters

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.soybeangyan.R
import com.example.soybeangyan.ui.read.activities.ContentActivity
import com.example.soybeangyan.ui.read.dataclasses.ChildData
import com.example.soybeangyan.ui.read.dataclasses.ParentData

class ParentAdapter(
    private var parentItemList: List<ParentData>,
    val context: Context,
    private val onParentItemClickListener: OnParentItemClickListener
) :
    RecyclerView.Adapter<ParentAdapter.ParentViewHolder>() {

    interface OnParentItemClickListener {
        fun onParentItemClick(parentAdapter: ParentAdapter, parentTitle: String, childPosition: Int, childItem: ChildData)
    }

    inner class ParentViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val parentImageView: ImageView = itemView.findViewById(R.id.parentLogo)
        val parentTitle: TextView = itemView.findViewById(R.id.parentTitleTv)
        val childRecyclerView: RecyclerView = itemView.findViewById(R.id.childRecyclerView)
        val cardView: ConstraintLayout = itemView.findViewById(R.id.constraintLayout)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ParentViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.parent_item, parent, false)
        return ParentViewHolder(view)
    }

    override fun onBindViewHolder(holder: ParentViewHolder,position : Int) {

        val parentItem = parentItemList[position]
        holder.parentTitle.text = parentItem.title
        holder.parentImageView.setImageResource(parentItem.image)

        holder.childRecyclerView.layoutManager = GridLayoutManager(holder.itemView.context, 2)
        holder.childRecyclerView.adapter = ChildAdapter(
            parentItem.childItemList, object : ChildAdapter.OnChildItemClickListener {
                override fun onChildItemClick(childPosition: Int, childItem: ChildData) {
                    onParentItemClickListener.onParentItemClick(
                        this@ParentAdapter,
                        parentItem.title,
                        childPosition,
                        childItem
                    )
                }
            })

        holder.childRecyclerView.visibility =
            if (parentItem.isExpandable) View.VISIBLE else View.GONE

        holder.cardView.setOnClickListener {
            handleItemClick(holder.adapterPosition)
        }
    }

    private fun handleItemClick(position: Int) {
        parentItemList.forEachIndexed { index, parentItem ->
            if (index == position) {
                parentItem.isExpandable = !parentItem.isExpandable
            } else if (parentItem.isExpandable) {
                parentItem.isExpandable = false
            }
        }
        notifyDataSetChanged()
    }

    fun setFilterList(filteredParentList: List<ParentData>) {
        parentItemList = filteredParentList
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int {
        return parentItemList.size
    }

}
