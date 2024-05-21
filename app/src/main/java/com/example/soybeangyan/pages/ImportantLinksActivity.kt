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

class ImportantLinksActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        enableEdgeToEdge()
        setContentView(R.layout.activity_important_links)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        setContentView(R.layout.activity_important_links)

        // Set status bar color
//        window.statusBarColor = ContextCompat.getColor(this, R.attr.colorPrimary)
        val typedValue = TypedValue()
        theme.resolveAttribute(android.R.attr.colorPrimary, typedValue, true)
        window.statusBarColor = typedValue.data

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
//        supportActionBar?.hide()
        // Find the WebView in the layout
        val url = intent.getStringExtra("URL")
        val title = intent.getStringExtra("TITLE")

        supportActionBar?.title = title

        val webView: WebView = findViewById(R.id.webView)
        webView.settings.javaScriptEnabled = true
        // Load web content
        if (url != null) {
            webView.loadUrl(url)
        }
//        webView.setInitialScale(115)
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