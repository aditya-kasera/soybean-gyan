package com.example.soybeangyan.ui.read.activities

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.soybeangyan.R.*

class HelloHelper {
    companion object {
        fun setupHelloScreen(layoutInflater: LayoutInflater, container: ViewGroup): View {
            val helloActivityView = layoutInflater.inflate(layout.activity_hello, container, false)
            val helloTV = helloActivityView.findViewById<TextView>(id.helloTV)
            helloTV.text = "HEY"
            return helloActivityView
        }
    }
}
