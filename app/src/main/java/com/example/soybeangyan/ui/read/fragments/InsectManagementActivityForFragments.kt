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

class InsectManagementActivityForFragments : AppCompatActivity() {
    private lateinit var tabLayout: TabLayout
    private lateinit var viewPager2: ViewPager2
    private lateinit var adapter: FragmentPageAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
//        setTheme(R.style.Theme_SoybeanGyan)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_insect_management_for_fragments)
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
                0 -> getString(R.string.identification)
                1 -> getString(R.string.damage)
                2 -> getString(R.string.managementx)
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
            getString(R.string.blue_beetlex) -> listOf(
                FirstFragment.newInstance( getString(R.string.BlueBeetle1)),
                SecondFragment.newInstance(getString(R.string.BlueBeetle2)),
                ThirdFragment.newInstance(getString(R.string.BlueBeetle3))
            )
            getString(R.string.bihar_hairy_caterpillarx) -> listOf(
                FirstFragment.newInstance(getString(R.string.HairyCaterpillar1)),
                SecondFragment.newInstance(getString(R.string.HairyCaterpillar2)),
                ThirdFragment.newInstance(getString(R.string.HairyCaterpillar3))
            )
            getString(R.string.girdle_beetlex) -> listOf(
                FirstFragment.newInstance(getString(R.string.GirdleBeetle1)),
                SecondFragment.newInstance(getString(R.string.GirdleBeetle2)),
                ThirdFragment.newInstance(getString(R.string.GirdleBeetle3))
            )
            getString(R.string.gram_pod_borerx) -> listOf(
                FirstFragment.newInstance(getString(R.string.PodBorer1)),
                SecondFragment.newInstance(getString(R.string.PodBorer2)),
                ThirdFragment.newInstance(getString(R.string.PodBorer3))
            )
            getString(R.string.green_semiloopersx) -> listOf(
                FirstFragment.newInstance(getString(R.string.Semiloopers1)),
                SecondFragment.newInstance(getString(R.string.Semiloopers2)),
                ThirdFragment.newInstance(getString(R.string.Semiloopers3))
            )
            getString(R.string.green_stink_bugx) -> listOf(
                FirstFragment.newInstance(getString(R.string.StinkBug1)),
                SecondFragment.newInstance(getString(R.string.StinkBug2)),
                ThirdFragment.newInstance(getString(R.string.StinkBug3))
            )
            getString(R.string.leaf_folderx) -> listOf(
                FirstFragment.newInstance(getString(R.string.LeafFolder1)),
                SecondFragment.newInstance(getString(R.string.LeafFolder2)),
                ThirdFragment.newInstance(getString(R.string.LeafFolder3))
            )
            getString(R.string.leaf_minerx) -> listOf(
                FirstFragment.newInstance(getString(R.string.LeafMiner1)),
                SecondFragment.newInstance(getString(R.string.LeafMiner2)),
                ThirdFragment.newInstance(getString(R.string.LeafMiner3))
            )
            getString(R.string.stem_flyx) -> listOf(
                FirstFragment.newInstance(getString(R.string.StemFly1)),
                SecondFragment.newInstance(getString(R.string.StemFly2)),
                ThirdFragment.newInstance(getString(R.string.StemFly3))
            )
            getString(R.string.tobacco_caterpillarx) -> listOf(
                FirstFragment.newInstance(getString(R.string.TobaccoCaterpillar1)),
                SecondFragment.newInstance(getString(R.string.TobaccoCaterpillar2)),
                ThirdFragment.newInstance(getString(R.string.TobaccoCaterpillar3))
            )
            getString(R.string.white_flyx) -> listOf(
                FirstFragment.newInstance(getString(R.string.WhiteFly1)),
                SecondFragment.newInstance(getString(R.string.WhiteFly2)),
                ThirdFragment.newInstance(getString(R.string.WhiteFly3))
            )
            getString(R.string.white_grubx) -> listOf(
                FirstFragment.newInstance(getString(R.string.WhiteGrub1)),
                SecondFragment.newInstance(getString(R.string.WhiteGrub2)),
                ThirdFragment.newInstance(getString(R.string.WhiteGrub3))
            )
            getString(R.string.brown_stripped_semilooperx) -> listOf(
                FirstFragment.newInstance(getString(R.string.StrippedSemilooper1)),
                SecondFragment.newInstance(getString(R.string.StrippedSemilooper2)),
                ThirdFragment.newInstance(getString(R.string.StrippedSemilooper3))
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