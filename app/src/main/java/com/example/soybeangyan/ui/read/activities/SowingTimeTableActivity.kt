package com.example.soybeangyan.ui.read.activities

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.soybeangyan.R
import com.example.soybeangyan.ui.read.adapters.SowingTimeTableAdapter
import com.example.soybeangyan.ui.read.dataclasses.SowingTimeTableData

class SowingTimeTableActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: SowingTimeTableAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sowingtimetable)
//        setTheme(R.style.Theme_SoybeanGyan)
        val childTitle = intent.getStringExtra("childTitle")
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = childTitle

        recyclerView = findViewById(R.id.recycler_view)
        setRecyclerView()
    }

    private fun setRecyclerView() {
        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = LinearLayoutManager(this)
        adapter = SowingTimeTableAdapter(this, getList())
        recyclerView.adapter = adapter
    }

    private fun getList(): List<SowingTimeTableData> {
        val tableList = mutableListOf<SowingTimeTableData>()
        tableList.add(SowingTimeTableData("North East", "15th June - 30th June"))
        tableList.add(SowingTimeTableData("North Plain", "20th June - 5th July"))
        tableList.add(SowingTimeTableData("Central", "20th June - 5th July"))
        tableList.add(SowingTimeTableData("Southern", "15th June - 30th June"))
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