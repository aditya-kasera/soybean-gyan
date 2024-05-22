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
        content.add(TypesOfWeedData(R.drawable.weedmgmt,
            getString(R.string.commelina_benghalensis_bokna)))
        content.add(TypesOfWeedData(R.drawable.diwalia,
            getString(R.string.cyanotis_axillaris_diwalia)))
        content.add(TypesOfWeedData(R.drawable.motha, getString(R.string.cyperus_rotundus_motha)))
        content.add(TypesOfWeedData(R.drawable.phoolni, getString(R.string.digera_arvensis_phoolni)))
        content.add(TypesOfWeedData(R.drawable.sanwa,
            getString(R.string.echinochloa_cru_sgalli_sanwa)))
        content.add(TypesOfWeedData(R.drawable.euphorbia_geniculata,
            getString(R.string.euphorbia_geniculata_dudhi)))
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

