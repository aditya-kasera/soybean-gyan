package com.example.soybeangyan.pages

import android.os.Bundle
import android.util.TypedValue
import android.view.MenuItem
import android.webkit.WebView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.soybeangyan.R

class AdviceActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Enable edge-to-edge display
//        enableEdgeToEdge()

        // Set content view
        setContentView(R.layout.activity_advice)

        // Set padding to handle system insets
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        // Set content view
        setContentView(R.layout.activity_advice)

        // Set status bar color
//        window.statusBarColor = ContextCompat.getColor(this, R.attr.colorPrimary)
        val typedValue = TypedValue()
        theme.resolveAttribute(android.R.attr.colorPrimary, typedValue, true)
        window.statusBarColor = typedValue.data

        // Set ActionBar title
        supportActionBar?.title = "Advice for Soybean Farmers"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
//        supportActionBar?.hide()
        // Find the WebView in the layout
        val webView: WebView = findViewById(R.id.webView)

        // Load web content
        webView.loadUrl("https://iisrindore.icar.gov.in/Advisory.html")
        webView.setInitialScale(115)
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

