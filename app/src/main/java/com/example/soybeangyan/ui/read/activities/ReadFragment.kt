package com.example.soybeangyan.ui.read.activities

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.soybeangyan.R
import com.example.soybeangyan.databinding.FragmentReadBinding
import com.example.soybeangyan.pages.AboutAppActivity
import com.example.soybeangyan.pages.AdviceActivity
import com.example.soybeangyan.pages.ContactActivity
import com.example.soybeangyan.pages.ImportantLinksActivity


class ReadFragment : Fragment() {
    private var _binding: FragmentReadBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentReadBinding.inflate(inflater, container, false)
        val root: View = binding.root

//        val helloContainer = binding.root.findViewById<ViewGroup>(R.id.main)
//        helloContainer.addView(HelloHelper.setupHelloScreen(inflater, helloContainer))

//        val readMainContainer = binding.root.findViewById<ViewGroup>(R.id.main)
//        readMainContainer.addView(ReadMainHelper.setupReadMainScreen(inflater, readMainContainer))




//        Opening Important links

        binding.ibQuickAccess1.setOnClickListener {
            openImportantLinksActivity(getString(R.string.good_practices),"https://iisrindore.icar.gov.in/goodagripractices.html")
        }

//        binding.ibQuickAccess2.setOnClickListener {
//            openImportantLinksActivity("ICAR Advisory","https://iisrindore.icar.gov.in/Advisory.html")
//        }
        binding.ibQuickAccess2.setOnClickListener {
            val intent = Intent(requireContext(), AdviceActivity::class.java)
            startActivity(intent)
        }

        binding.ibQuickAccess3.setOnClickListener {
            openImportantLinksActivity(getString(R.string.insect_management_system),"http://14.139.54.71/DSSIPM/MainHomePage.htm")
        }

        binding.ibQuickAccess4.setOnClickListener {
            openImportantLinksActivity(getString(R.string.pre_disposing_factors),"http://14.139.54.71/DSSIPM/Prediscond.htm")
        }
        binding.ibQuickAccess6.setOnClickListener {
            val intent = Intent(requireContext(), AboutAppActivity::class.java)
            startActivity(intent)
        }
        binding.ibQuickAccess7.setOnClickListener {
            val intent = Intent(requireContext(), ContactActivity::class.java)
            startActivity(intent)
        }

        binding.btnShare.setOnClickListener {
            val shareIntent = Intent(Intent.ACTION_SEND)
            shareIntent.type = "text/plain"
            val shareMessage = getString(R.string.check_out_this_amazing_app)
            shareIntent.putExtra(Intent.EXTRA_TEXT, shareMessage)
            startActivity(Intent.createChooser(shareIntent, getString(R.string.share_via)))
        }

//        binding.btnShare.setOnClickListener {
//            val appPackageName = packageName
//            val marketIntent = Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=$appPackageName"))
//            val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=$appPackageName"))
//
//            try {
//                startActivity(marketIntent)
//            } catch (e: ActivityNotFoundException) {
//                startActivity(browserIntent)
//            }
//        }
//
//        binding.btnContact.setOnClickListener {
//            val intent = Intent(requireContext(), ContactActivity::class.java)
//            startActivity(intent)
//        }


        return root
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun openImportantLinksActivity(title: String, url: String) {
        val intent = Intent(requireContext(), ImportantLinksActivity::class.java)
        intent.putExtra("TITLE", title)
        intent.putExtra("URL", url)
        startActivity(intent)
    }
}