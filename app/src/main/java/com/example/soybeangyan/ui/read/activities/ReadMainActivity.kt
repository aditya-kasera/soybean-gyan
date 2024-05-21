package com.example.soybeangyan.ui.read.activities


import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.soybeangyan.R
import androidx.recyclerview.widget.RecyclerView
import com.example.soybeangyan.ui.read.dataclasses.ParentData


class ReadMainActivity : AppCompatActivity() {

    private lateinit var parentRecyclerView: RecyclerView
    private lateinit var parentList: ArrayList<ParentData>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_read_main)

//        ReadMainHelper.setupReadMainScreen(layoutInflater, findViewById(R.id.main))
    }
}