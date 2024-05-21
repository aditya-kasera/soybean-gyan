package com.example.soybeangyan.ui.read.activities

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ReadViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is read Fragment"
    }
    val text: LiveData<String> = _text
}