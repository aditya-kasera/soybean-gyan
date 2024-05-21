package com.example.soybeangyan.ui.prediction

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.soybeangyan.MainActivity
import com.example.soybeangyan.R
import com.example.soybeangyan.databinding.ActivityPredictionDescriptionBinding


class PredictionDescriptionActivity : AppCompatActivity() {

    lateinit var bind : ActivityPredictionDescriptionBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_prediction_description)


        bind = ActivityPredictionDescriptionBinding.inflate((layoutInflater))
        setContentView(bind.root)
        if(::bind.isInitialized) {
            bind.tvTapToScan.setOnClickListener {
                val i = Intent(applicationContext, MainActivity::class.java)
                startActivity(i)
            }
        }


    }
}