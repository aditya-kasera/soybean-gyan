package com.example.soybeangyan.ui.read.activities

import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.soybeangyan.R
import com.example.soybeangyan.ui.read.adapters.DiseaseManagementAdapter
import com.example.soybeangyan.ui.read.dataclasses.DiseaseManagementData
import com.example.soybeangyan.ui.read.fragments.DiseaseManagementActivityForFragments


class DiseaseManagementActivity : AppCompatActivity(),
    DiseaseManagementAdapter.OnItemClickListener {

    private lateinit var recyclerView: RecyclerView
    private lateinit var content: ArrayList<DiseaseManagementData>

    override fun onCreate(savedInstanceState: Bundle?) {
//        setTheme(R.style.Theme_SoybeanGyan)
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_disease_management)
        val childTitle = intent.getStringExtra("childTitle")
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = childTitle

        recyclerView = findViewById(R.id.reCyclerView)
        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = LinearLayoutManager(this)

        prepareData()

        val adapter = DiseaseManagementAdapter(content, this)
        recyclerView.adapter = adapter
    }

    private fun prepareData() {

        val childTitle = intent.getStringExtra("childTitle")
        content = ArrayList()
        when (childTitle) {
            getString(R.string.bacterial_diseasesz) -> {

                content.add(DiseaseManagementData(getString(R.string.bacterial_blight), R.drawable.bac_bacterial_blight))
                content.add(DiseaseManagementData(getString(R.string.bacterial_pustule), R.drawable.bac_bacterial_pustule))
            }

            getString(R.string.fungal_diseasesz) -> {
                content.add(DiseaseManagementData(getString(R.string.charcol_rot), R.drawable.soycharcoal_rot))
                content.add(DiseaseManagementData(getString(R.string.collar_rot_sclerotial_blight), R.drawable.soycollar_rot))
                content.add(DiseaseManagementData(getString(R.string.sclerotinia_stem_rot), R.drawable.stemflypupa3))
                content.add(DiseaseManagementData(getString(R.string.anthracnose_pod_blight), R.drawable.podblight))
                content.add(DiseaseManagementData(getString(R.string.rust), R.drawable.soyrust))
                content.add(DiseaseManagementData(getString(R.string.cercospora_blight), R.drawable.cercospora_leaf_blight))
                content.add(DiseaseManagementData(getString(R.string.frogeye_leaf_spot), R.drawable.frogeye))
                content.add(DiseaseManagementData(getString(R.string.pod_stem_blight_phomopsis_seed_decay), R.drawable.seeddecay))
                content.add(DiseaseManagementData(getString(R.string.fusarium_collar_pod_rot), R.drawable.fusarium_collar_and_pod_rot))
                content.add(DiseaseManagementData(getString(R.string.myrothecium_leaf_spot), R.drawable.myrothecium_leaf_spot))
                content.add(DiseaseManagementData(getString(R.string.root_rot_stem_rot_foliage_aerial_blight), R.drawable.root_rot_or_stem_rot_and_foliage))
                content.add(DiseaseManagementData(getString(R.string.brown_spot), R.drawable.brown))
                content.add(DiseaseManagementData(getString(R.string.phyllosticta_leaf_spot), R.drawable.phyllosticta_leaf_spot))
                content.add(DiseaseManagementData(getString(R.string.choanephora_leaf_blight), R.drawable.choanephora))
                content.add(DiseaseManagementData(getString(R.string.aristastoma_leaf), R.drawable.aristastoma))
                content.add(DiseaseManagementData(getString(R.string.powdery_mildew), R.drawable.powdery_mildew))
                content.add(DiseaseManagementData(getString(R.string.target_leaf_spot), R.drawable.target_leaf_spot))
            }

            getString(R.string.viral_diseasesz) -> {
                content.add(DiseaseManagementData(getString(R.string.soybean_mosaic), R.drawable.soybean_mosaic))
                content.add(DiseaseManagementData(getString(R.string.yellow_mosaic), R.drawable.yellowmosaic))
                content.add(DiseaseManagementData(getString(R.string.indian_bud_blight), R.drawable.indianbudblight))
                content.add(DiseaseManagementData(getString(R.string.phyllody_associated_no_podding_syndrome), R.drawable.phyllody))
            }
        }
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

    override fun onItemClick(item: DiseaseManagementData) {
        val title = item.title
        val image = item.image
        when (item.title) {
            getString(R.string.bacterial_blightT) -> {
                val intent = Intent(this, DiseaseManagementActivityForFragments::class.java)
                intent.putExtra("title", title)
                intent.putExtra("image", image)
                startActivity(intent)
            }
            getString(R.string.bacterial_pustulez)->{
                val intent = Intent(this, DiseaseManagementActivityForFragments::class.java)
                intent.putExtra("title", title)
                intent.putExtra("image", image)
                startActivity(intent)
            }
            getString(R.string.charcol_rotz) -> {
                val intent = Intent(this, DiseaseManagementActivityForFragments::class.java)
                intent.putExtra("title", title)
                intent.putExtra("image", image)
                startActivity(intent)
            }
            getString(R.string.collar_rot_sclerotial_blightz) ->{
                val intent = Intent(this, DiseaseManagementActivityForFragments::class.java)
                intent.putExtra("title", title)
                intent.putExtra("image", image)
                startActivity(intent)
            }
            getString(R.string.sclerotinia_stem_rotz) -> {
                val intent = Intent(this, DiseaseManagementActivityForFragments::class.java)
                intent.putExtra("title", title)
                intent.putExtra("image", image)
                startActivity(intent)
            }
            getString(R.string.anthracnose_pod_blightz) -> {
                val intent = Intent(this, DiseaseManagementActivityForFragments::class.java)
                intent.putExtra("title", title)
                intent.putExtra("image", image)
                startActivity(intent)
            }
            getString(R.string.rustz) -> {
                val intent = Intent(this, DiseaseManagementActivityForFragments::class.java)
                intent.putExtra("title", title)
                intent.putExtra("image", image)
                startActivity(intent)
            }
            getString(R.string.cercospora_blightz)->{
                val intent = Intent(this, DiseaseManagementActivityForFragments::class.java)
                intent.putExtra("title", title)
                intent.putExtra("image", image)
                startActivity(intent)
            }

            getString(R.string.frogeye_leaf_spotz)->{
                val intent = Intent(this, DiseaseManagementActivityForFragments::class.java)
                intent.putExtra("title", title)
                intent.putExtra("image", image)
                startActivity(intent)
            }
            getString(R.string.pod_stem_blight_phomopsis_seed_decayz)->{
                val intent = Intent(this, DiseaseManagementActivityForFragments::class.java)
                intent.putExtra("title", title)
                intent.putExtra("image", image)
                startActivity(intent)
            }
            getString(R.string.fusarium_collar_pod_rotz) -> {
                val intent = Intent(this, DiseaseManagementActivityForFragments::class.java)
                intent.putExtra("title", title)
                intent.putExtra("image", image)
                startActivity(intent)
            }
            getString(R.string.myrothecium_leaf_spotz)->{
                val intent = Intent(this, DiseaseManagementActivityForFragments::class.java)
                intent.putExtra("title", title)
                intent.putExtra("image", image)
                startActivity(intent)
            }
            getString(R.string.root_rot_stem_rot_foliage_aerial_blightz) ->{
                val intent = Intent(this, DiseaseManagementActivityForFragments::class.java)
                intent.putExtra("title", title)
                intent.putExtra("image", image)
                startActivity(intent)
            }
            getString(R.string.brown_spotz) ->{
                val intent = Intent(this, DiseaseManagementActivityForFragments::class.java)
                intent.putExtra("title", title)
                intent.putExtra("image", image)
                startActivity(intent)
            }
            getString(R.string.phyllosticta_leaf_spotz) -> {
                val intent = Intent(this, DiseaseManagementActivityForFragments::class.java)
                intent.putExtra("title", title)
                intent.putExtra("image", image)
                startActivity(intent)
            }
            getString(R.string.choanephora_leaf_blightz)->{
                val intent = Intent(this, DiseaseManagementActivityForFragments::class.java)
                intent.putExtra("title", title)
                intent.putExtra("image", image)
                startActivity(intent)
            }
            getString(R.string.aristastoma_leafz)->{
                val intent = Intent(this, DiseaseManagementActivityForFragments::class.java)
                intent.putExtra("title", title)
                intent.putExtra("image", image)
                startActivity(intent)
            }
            getString(R.string.powdery_mildewz)->{
                val intent = Intent(this, DiseaseManagementActivityForFragments::class.java)
                intent.putExtra("title", title)
                intent.putExtra("image", image)
                startActivity(intent)
            }
            getString(R.string.target_leaf_spotz)->{
                val intent = Intent(this, DiseaseManagementActivityForFragments::class.java)
                intent.putExtra("title", title)
                intent.putExtra("image", image)
                startActivity(intent)
            }
            getString(R.string.soybean_mosaicz)->{
                val intent = Intent(this, DiseaseManagementActivityForFragments::class.java)
                intent.putExtra("title", title)
                intent.putExtra("image", image)
                startActivity(intent)
            }
            getString(R.string.yellow_mosaicz)->{
                val intent = Intent(this, DiseaseManagementActivityForFragments::class.java)
                intent.putExtra("title", title)
                intent.putExtra("image", image)
                startActivity(intent)
            }
            getString(R.string.indian_bud_blightz)->{
                val intent = Intent(this, DiseaseManagementActivityForFragments::class.java)
                intent.putExtra("title", title)
                intent.putExtra("image", image)
                startActivity(intent)
            }
            getString(R.string.phyllody_associated_no_podding_syndromez)->{
                val intent = Intent(this, DiseaseManagementActivityForFragments::class.java)
                intent.putExtra("title", title)
                intent.putExtra("image", image)
                startActivity(intent)
            }
        }
    }
}
