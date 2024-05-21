package com.example.soybeangyan.ui.read.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.soybeangyan.R

class FirstFragment : Fragment() {
    private lateinit var textView: TextView

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val text = arguments?.getString("text")
        updateText(text ?: "")
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_first, container, false)
        textView = view.findViewById(R.id.textView)
        return view
    }

    private fun updateText(text: String) {
        textView.text = text
    }

    companion object {
        @JvmStatic
        fun newInstance( text: String) =
            FirstFragment().apply {
                arguments = Bundle().apply {
                    putString("text", text)
                }
            }
    }
}