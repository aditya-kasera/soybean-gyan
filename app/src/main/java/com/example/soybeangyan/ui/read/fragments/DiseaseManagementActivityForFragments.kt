package com.example.soybeangyan.ui.read.fragments
import android.os.Bundle
import android.view.MenuItem
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import com.example.soybeangyan.R

import com.example.soybeangyan.ui.read.adapters.FragmentPageAdapter
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class DiseaseManagementActivityForFragments : AppCompatActivity() {
    private lateinit var tabLayout: TabLayout
    private lateinit var viewPager2: ViewPager2
    private lateinit var adapter: FragmentPageAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
//        setTheme(R.style.Theme_SoybeanGyan)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_disease_management_for_fragments)
        val title = intent.getStringExtra("title")

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = title

        val image = intent.getIntExtra("image", 0)
        val imageId = findViewById<ImageView>(R.id.image)
        imageId.setImageResource(image)

        tabLayout = findViewById(R.id.tabLayout)
        viewPager2 = findViewById(R.id.viewPager2)

        adapter = FragmentPageAdapter(supportFragmentManager, lifecycle)
        viewPager2.adapter = adapter

        updateDetails(title)

        TabLayoutMediator(tabLayout, viewPager2) { tab, position ->
            tab.text = when (position) {
                0 -> "DESCRIPTION"
                1 -> "SYMPTOM"
                2 -> "MANAGEMENT"
                else -> null
            }
        }.attach()

        tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab?) {
                tab?.let {
                    viewPager2.currentItem = it.position
                }
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {}

            override fun onTabReselected(tab: TabLayout.Tab?) {}
        })

        viewPager2.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                tabLayout.selectTab(tabLayout.getTabAt(position))
            }
        })
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

    private fun updateDetails(title: String?) {
        val fragments = when (title) {
            "Bacterial Blight" -> listOf(
                FirstFragment.newInstance(getString(R.string.BacterialBlight1)),
                SecondFragment.newInstance(getString(R.string.BacterialBlight2)),
                ThirdFragment.newInstance(getString(R.string.BacterialBlight3))
            )
            "Bacterial Pustule" -> listOf(
                FirstFragment.newInstance(getString(R.string.BacterialPustule1)),
                SecondFragment.newInstance(getString(R.string.BacterialPustule2)),
                ThirdFragment.newInstance(getString(R.string.BacterialPustule3))

            )
            "Charcol Rot" -> listOf(
                FirstFragment.newInstance(getString(R.string.CharcolRot1)),
                SecondFragment.newInstance(getString(R.string.CharcolRot2)),
                ThirdFragment.newInstance(getString(R.string.CharcolRot3))
            )
            "Collar Rot / Sclerotial Blight" -> listOf(
                FirstFragment.newInstance(getString(R.string.SclerotialBlight1)),
                SecondFragment.newInstance(getString(R.string.SclerotialBlight2)),
                ThirdFragment.newInstance(getString(R.string.SclerotialBlight3))
            )
            "Sclerotinia Stem Rot"-> listOf(
                FirstFragment.newInstance(getString(R.string.SclerotiniaStemRot1)),
                SecondFragment.newInstance(getString(R.string.SclerotiniaStemRot2)),
                ThirdFragment.newInstance(getString(R.string.SclerotiniaStemRot3))
            )

            "Anthracnose & Pod Blight"-> listOf(
                FirstFragment.newInstance(getString(R.string.PodBlight1)),
                SecondFragment.newInstance(getString(R.string.PodBlight2)),
                ThirdFragment.newInstance(getString(R.string.PodBlight3))
            )
            "Rust"-> listOf(
                FirstFragment.newInstance(getString(R.string.Rust1)),
                SecondFragment.newInstance(getString(R.string.Rust2)),
                ThirdFragment.newInstance(getString(R.string.Rust3))
            )
            "Cercospora Blight"-> listOf(
                FirstFragment.newInstance(getString(R.string.CercosporaBlight1)),
                SecondFragment.newInstance(getString(R.string.CercosporaBlight2)),
                ThirdFragment.newInstance(getString(R.string.CercosporaBlight3))
            )
            "Frogeye Leaf Spot"-> listOf(
                FirstFragment.newInstance(getString(R.string.FrogeyeLeafSpot1)),
                SecondFragment.newInstance(getString(R.string.FrogeyeLeafSpot2)),
                ThirdFragment.newInstance(getString(R.string.FrogeyeLeafSpot3))
            )
            "Pod & Stem Blight & Phomopsis Seed Decay"-> listOf(
                FirstFragment.newInstance(getString(R.string.Phomopsis1)),
                SecondFragment.newInstance(getString(R.string.Phomopsis2)),
                ThirdFragment.newInstance(getString(R.string.Phomopsis3))
            )
            "Fusarium Collar & Pod Rot"-> listOf(
                FirstFragment.newInstance(getString(R.string.PodRot1)),
                SecondFragment.newInstance(getString(R.string.PodRot2)),
                ThirdFragment.newInstance(getString(R.string.PodRot3))
            )
            "Myrothecium Leaf Spot"-> listOf(
                FirstFragment.newInstance(getString(R.string.Myrothecium1)),
                SecondFragment.newInstance(getString(R.string.Myrothecium2)),
                ThirdFragment.newInstance(getString(R.string.Myrothecium3))
            )
            "Root Rot, Stem Rot & Foliage/Aerial Blight"-> listOf(
                FirstFragment.newInstance(getString(R.string.AerialBlight1)),
                SecondFragment.newInstance(getString(R.string.AerialBlight2)),
                ThirdFragment.newInstance(getString(R.string.AerialBlight3))
            )
            "Brown Spot"-> listOf(
                FirstFragment.newInstance(getString(R.string.BrownSpot1)),
                SecondFragment.newInstance(getString(R.string.BrownSpot2)),
                ThirdFragment.newInstance(getString(R.string.BrownSpot3))
            )
            "Phyllosticta Leaf Spot"-> listOf(
                FirstFragment.newInstance(getString(R.string.Phyllosticta1)),
                SecondFragment.newInstance(getString(R.string.Phyllosticta2)),
                ThirdFragment.newInstance(getString(R.string.Phyllosticta3))
            )
            "Choanephora Leaf Blight"-> listOf(
                FirstFragment.newInstance(getString(R.string.Choanephora1)),
                SecondFragment.newInstance(getString(R.string.Choanephora2)),
                ThirdFragment.newInstance(getString(R.string.Choanephora3))
            )
            "Aristastoma Leaf"-> listOf(
                FirstFragment.newInstance(getString(R.string.Aristastoma1)),
                SecondFragment.newInstance(getString(R.string.Aristastoma2)),
                ThirdFragment.newInstance(getString(R.string.Aristastoma3))
            )
            "Powdery Mildew"-> listOf(
                FirstFragment.newInstance(getString(R.string.Powdery1)),
                SecondFragment.newInstance(getString(R.string.Powdery2)),
                ThirdFragment.newInstance(getString(R.string.Powdery3))
            )
            "Target Leaf Spot"-> listOf(
                FirstFragment.newInstance(getString(R.string.Target1)),
                SecondFragment.newInstance(getString(R.string.Target2)),
                ThirdFragment.newInstance(getString(R.string.Target3))
            )
            "Soybean Mosaic"-> listOf(
                FirstFragment.newInstance(getString(R.string.SoybeanMosaic1)),
                SecondFragment.newInstance(getString(R.string.SoybeanMosaic2)),
                ThirdFragment.newInstance(getString(R.string.SoybeanMosaic3))
            )
            "Yellow Mosaic"-> listOf(
                FirstFragment.newInstance(getString(R.string.YellowMosaic1)),
                SecondFragment.newInstance(getString(R.string.YellowMosaic2)),
                ThirdFragment.newInstance(getString(R.string.YellowMosaic3))
            )
            "Indian Bud Blight"-> listOf(
                FirstFragment.newInstance(getString(R.string.IndianBud1)),
                SecondFragment.newInstance(getString(R.string.IndianBud2)),
                ThirdFragment.newInstance(getString(R.string.IndianBud3))
            )
            "Phyllody Associated No Podding Syndrome"-> listOf(
                FirstFragment.newInstance(getString(R.string.Phyllody1)),
                SecondFragment.newInstance(getString(R.string.Phyllody2)),
                ThirdFragment.newInstance(getString(R.string.Phyllody3))
            )
            else -> {
                @Suppress("DEPRECATION")
                onBackPressed()
                return
            }
        }
        adapter.submitList(fragments)
    }
}