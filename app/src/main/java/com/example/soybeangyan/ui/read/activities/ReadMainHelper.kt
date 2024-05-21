//package com.example.soybeangyan.ui.read.activities
//
////import android.view.LayoutInflater
////import android.view.View
////import android.view.ViewGroup
////import androidx.recyclerview.widget.LinearLayoutManager
////import com.example.soybeangyan.R
////import com.example.soybeangyan.R.*
////import com.example.soybeangyan.R.*
////import com.example.soybeangyan.ui.read.activities.ReadMainActivity
////import com.example.soybeangyan.ui.read.adapters.ParentAdapter
////import com.example.soybeangyan.ui.read.dataclasses.ChildData
////import com.example.soybeangyan.ui.read.dataclasses.ParentData
////
////class ReadMainHelper {
////    companion object {
////        fun setupReadMainScreen(layoutInflater: LayoutInflater, container: ViewGroup): View {
////            val readMainActivityView = layoutInflater.inflate(layout.activity_read_main, container, false)
//////
////            supportActionBar?.hide()
////
////            parentRecyclerView = findViewById(R.id.parentRecyclerView)
////            parentRecyclerView.setHasFixedSize(true)
////            parentRecyclerView.layoutManager = LinearLayoutManager(this)
////            parentList = java.util.ArrayList()
////            prepareData()
////
////            val adapter = ParentAdapter(parentList)
////            parentRecyclerView.adapter = adapter
////        }
//
//
//import android.view.LayoutInflater
//import android.view.View
//import android.view.ViewGroup
//import androidx.recyclerview.widget.LinearLayoutManager
//import androidx.recyclerview.widget.RecyclerView
//import com.example.soybeangyan.R
//import com.example.soybeangyan.ui.read.adapters.ParentAdapter
//import com.example.soybeangyan.ui.read.dataclasses.ChildData
//import com.example.soybeangyan.ui.read.dataclasses.ParentData
//
//object ReadMainHelper {
//
//    fun setupReadMainScreen(layoutInflater: LayoutInflater, container: ViewGroup): View {
//        val readMainActivityView = layoutInflater.inflate(R.layout.activity_read_main, container, false)
//
//        val parentRecyclerView: RecyclerView = readMainActivityView.findViewById(R.id.parentRecyclerView)
//        parentRecyclerView.setHasFixedSize(true)
//        parentRecyclerView.layoutManager = LinearLayoutManager(container.context)
//
//        val parentList: ArrayList<ParentData> = ArrayList()
//        prepareData(parentList)
//
//
//        val adapter = ParentAdapter(parentList)
//        parentRecyclerView.adapter = adapter
//
//        return readMainActivityView
//    }
//
//
//    private fun prepareData(parentList: ArrayList<ParentData>) {
//            val childItems1 = ArrayList<ChildData>()
//
////            val parentData1 = ParentData("Parent 1", R.R.drawable.ganesh1)
////            parentList.add(parentData1)
//        childItems1.add(ChildData("Soil Requirement", R.drawable.ganesh1))
//        childItems1.add(ChildData("Tillage", R.drawable.ganesh1))
//        childItems1.add(ChildData("Selection of Varieties", R.drawable.ganesh1))
//        childItems1.add(ChildData("Suggetions (Selection of Varieties)", R.drawable.ganesh2))
//        childItems1.add(ChildData("Seed Treatment & Inoculation", R.drawable.ganesh1))
//        childItems1.add(ChildData("Sowing Time, Spacing & Seed Rate", R.drawable.ganesh1))
//        childItems1.add(ChildData("Manures & Fertilizers", R.drawable.ganesh1))
//        childItems1.add(ChildData("Intercropping in Soybean", R.drawable.ganesh1))
//        childItems1.add(ChildData("Water Management", R.drawable.ganesh1))
//        childItems1.add(ChildData("Harvesting & Threshing", R.drawable.ganesh1))
//        parentList.add(ParentData("Crop\nManagement", R.drawable.ganesh1, childItems1))
//
//        val childItems2 = ArrayList<ChildData>()
//        childItems2.add(ChildData("Blue Beetle", R.drawable.ganesh1))
//        childItems2.add(ChildData("Bihar Hairy Caterpillar", R.drawable.ganesh1))
//        childItems2.add(ChildData("Girdle Beetle", R.drawable.ganesh1))
//        childItems2.add(ChildData("Gram Pod Borer", R.drawable.ganesh1))
//        childItems2.add(ChildData("Green Semiloopers", R.drawable.ganesh1))
//        childItems2.add(ChildData("Green Stink Bug", R.drawable.ganesh1))
//        childItems2.add(ChildData("Leaf Folder", R.drawable.ganesh1))
//        childItems2.add(ChildData("Leaf Miner", R.drawable.ganesh1))
//        childItems2.add(ChildData("Stem Fly", R.drawable.ganesh1))
//        childItems2.add(ChildData("Tobacco Caterpillar", R.drawable.ganesh1))
//        childItems2.add(ChildData("White Fly", R.drawable.ganesh1))
//        childItems2.add(ChildData("White Grub", R.drawable.ganesh1))
//        childItems2.add(ChildData("Brown Stripped Semilooper", R.drawable.ganesh1))
//        parentList.add(ParentData("Insect\nManagement", R.drawable.ganesh1, childItems2))
//
//        val childItems3 = ArrayList<ChildData>()
//        childItems3.add(ChildData("Bacterial Diseases", R.drawable.ganesh1))
//        childItems3.add(ChildData("Fungal Diseases", R.drawable.ganesh1))
//        childItems3.add(ChildData("Viral Diseases", R.drawable.ganesh1))
//        parentList.add(ParentData("Disease\nManagement", R.drawable.ganesh1, childItems3))
//
//        val childItems4 = ArrayList<ChildData>()
//        childItems4.add(ChildData("Losses Due to Weed", R.drawable.ganesh1))
//        childItems4.add(ChildData("Types of Weed", R.drawable.ganesh1))
//        childItems4.add(ChildData("Weed Management Practices", R.drawable.ganesh1))
//        childItems4.add(ChildData("Recommended Herbicides", R.drawable.ganesh1))
//        childItems4.add(ChildData("General Precautions", R.drawable.ganesh1))
//        parentList.add(ParentData("Weed\nManagement", R.drawable.ganesh1, childItems4))
//
//        val childItems5 = ArrayList<ChildData>()
//        childItems5.add(ChildData("Soy Nuts", R.drawable.ganesh1))
//        childItems5.add(ChildData("Soy Milk", R.drawable.ganesh1))
//        childItems5.add(ChildData("Soy Curd", R.drawable.ganesh1))
//        childItems5.add(ChildData("Tofu", R.drawable.ganesh1))
//        childItems5.add(ChildData("Soy Flour", R.drawable.ganesh1))
//        childItems5.add(ChildData("Soy Chakli", R.drawable.ganesh1))
//        childItems5.add(ChildData("Soy Mathari", R.drawable.ganesh1))
//        childItems5.add(ChildData("Soy Laddo", R.drawable.ganesh1))
//        childItems5.add(ChildData("Soy Nankhatai", R.drawable.ganesh1))
//        childItems5.add(ChildData("Soy Upma", R.drawable.ganesh1))
//        childItems5.add(ChildData("Soy Halwa", R.drawable.ganesh1))
//        childItems5.add(ChildData("Soy Pakora", R.drawable.ganesh1))
//        parentList.add(ParentData("Soyfood\nRecipe", R.drawable.ganesh1,childItems5))
//
//        val childItems6 = ArrayList<ChildData>()
//        childItems6.add(ChildData("Broad Bed Furrow", R.drawable.ganesh1))
//        childItems6.add(ChildData("Furrow Irrigated Raised Bed System", R.drawable.ganesh1))
//        childItems6.add(ChildData("Subsoiler", R.drawable.ganesh1))
//        childItems6.add(ChildData("Sweep Seed Drill", R.drawable.ganesh1))
//        childItems6.add(ChildData("Ridge Fertilizer Drill Cum Seed Planter", R.drawable.ganesh1))
//        childItems6.add(ChildData("Single Ridge Seed Planter", R.drawable.ganesh1))
//        childItems6.add(ChildData("Soybean Seed Drill Cum Planter", R.drawable.ganesh1))
//        parentList.add(ParentData("Farm\nMachinery", R.drawable.ganesh1,childItems6))
//
//        val childItems7 = ArrayList<ChildData>()
//        childItems7.add(ChildData("Recommended Sowing Time", R.drawable.ganesh1))
//        childItems7.add(ChildData("Seed Rate & Spacing", R.drawable.ganesh1))
//        childItems7.add(ChildData("Recommended Soybean Varieties", R.drawable.ganesh1))
//        parentList.add(ParentData("Important\nInformation", R.drawable.ganesh1,childItems7))
//
//    }
//}
//
//
