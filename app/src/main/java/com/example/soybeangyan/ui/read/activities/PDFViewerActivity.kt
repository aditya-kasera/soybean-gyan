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
            getString(R.string.district_wise_varieties_of_czzz) -> {
                pdfView.fromAsset("district_wise_varieties_of_cz.pdf").load()
            }
            getString(R.string.district_wise_varieties_of_szzz)->{
                pdfView.fromAsset("district_wise_varieties_of_sz.pdf").load()
            }
            getString(R.string.district_wise_varieties_of_soybeanzz)->{
                pdfView.fromAsset("state_wise_varieties_of_soybean.pdf").load()
            }
            getString(R.string.varieties_in_the_seed_chainzz)->{
                pdfView.fromAsset("varieties_in_the_seed_chain.pdf").load()
            }
            getString(R.string.varieties_with_special_characterzz)->{
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