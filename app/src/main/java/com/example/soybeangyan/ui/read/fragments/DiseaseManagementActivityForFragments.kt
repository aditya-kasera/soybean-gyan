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
                0 -> getString(R.string.description)
                1 -> getString(R.string.symptom)
                2 -> getString(R.string.management)
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
            getString(R.string.bacterial_blightx) -> listOf(
                FirstFragment.newInstance(getString(R.string.BacterialBlight1)),
                SecondFragment.newInstance(getString(R.string.BacterialBlight2)),
                ThirdFragment.newInstance(getString(R.string.BacterialBlight3))
            )
            getString(R.string.bacterial_pustulex) -> listOf(
                FirstFragment.newInstance(getString(R.string.BacterialPustule1)),
                SecondFragment.newInstance(getString(R.string.BacterialPustule2)),
                ThirdFragment.newInstance(getString(R.string.BacterialPustule3))

            )
            getString(R.string.charcol_rotx) -> listOf(
                FirstFragment.newInstance(getString(R.string.CharcolRot1)),
                SecondFragment.newInstance(getString(R.string.CharcolRot2)),
                ThirdFragment.newInstance(getString(R.string.CharcolRot3))
            )
            getString(R.string.collar_rot_sclerotial_blightx) -> listOf(
                FirstFragment.newInstance(getString(R.string.SclerotialBlight1)),
                SecondFragment.newInstance(getString(R.string.SclerotialBlight2)),
                ThirdFragment.newInstance(getString(R.string.SclerotialBlight3))
            )
            getString(R.string.sclerotinia_stem_rotx)-> listOf(
                FirstFragment.newInstance(getString(R.string.SclerotiniaStemRot1)),
                SecondFragment.newInstance(getString(R.string.SclerotiniaStemRot2)),
                ThirdFragment.newInstance(getString(R.string.SclerotiniaStemRot3))
            )

            getString(R.string.anthracnose_pod_blightx)-> listOf(
                FirstFragment.newInstance(getString(R.string.PodBlight1)),
                SecondFragment.newInstance(getString(R.string.PodBlight2)),
                ThirdFragment.newInstance(getString(R.string.PodBlight3))
            )
            getString(R.string.rustx)-> listOf(
                FirstFragment.newInstance(getString(R.string.Rust1)),
                SecondFragment.newInstance(getString(R.string.Rust2)),
                ThirdFragment.newInstance(getString(R.string.Rust3))
            )
            getString(R.string.cercospora_blightx)-> listOf(
                FirstFragment.newInstance(getString(R.string.CercosporaBlight1)),
                SecondFragment.newInstance(getString(R.string.CercosporaBlight2)),
                ThirdFragment.newInstance(getString(R.string.CercosporaBlight3))
            )
            getString(R.string.frogeye_leaf_spotx)-> listOf(
                FirstFragment.newInstance(getString(R.string.FrogeyeLeafSpot1)),
                SecondFragment.newInstance(getString(R.string.FrogeyeLeafSpot2)),
                ThirdFragment.newInstance(getString(R.string.FrogeyeLeafSpot3))
            )
            getString(R.string.pod_stem_blight_phomopsis_seed_decayx)-> listOf(
                FirstFragment.newInstance(getString(R.string.Phomopsis1)),
                SecondFragment.newInstance(getString(R.string.Phomopsis2)),
                ThirdFragment.newInstance(getString(R.string.Phomopsis3))
            )
            getString(R.string.fusarium_collar_pod_rotx)-> listOf(
                FirstFragment.newInstance(getString(R.string.PodRot1)),
                SecondFragment.newInstance(getString(R.string.PodRot2)),
                ThirdFragment.newInstance(getString(R.string.PodRot3))
            )
            getString(R.string.myrothecium_leaf_spotx)-> listOf(
                FirstFragment.newInstance(getString(R.string.Myrothecium1)),
                SecondFragment.newInstance(getString(R.string.Myrothecium2)),
                ThirdFragment.newInstance(getString(R.string.Myrothecium3))
            )
            getString(R.string.root_rot_stem_rot_foliage_aerial_blightx)-> listOf(
                FirstFragment.newInstance(getString(R.string.AerialBlight1)),
                SecondFragment.newInstance(getString(R.string.AerialBlight2)),
                ThirdFragment.newInstance(getString(R.string.AerialBlight3))
            )
            getString(R.string.brown_spotx)-> listOf(
                FirstFragment.newInstance(getString(R.string.BrownSpot1)),
                SecondFragment.newInstance(getString(R.string.BrownSpot2)),
                ThirdFragment.newInstance(getString(R.string.BrownSpot3))
            )
            getString(R.string.phyllosticta_leaf_spotx)-> listOf(
                FirstFragment.newInstance(getString(R.string.Phyllosticta1)),
                SecondFragment.newInstance(getString(R.string.Phyllosticta2)),
                ThirdFragment.newInstance(getString(R.string.Phyllosticta3))
            )
            getString(R.string.choanephora_leaf_blightx)-> listOf(
                FirstFragment.newInstance(getString(R.string.Choanephora1)),
                SecondFragment.newInstance(getString(R.string.Choanephora2)),
                ThirdFragment.newInstance(getString(R.string.Choanephora3))
            )
            getString(R.string.aristastoma_leafx)-> listOf(
                FirstFragment.newInstance(getString(R.string.Aristastoma1)),
                SecondFragment.newInstance(getString(R.string.Aristastoma2)),
                ThirdFragment.newInstance(getString(R.string.Aristastoma3))
            )
            getString(R.string.powdery_mildewx)-> listOf(
                FirstFragment.newInstance(getString(R.string.Powdery1)),
                SecondFragment.newInstance(getString(R.string.Powdery2)),
                ThirdFragment.newInstance(getString(R.string.Powdery3))
            )
            getString(R.string.target_leaf_spotx)-> listOf(
                FirstFragment.newInstance(getString(R.string.Target1)),
                SecondFragment.newInstance(getString(R.string.Target2)),
                ThirdFragment.newInstance(getString(R.string.Target3))
            )
            getString(R.string.soybean_mosaicx)-> listOf(
                FirstFragment.newInstance(getString(R.string.SoybeanMosaic1)),
                SecondFragment.newInstance(getString(R.string.SoybeanMosaic2)),
                ThirdFragment.newInstance(getString(R.string.SoybeanMosaic3))
            )
            getString(R.string.yellow_mosaicx)-> listOf(
                FirstFragment.newInstance(getString(R.string.YellowMosaic1)),
                SecondFragment.newInstance(getString(R.string.YellowMosaic2)),
                ThirdFragment.newInstance(getString(R.string.YellowMosaic3))
            )
            getString(R.string.indian_bud_blightx)-> listOf(
                FirstFragment.newInstance(getString(R.string.IndianBud1)),
                SecondFragment.newInstance(getString(R.string.IndianBud2)),
                ThirdFragment.newInstance(getString(R.string.IndianBud3))
            )
            getString(R.string.phyllody_associated_no_podding_syndromex)-> listOf(
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