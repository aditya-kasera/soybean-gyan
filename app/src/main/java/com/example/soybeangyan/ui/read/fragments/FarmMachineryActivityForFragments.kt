package com.example.soybeangyan.ui.read.fragments

import android.os.Bundle
import android.view.MenuItem
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import com.example.soybeangyan.ui.read.adapters.FragmentPageAdapter
import com.example.soybeangyan.R
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class FarmMachineryActivityForFragments : AppCompatActivity() {
    private lateinit var tabLayout: TabLayout
    private lateinit var viewPager2: ViewPager2
    private lateinit var adapter: FragmentPageAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
//        setTheme(R.style.Theme_SoybeanGyan)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_farm_machinery_for_fragments)
        val title = intent.getStringExtra("childTitle")
        val image = intent.getIntExtra("image",0)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = title

        val imageId = findViewById<ImageView>(R.id.image)
        imageId.setImageResource(image)

        tabLayout = findViewById(R.id.tabLayout)
        viewPager2 = findViewById(R.id.viewPager2)

        adapter = FragmentPageAdapter(supportFragmentManager, lifecycle)
        viewPager2.adapter = adapter

        updateDetails(title)

        TabLayoutMediator(tabLayout, viewPager2) { tab, position ->
            tab.text = when (position) {
                0 -> "FEATURES"
                1 -> "COST"
                2 -> "PROCUREMENT"
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
            "Broad Bed Furrow" -> listOf(
                FirstFragment.newInstance( getString(R.string.BedFurrow1)),
                SecondFragment.newInstance(getString(R.string.BedFurrow2)),
                ThirdFragment.newInstance(getString(R.string.BedFurrow3))
            )
            "Furrow Irrigated Raised Bed System" -> listOf(
                FirstFragment.newInstance( getString(R.string.FurrowIrrigated1)),
                SecondFragment.newInstance(getString(R.string.FurrowIrrigated2)),
                ThirdFragment.newInstance(getString(R.string.FurrowIrrigated3))
            )
            "Subsoiler" -> listOf(
                FirstFragment.newInstance( getString(R.string.Subsoiler1)),
                SecondFragment.newInstance(getString(R.string.Subsoiler2)),
                ThirdFragment.newInstance(getString(R.string.Subsoiler3))
            )
            "Sweep Seed Drill" -> listOf(
                FirstFragment.newInstance( getString(R.string.SeedDrill1)),
                SecondFragment.newInstance(getString(R.string.SeedDrill2)),
                ThirdFragment.newInstance(getString(R.string.SeedDrill3))
            )
            "Ridge Fertilizer Drill Cum Seed Planter" -> listOf(
                FirstFragment.newInstance( getString(R.string.RidgeFertilizer1)),
                SecondFragment.newInstance(getString(R.string.RidgeFertilizer2)),
                ThirdFragment.newInstance(getString(R.string.RidgeFertilizer3))
            )
            "Single Ridge Seed Planter" -> listOf(
                FirstFragment.newInstance( getString(R.string.SingleRidge1)),
                SecondFragment.newInstance(getString(R.string.SingleRidge2)),
                ThirdFragment.newInstance(getString(R.string.SingleRidge3))
            )
            "Soybean Seed Drill Cum Planter" -> listOf(
                FirstFragment.newInstance( getString(R.string.SoybeanSeedDrill1)),
                SecondFragment.newInstance(getString(R.string.SoybeanSeedDrill2)),
                ThirdFragment.newInstance(getString(R.string.SoybeanSeedDrill3))
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