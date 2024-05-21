package com.example.soybeangyan.ui.home

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.addCallback
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.viewpager2.widget.ViewPager2
import com.example.soybeangyan.DetectionMainActivity
import com.example.soybeangyan.MainActivity
import com.example.soybeangyan.R
import com.example.soybeangyan.databinding.FragmentHomeBinding
import com.example.soybeangyan.ui.prediction.PredictionDescriptionActivity
import com.example.soybeangyan.ui.read.activities.CropManagementActivity
import com.example.soybeangyan.ui.read.activities.ReadFragment
import com.example.soybeangyan.ui.read.activities.ReadMainActivity
import com.example.soybeangyan.ui.read.activities.RohitDekateReadActivity
import com.example.soybeangyan.ui.read.adapters.CropManagementAdapter
import com.example.soybeangyan.ui.read.adapters.ParentAdapter

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null

//    private lateinit var carousel: Carousel

    private lateinit var viewPager: ViewPager2
    private val imageList = listOf(
        R.drawable.soybean,
        R.drawable.crop,
        R.drawable.soybean_sq,
        R.drawable.plant,
        R.drawable.soybean1,
        R.drawable.plant2
    )

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val homeViewModel =
            ViewModelProvider(this).get(HomeViewModel::class.java)

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root

//        carousal code:

        viewPager = binding.viewPager
        val adapter = ImageSliderAdapter(imageList)
        binding.viewPager.adapter = adapter

        // Auto-scroll
        val handler = android.os.Handler()
        val runnable = Runnable {
            if (viewPager.currentItem == imageList.size - 1) {
                viewPager.currentItem = 0
            } else {
                viewPager.currentItem += 1
            }
        }
        handler.postDelayed(runnable, 3000) // Change image every 3 seconds

        // Stop auto-scroll when activity is destroyed
        viewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageScrollStateChanged(state: Int) {
                super.onPageScrollStateChanged(state)
                if (state == ViewPager2.SCROLL_STATE_IDLE) {
                    handler.postDelayed(runnable, 2000)
                } else {
                    handler.removeCallbacks(runnable)
                }
            }
        })

        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        if (view != null) {
            super.onViewCreated(view, savedInstanceState)
        }

//        binding.ibQuickAccess1.setOnClickListener {
//            // Navigate to ReadFragment
//            findNavController().navigate(R.id.navigation_read)
//        }
//        requireActivity().onBackPressedDispatcher.addCallback(viewLifecycleOwner) {
//            findNavController().navigate(R.id.navigation_home)
//        }
//
//        binding.ibQuickAccess1.setOnClickListener {
//                findNavController().navigate(R.id.navigation_read)
//                requireActivity().invalidateOptionsMenu()
//        }


        // Example button click to start an activity with an intent
        binding.btnRead.setOnClickListener(View.OnClickListener { // Create the intent
//            val intent = Intent(requireContext(), PredictionDescriptionActivity::class.java)
//            startActivity(intent)
            val intent = Intent(requireContext(), RohitDekateReadActivity::class.java)
            startActivity(intent)
        })
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}

