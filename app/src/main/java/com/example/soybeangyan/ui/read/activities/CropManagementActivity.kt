package com.example.soybeangyan.ui.read.activities

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.soybeangyan.R
import com.example.soybeangyan.ui.read.adapters.CropManagementAdapter
import com.example.soybeangyan.ui.read.dataclasses.CropManagementData

class CropManagementActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var content: ArrayList<CropManagementData>
    private lateinit var adapter: CropManagementAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
//        setTheme(R.style.Theme_SoybeanGyan)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_crop_management)
        val childTitle = intent.getStringExtra("childTitle")
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = childTitle

        recyclerView = findViewById(R.id.reCyclerView)
        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = LinearLayoutManager(this)

        content = ArrayList()

        adapter = CropManagementAdapter(content)
        recyclerView.adapter = adapter

        prepareData()
    }

    private fun prepareData() {
        val childTitle = intent.getStringExtra("childTitle")
        when(childTitle ){
            "Soil Requirement"-> {
                content.add(CropManagementData(getString(R.string.SoilRequirement)))
                adapter.notifyDataSetChanged()
            }
            "Tillage"->{
                content.add(CropManagementData(getString(R.string.Tillage1)))
                content.add(CropManagementData(getString(R.string.Tillage2)))
                content.add(CropManagementData(getString(R.string.Tillage3)))
                content.add(CropManagementData(getString(R.string.Tillage4)))
                content.add(CropManagementData(getString(R.string.Tillage5)))
                content.add(CropManagementData(getString(R.string.Tillage6)))
                content.add(CropManagementData(getString(R.string.Tillage7)))
                content.add(CropManagementData(getString(R.string.Tillage8)))
                content.add(CropManagementData(getString(R.string.Tillage9)))
                adapter.notifyDataSetChanged()
            }
            "Selection of Varieties"->{
                content.add(CropManagementData(getString(R.string.selection1)))
                content.add(CropManagementData(getString(R.string.selection2)))
                content.add(CropManagementData(getString(R.string.selection3)))
                content.add(CropManagementData(getString(R.string.selection4)))
                content.add(CropManagementData(getString(R.string.selection5)))
                content.add(CropManagementData(getString(R.string.selection6)))
                adapter.notifyDataSetChanged()
            }
            "Seed Treatment & Inoculation"->{
                content.add(CropManagementData(getString(R.string.inoculation1)))
                content.add(CropManagementData(getString(R.string.inoculation2)))
                content.add(CropManagementData(getString(R.string.inoculation3)))
                content.add(CropManagementData(getString(R.string.inoculation4)))
                content.add(CropManagementData(getString(R.string.inoculation5)))
                content.add(CropManagementData(getString(R.string.inoculation6)))
                content.add(CropManagementData(getString(R.string.inoculation7)))
            }

            "Sowing Time, Spacing & Seed Rate"->{
                content.add(CropManagementData(getString(R.string.sowing1)))
                content.add(CropManagementData(getString(R.string.sowing2)))
                content.add(CropManagementData(getString(R.string.sowing3)))
                content.add(CropManagementData(getString(R.string.sowing4)))
                content.add(CropManagementData(getString(R.string.sowing5)))
                content.add(CropManagementData(getString(R.string.sowing6)))
            }
            "Manures & Fertilizers"->{
                content.add(CropManagementData(getString(R.string.fertilizer1)))
                content.add(CropManagementData(getString(R.string.fertilizer2)))
                content.add(CropManagementData(getString(R.string.fertilizer3)))
            }
            "Intercropping in Soybean"->{
                content.add(CropManagementData(getString(R.string.intercropping1)))
                content.add(CropManagementData(getString(R.string.intercropping2)))
                content.add(CropManagementData(getString(R.string.intercropping3)))
            }
            "Water Management"->{
                content.add(CropManagementData(getString(R.string.water1)))
                content.add(CropManagementData(getString(R.string.water2)))
            }
            "Harvesting & Threshing"->{
                content.add(CropManagementData(getString(R.string.harvesting1)))
                content.add(CropManagementData(getString(R.string.harvesting2)))
                content.add(CropManagementData(getString(R.string.harvesting3)))
                content.add(CropManagementData(getString(R.string.harvesting4)))
                content.add(CropManagementData(getString(R.string.harvesting5)))
                content.add(CropManagementData(getString(R.string.harvesting6)))
            }
        }
    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            android.R.id.home -> {
                @Suppress("DEPRECATION")
                onBackPressed()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}
