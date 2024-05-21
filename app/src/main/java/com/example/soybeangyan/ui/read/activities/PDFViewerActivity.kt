package com.example.soybeangyan.ui.read.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.soybeangyan.R

import android.view.MenuItem
import com.github.barteksc.pdfviewer.PDFView

class PDFViewerActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pdfviewer)
        val title = intent.getStringExtra("title")

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = title

        val pdfView: PDFView = findViewById(R.id.pdfView)

        when (title) {
            "District Wise Varieties of CZ" -> {
                pdfView.fromAsset("district_wise_varieties_of_cz.pdf").load()
            }
            "District Wise Varieties of SZ"->{
                pdfView.fromAsset("district_wise_varieties_of_sz.pdf").load()
            }
            "District Wise Varieties of Soybean"->{
                pdfView.fromAsset("state_wise_varieties_of_soybean.pdf").load()
            }
            "Varieties in the Seed Chain"->{
                pdfView.fromAsset("varieties_in_the_seed_chain.pdf").load()
            }
            "Varieties With Special Character"->{
                pdfView.fromAsset("varieties_with_special_character.pdf").load()
            }
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            android.R.id.home -> {
                onBackPressed()
                true
            }

            else -> super.onOptionsItemSelected(item)
        }
    } }