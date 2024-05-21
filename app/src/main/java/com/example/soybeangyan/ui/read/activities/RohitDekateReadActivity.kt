package com.example.soybeangyan.ui.read.activities

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.soybeangyan.R
import com.example.soybeangyan.ui.read.adapters.ParentAdapter
import com.example.soybeangyan.ui.read.dataclasses.ChildData
import com.example.soybeangyan.ui.read.dataclasses.ParentData

class RohitDekateReadActivity : AppCompatActivity(), ParentAdapter.OnParentItemClickListener {

    private lateinit var parentRecyclerView: RecyclerView
    private lateinit var parentList: ArrayList<ParentData>
    private lateinit var searchview: SearchView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        enableEdgeToEdge()
        setContentView(R.layout.activity_rohit_dekate_read)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        supportActionBar?.hide()

        parentRecyclerView = findViewById(R.id.parentRecyclerView)
        searchview = findViewById(R.id.searchView)
        searchview.requestFocus()
        searchview.clearFocus()
        searchview.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String): Boolean {
                filterList(newText)
                return true
            }
        })

        parentRecyclerView.setHasFixedSize(true)
        parentRecyclerView.layoutManager = LinearLayoutManager(this)
        parentList = ArrayList()
        prepareData()

        val adapter = ParentAdapter(parentList, this, this)
        parentRecyclerView.adapter = adapter
    }

    private fun filterList(newText: String) {
        val trimmedText = newText.trim()
        val filteredParentList = ArrayList<ParentData>()

        val originalParentList = ArrayList(parentList)

        for (parent in originalParentList) {
            val filteredChildren = ArrayList<ChildData>()
            for (child in parent.childItemList) {
                if (child.getChildName().lowercase().contains(trimmedText.lowercase())) {
                    filteredChildren.add(child)
                }
            }

            val isParentExpanded = filteredChildren.isNotEmpty()
            if (filteredChildren.isNotEmpty()) {
                filteredParentList.add(
                    ParentData(
                        parent.getParentName(),
                        parent.image,
                        filteredChildren,
                        isExpandable = isParentExpanded
                    )
                )
            }
        }
        filteredParentList.sortByDescending { it.isExpandable }

        if (filteredParentList.isEmpty())
            Toast.makeText(this, "No data Found", Toast.LENGTH_SHORT).show()
        else
            (parentRecyclerView.adapter as ParentAdapter).setFilterList(filteredParentList)
    }

    override fun onParentItemClick(
        parentAdapter: ParentAdapter,
        parentTitle: String,
        childPosition: Int,
        childItem: ChildData
    ) {
        val intent = Intent(parentAdapter.context, ContentActivity::class.java)

        intent.putExtra("parentName", parentTitle)
        intent.putExtra("childPosition", childPosition)
        intent.putExtra("childItem", childItem)

        parentAdapter.context.startActivity(intent)

    }


    private fun prepareData() {
        val childItems1 = ArrayList<ChildData>()
        childItems1.add(ChildData("Soil Requirement", R.drawable.soilrequirement))
        childItems1.add(ChildData("Tillage", R.drawable.tillage
        ))
        childItems1.add(ChildData("Selection of Varieties", R.drawable.vaarieties))
        childItems1.add(ChildData("Suggestions (Selection of Varieties)", R.drawable.suggestions))
        childItems1.add(ChildData("Seed Treatment & Inoculation", R.drawable.seedtreatement))
        childItems1.add(ChildData("Sowing Time, Spacing & Seed Rate", R.drawable.time))
        childItems1.add(ChildData("Manures & Fertilizers", R.drawable.fertilizers))
        childItems1.add(ChildData("Intercropping in Soybean", R.drawable.intercropping))
        childItems1.add(ChildData("Water Management",R.drawable.watermanagement))
        childItems1.add(ChildData("Harvesting & Threshing",R.drawable.harvesting))
        parentList.add(ParentData("Crop\nManagement", R.drawable.cropmanage, childItems1))

        val childItems2 = ArrayList<ChildData>()
        childItems2.add(ChildData("Blue Beetle", R.drawable.blue_beetle))
        childItems2.add(ChildData("Bihar Hairy Caterpillar", R.drawable.biharhairyketerpiller_adlt1))
        childItems2.add(ChildData("Girdle Beetle", R.drawable.gb_adult17))
        childItems2.add(ChildData("Gram Pod Borer", R.drawable.grampodborrerheliolarvae1))
        childItems2.add(ChildData("Green Semiloopers", R.drawable.semilooper_calarva1))
        childItems2.add(ChildData("Green Stink Bug", R.drawable.greenstingbugadlt2))
        childItems2.add(ChildData("Leaf Folder", R.drawable.if_adult))
        childItems2.add(ChildData("Leaf Miner", R.drawable.leafminorlarva1))
        childItems2.add(ChildData("Stem Fly", R.drawable.stemfly_adult2))
        childItems2.add(ChildData("Tobacco Caterpillar", R.drawable.tobaccoketerpilleradlt2))
        childItems2.add(ChildData("White Fly", R.drawable.whiteflyadlts1))
        childItems2.add(ChildData("White Grub", R.drawable.white_grub16))
        childItems2.add(ChildData("Brown Stripped Semilooper", R.drawable.semilooper7))
        parentList.add(ParentData("Insect\nManagement", R.drawable.pest_management_concept, childItems2))

        val childItems3 = ArrayList<ChildData>()
        childItems3.add(ChildData("Bacterial Diseases", R.drawable.bacteria))
        childItems3.add(ChildData("Fungal Diseases", R.drawable.fungi))
        childItems3.add(ChildData("Viral Diseases", R.drawable.virus_fellodi))
        parentList.add(ParentData("Disease\nManagement", R.drawable.brown_spot_disease, childItems3))

        val childItems4 = ArrayList<ChildData>()
        childItems4.add(ChildData("Losses Due to Weed", R.drawable.lossduetoweed))
        childItems4.add(ChildData("Types of Weed", R.drawable.typesofweed))
        childItems4.add(ChildData("Weed Management Practices", R.drawable.weedmgmt))
        childItems4.add(ChildData("Recommended Herbicides", R.drawable.herbicides))
        childItems4.add(ChildData("General Precautions", R.drawable.precaution_exclamation))
        parentList.add(ParentData("Weed\nManagement", R.drawable.weed_img, childItems4))

        val childItems5 = ArrayList<ChildData>()
        childItems5.add(ChildData("Soy Nuts", R.drawable.soynuts))
        childItems5.add(ChildData("Soy Milk", R.drawable.soya_dudh))
        childItems5.add(ChildData("Soy Curd", R.drawable.dahi))
        childItems5.add(ChildData("Tofu", R.drawable.tofu))
        childItems5.add(ChildData("Soy Flour", R.drawable.soya_flour))
        childItems5.add(ChildData("Soy Chakli", R.drawable.chakli))
        childItems5.add(ChildData("Soy Mathari", R.drawable.mathari))
        childItems5.add(ChildData("Soy Laddo", R.drawable.ladoo))
        childItems5.add(ChildData("Soy Nankhatai", R.drawable.nankhattai))
        childItems5.add(ChildData("Soy Upma", R.drawable.upma))
        childItems5.add(ChildData("Soy Halwa", R.drawable.halwa))
        childItems5.add(ChildData("Soy Pakora", R.drawable.onion))
        parentList.add(ParentData("Soyfood\nRecipe", R.drawable.soy_products, childItems5))

        val childItems6 = ArrayList<ChildData>()
        childItems6.add(ChildData("Broad Bed Furrow", R.drawable.bbf))
        childItems6.add(ChildData("Furrow Irrigated Raised Bed System", R.drawable.firbs))
        childItems6.add(ChildData("Subsoiler", R.drawable.subsoiler_machine))
        childItems6.add(ChildData("Sweep Seed Drill", R.drawable.sweep_seed_drill_machine))
        childItems6.add(ChildData("Ridge Fertilizer Drill Cum Seed Planter", R.drawable.rfdcsp))
        childItems6.add(ChildData("Single Ridge Seed Planter", R.drawable.single_ridge_seed_planter))
        childItems6.add(ChildData("Soybean Seed Drill Cum Planter", R.drawable.soybean_seed_drill_cum_planter))
        parentList.add(ParentData("Farm\nMachinery", R.drawable.farm_machine, childItems6))

        val childItems7 = ArrayList<ChildData>()
        childItems7.add(ChildData("Recommended Sowing Time", R.drawable.recommendedsowingtime))
        childItems7.add(ChildData("Seed Rate & Spacing", R.drawable.sowingtime))
        childItems7.add(ChildData("Recommended Soybean Varieties", R.drawable.soybeanvarietieties))
        parentList.add(ParentData("Important\nInformation", R.drawable.imp_info, childItems7))
    }
}