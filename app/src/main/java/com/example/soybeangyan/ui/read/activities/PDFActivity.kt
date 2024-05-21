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
            "Suggestions (Selection of Varieties)"->{
                content.add(PDFData("District Wise Varieties of CZ"))
                content.add(PDFData("District Wise Varieties of SZ"))
                content.add(PDFData("District Wise Varieties of Soybean"))
                content.add(PDFData("Varieties With Special Character"))
                content.add(PDFData("Varieties in the Seed Chain"))

            }
        }
    }
    fun onItemClick(item: PDFData) {
        val title = item.title
        when(item.title) {
            "District Wise Varieties of CZ" -> {
                val intent = Intent(this, PDFViewerActivity::class.java)
                intent.putExtra("title",title)
                startActivity(intent)
            }
            "District Wise Varieties of SZ"->{
                val intent = Intent(this, PDFViewerActivity::class.java)
                intent.putExtra("title",title)
                startActivity(intent)
            }
            "District Wise Varieties of Soybean"->{
                val intent = Intent(this, PDFViewerActivity::class.java)
                intent.putExtra("title",title)
                startActivity(intent)
            }
            "Varieties in the Seed Chain"->{
                val intent = Intent(this, PDFViewerActivity::class.java)
                intent.putExtra("title",title)
                startActivity(intent)
            }
            "Varieties With Special Character"->{
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