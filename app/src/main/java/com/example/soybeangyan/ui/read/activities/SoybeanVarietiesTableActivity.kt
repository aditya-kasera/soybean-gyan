package com.example.soybeangyan.ui.read.activities

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.soybeangyan.R
import com.example.soybeangyan.ui.read.adapters.SoybeanVarietiesTableAdapter
import com.example.soybeangyan.ui.read.dataclasses.SoybeanVarietiesTableData

class SoybeanVarietiesTableActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: SoybeanVarietiesTableAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_soybeanvarieties)
        val childTitle = intent.getStringExtra("childTitle")
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = childTitle

        recyclerView = findViewById(R.id.recycler_view)
        setRecyclerView()
    }

    private fun setRecyclerView() {
        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = LinearLayoutManager(this)
        adapter = SoybeanVarietiesTableAdapter(this, getList())
        recyclerView.adapter = adapter
    }

    private fun getList(): List<SoybeanVarietiesTableData> {
        val tableList = mutableListOf<SoybeanVarietiesTableData>()
        tableList.add(SoybeanVarietiesTableData("1.", "North Hill Zone","Himachal Pradesh,\nUttar Pradesh,\nand region of Uttarakhand","VLS65, VLS59, VLS63, VLS49, Palam Soya, Hara Soya"))
        tableList.add(SoybeanVarietiesTableData("2.", "Northern Plain Zone","Punjab,\nHaryana,\nDelhi,\nEastern Plains of Uttar Pradesh,\nPlains of Uttarakhand and Eastern Bihar","PS1347, PS1368, PS1092, PS1042, PS1225, SL744, SL688, Pusa 97-12, Pusa 98-14"))
        tableList.add(SoybeanVarietiesTableData("3.", "Central Zone","Madhya Pradesh,\nBundelkhand region of Uttar pradesh,\nRajasthan,\nGujrat,\nNorth-West region of Maharashtra and Orrisa","JS20-34, JS20-29, JS520-69, JS97-52, NRC7, NRC37, NRC86, MAUSA71, MAUSA158, RVS2001-4, RKS24, Pratap Soya 45, JS335"))
        tableList.add(SoybeanVarietiesTableData("4.", "Southern Zone","Karnataka,\nTamil Nadu,\nTelangana,\nSouthern Part of Kerala and Maharashtra","Phule Agrani, DSB21, DSB1, MAUSA162, Phule Kalyani, MACS1188, MACS1281, RKS18, KDS344, DS228, MAUSA2, MAUSA61, NRC77"))
        tableList.add(SoybeanVarietiesTableData("5.", "North Eastern Zone","Assam,\nWest Bengal,\nChattisgarh,\nMeghalaya,\nManipur,\nNagaland","DSB19, RKS18, Pratap Soya 1, Pratap Soya 2, JS97-52, MAUSA71, Indira Soya 9, JS80-21"))
        return tableList
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