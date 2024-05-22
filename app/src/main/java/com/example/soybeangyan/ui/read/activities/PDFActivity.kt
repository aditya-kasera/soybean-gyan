package com.example.soybeangyan.ui.read.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.soybeangyan.R
import android.content.Intent
import android.view.MenuItem
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.soybeangyan.ui.read.adapters.PDFAdapter
import com.example.soybeangyan.ui.read.dataclasses.PDFData

class PDFActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var content: ArrayList<PDFData>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pdfactivity)

        val childTitle = intent.getStringExtra("childTitle")
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = childTitle
        recyclerView = findViewById(R.id.reCyclerView)
        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = LinearLayoutManager(this)

        prepareData()

        val adapter = PDFAdapter(content, this)
        recyclerView.adapter = adapter
    }

    private fun prepareData() {

        val childTitle = intent.getStringExtra("childTitle")
        content = ArrayList()
        when(childTitle){
            getString(R.string.suggestions_selection_of_varieties)->{
                content.add(PDFData(getString(R.string.district_wise_varieties_of_cz)))
                content.add(PDFData(getString(R.string.district_wise_varieties_of_sz)))
                content.add(PDFData(getString(R.string.district_wise_varieties_of_soybean)))
                content.add(PDFData(getString(R.string.varieties_with_special_character)))
                content.add(PDFData(getString(R.string.varieties_in_the_seed_chain)))

            }
        }
    }
    fun onItemClick(item: PDFData) {
        val title = item.title
        when(item.title) {
            getString(R.string.district_wise_varieties_of_czz) -> {
                val intent = Intent(this, PDFViewerActivity::class.java)
                intent.putExtra("title",title)
                startActivity(intent)
            }
            getString(R.string.district_wise_varieties_of_szz)->{
                val intent = Intent(this, PDFViewerActivity::class.java)
                intent.putExtra("title",title)
                startActivity(intent)
            }
            getString(R.string.district_wise_varieties_of_soybeanz)->{
                val intent = Intent(this, PDFViewerActivity::class.java)
                intent.putExtra("title",title)
                startActivity(intent)
            }
            getString(R.string.varieties_in_the_seed_chainz)->{
                val intent = Intent(this, PDFViewerActivity::class.java)
                intent.putExtra("title",title)
                startActivity(intent)
            }
            getString(R.string.varieties_with_special_characterz)->{
                val intent = Intent(this, PDFViewerActivity::class.java)
                intent.putExtra("title",title)
                startActivity(intent)
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