package com.example.soybeangyan.ui.read.activities

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.soybeangyan.R
import com.example.soybeangyan.ui.read.adapters.TypesOfWeedAdapter
import com.example.soybeangyan.ui.read.dataclasses.TypesOfWeedData

class TypesOfWeedActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var content: ArrayList<TypesOfWeedData>

    override fun onCreate(savedInstanceState: Bundle?) {
//        setTheme(R.style.Theme_SoybeanGyan)
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_types_of_weed)
        val childTitle = intent.getStringExtra("childTitle")
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = childTitle

        recyclerView = findViewById(R.id.reCyclerView)
        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = LinearLayoutManager(this)

        prepareData()

        val adapter = TypesOfWeedAdapter(content)
        recyclerView.adapter = adapter
    }

    private fun prepareData() {

        content = ArrayList()
        content.add(TypesOfWeedData(R.drawable.weedmgmt, "Commelina Benghalensis (Bokna)"))
        content.add(TypesOfWeedData(R.drawable.diwalia, "Cyanotis Axillaris (Diwalia)"))
        content.add(TypesOfWeedData(R.drawable.motha, "Cyperus Rotundus (Motha)"))
        content.add(TypesOfWeedData(R.drawable.phoolni, "Digera Arvensis (Phoolni)"))
        content.add(TypesOfWeedData(R.drawable.sanwa, "Echinochloa Cru-Sgalli (Sanwa)"))
        content.add(TypesOfWeedData(R.drawable.euphorbia_geniculata, "Euphorbia Geniculata (Dudhi)"))
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

