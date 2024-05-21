package com.example.soybeangyan.ui.read.activities


import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.soybeangyan.R

// HelloActivity.kt

class HelloActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_hello)

        HelloHelper.setupHelloScreen(layoutInflater, findViewById(R.id.main))
    }
}


//class HelloActivity : AppCompatActivity() {
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        enableEdgeToEdge()
//        setContentView(R.layout.activity_hello)
//
//        Log.d("HelloActivity", "Layout inflated")
//
//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
//            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
//            insets
//        }
//
//        Log.d("HelloActivity", "OnApplyWindowInsetsListener set")
//
//        // Set text of TextView to "HEY"
//        findViewById<TextView>(R.id.helloTV).text = "HEY"
//
//        Log.d("HelloActivity", "Text set to HEY")
//    }
//}
