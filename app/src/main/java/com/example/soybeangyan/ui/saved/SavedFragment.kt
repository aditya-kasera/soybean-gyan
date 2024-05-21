package com.example.soybeangyan.ui.saved

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.soybeangyan.DetectionMainActivity
import com.example.soybeangyan.MainActivity
import com.example.soybeangyan.databinding.ActivityPredictionDescriptionBinding
import com.example.soybeangyan.databinding.FragmentSavedBinding



class SavedFragment : Fragment() {

    private var _binding: FragmentSavedBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val savedViewModel =
            ViewModelProvider(this).get(SavedViewModel::class.java)

        _binding = FragmentSavedBinding.inflate(inflater, container, false)
        val root: View = binding.root

//        val textView: TextView = binding.textSaved
//        savedViewModel.text.observe(viewLifecycleOwner) {
//            textView.text = it
//        }

        binding.btnDetect.setOnClickListener {
            val i = Intent(context, DetectionMainActivity::class.java)
            startActivity(i)
        }

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}