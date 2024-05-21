package com.example.soybeangyan.ui.read.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.soybeangyan.R
import android.view.MenuItem
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.soybeangyan.ui.read.adapters.SeedRateTableAdapter
import com.example.soybeangyan.ui.read.dataclasses.SeedRateTableData

class SeedRateTableActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: SeedRateTableAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_seedratetable)
        val childTitle = intent.getStringExtra("childTitle")
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = childTitle

        recyclerView = findViewById(R.id.recycler_view)
        setRecyclerView()
    }

    private fun setRecyclerView() {
        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = LinearLayoutManager(this)
        adapter = SeedRateTableAdapter(this, getList())
        recyclerView.adapter = adapter
    }

    private fun getList(): List<SeedRateTableData> {
        val tableList = mutableListOf<SeedRateTableData>()
        tableList.add(SeedRateTableData("North East", "55","45"))
        tableList.add(SeedRateTableData("North Plain", "65","45"))
        tableList.add(SeedRateTableData("Central", "65","45"))
        tableList.add(SeedRateTableData("Southern", "65","45"))
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