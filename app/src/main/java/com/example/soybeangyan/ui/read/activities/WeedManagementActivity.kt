package com.example.soybeangyan.ui.read.activities

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.soybeangyan.R
import com.example.soybeangyan.ui.read.adapters.WeedManagementAdapter
import com.example.soybeangyan.ui.read.dataclasses.WeedManagementData

class WeedManagementActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var content: ArrayList<WeedManagementData>
    private lateinit var adapter: WeedManagementAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
//        setTheme(R.style.Theme_SoybeanGyan)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_weed_management)
        val childTitle = intent.getStringExtra("childTitle")
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = childTitle

        recyclerView = findViewById(R.id.reCyclerView)
        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = LinearLayoutManager(this)

        content = ArrayList()

        adapter = WeedManagementAdapter(content)
        recyclerView.adapter = adapter

        prepareData()
    }

    private fun prepareData() {
        val childTitle = intent.getStringExtra("childTitle")
        when (childTitle) {
            "Losses Due to Weed" -> {
                content.add(WeedManagementData(getString(R.string.loses)))
                adapter.notifyDataSetChanged()
            }
            "Weed Management Practices"->{
                content.add(WeedManagementData(getString(R.string.practise1)))
                content.add(WeedManagementData(getString(R.string.practise2)))
            }
            "General Precautions" ->{
                content.add(WeedManagementData(getString(R.string.precaution1)))
                content.add(WeedManagementData(getString(R.string.precaution2)))
                content.add(WeedManagementData(getString(R.string.precaution3)))
                content.add(WeedManagementData(getString(R.string.precaution4)))
                content.add(WeedManagementData(getString(R.string.precaution5)))

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