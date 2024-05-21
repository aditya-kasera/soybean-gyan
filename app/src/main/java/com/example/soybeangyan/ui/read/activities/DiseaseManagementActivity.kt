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
            "Bacterial Diseases" -> {

                content.add(DiseaseManagementData("Bacterial Blight", R.drawable.bac_bacterial_blight))
                content.add(DiseaseManagementData("Bacterial Pustule", R.drawable.bac_bacterial_pustule))
            }

            "Fungal Diseases" -> {
                content.add(DiseaseManagementData("Charcol Rot", R.drawable.soycharcoal_rot))
                content.add(DiseaseManagementData("Collar Rot / Sclerotial Blight", R.drawable.soycollar_rot))
                content.add(DiseaseManagementData("Sclerotinia Stem Rot", R.drawable.stemflypupa3))
                content.add(DiseaseManagementData("Anthracnose & Pod Blight", R.drawable.podblight))
                content.add(DiseaseManagementData("Rust", R.drawable.soyrust))
                content.add(DiseaseManagementData("Cercospora Blight", R.drawable.cercospora_leaf_blight))
                content.add(DiseaseManagementData("Frogeye Leaf Spot", R.drawable.frogeye))
                content.add(DiseaseManagementData("Pod & Stem Blight & Phomopsis Seed Decay", R.drawable.seeddecay))
                content.add(DiseaseManagementData("Fusarium Collar & Pod Rot", R.drawable.fusarium_collar_and_pod_rot))
                content.add(DiseaseManagementData("Myrothecium Leaf Spot", R.drawable.myrothecium_leaf_spot))
                content.add(DiseaseManagementData("Root Rot, Stem Rot & Foliage/Aerial Blight", R.drawable.root_rot_or_stem_rot_and_foliage))
                content.add(DiseaseManagementData("Brown Spot", R.drawable.brown))
                content.add(DiseaseManagementData("Phyllosticta Leaf Spot", R.drawable.phyllosticta_leaf_spot))
                content.add(DiseaseManagementData("Choanephora Leaf Blight", R.drawable.choanephora))
                content.add(DiseaseManagementData("Aristastoma Leaf", R.drawable.aristastoma))
                content.add(DiseaseManagementData("Powdery Mildew", R.drawable.powdery_mildew))
                content.add(DiseaseManagementData("Target Leaf Spot", R.drawable.target_leaf_spot))
            }

            "Viral Diseases" -> {
                content.add(DiseaseManagementData("SoyBean Mosaic", R.drawable.soybean_mosaic))
                content.add(DiseaseManagementData("Yellow Mosaic", R.drawable.yellowmosaic))
                content.add(DiseaseManagementData("Indian Bud Blight", R.drawable.indianbudblight))
                content.add(DiseaseManagementData("Phyllody Associated No Podding Syndrome", R.drawable.phyllody))
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
            "Bacterial Blight" -> {
                val intent = Intent(this, DiseaseManagementActivityForFragments::class.java)
                intent.putExtra("title", title)
                intent.putExtra("image", image)
                startActivity(intent)
            }
            "Bacterial Pustule"->{
                val intent = Intent(this, DiseaseManagementActivityForFragments::class.java)
                intent.putExtra("title", title)
                intent.putExtra("image", image)
                startActivity(intent)
            }
            "Charcol Rot" -> {
                val intent = Intent(this, DiseaseManagementActivityForFragments::class.java)
                intent.putExtra("title", title)
                intent.putExtra("image", image)
                startActivity(intent)
            }
            "Collar Rot / Sclerotial Blight" ->{
                val intent = Intent(this, DiseaseManagementActivityForFragments::class.java)
                intent.putExtra("title", title)
                intent.putExtra("image", image)
                startActivity(intent)
            }
            "Sclerotinia Stem Rot" -> {
                val intent = Intent(this, DiseaseManagementActivityForFragments::class.java)
                intent.putExtra("title", title)
                intent.putExtra("image", image)
                startActivity(intent)
            }
            "Anthracnose & Pod Blight" -> {
                val intent = Intent(this, DiseaseManagementActivityForFragments::class.java)
                intent.putExtra("title", title)
                intent.putExtra("image", image)
                startActivity(intent)
            }
            "Rust" -> {
                val intent = Intent(this, DiseaseManagementActivityForFragments::class.java)
                intent.putExtra("title", title)
                intent.putExtra("image", image)
                startActivity(intent)
            }
            "Cercospora Blight"->{
                val intent = Intent(this, DiseaseManagementActivityForFragments::class.java)
                intent.putExtra("title", title)
                intent.putExtra("image", image)
                startActivity(intent)
            }

            "Frogeye Leaf Spot"->{
                val intent = Intent(this, DiseaseManagementActivityForFragments::class.java)
                intent.putExtra("title", title)
                intent.putExtra("image", image)
                startActivity(intent)
            }
            "Pod & Stem Blight & Phomopsis Seed Decay"->{
                val intent = Intent(this, DiseaseManagementActivityForFragments::class.java)
                intent.putExtra("title", title)
                intent.putExtra("image", image)
                startActivity(intent)
            }
            "Fusarium Collar & Pod Rot" -> {
                val intent = Intent(this, DiseaseManagementActivityForFragments::class.java)
                intent.putExtra("title", title)
                intent.putExtra("image", image)
                startActivity(intent)
            }
            "Myrothecium Leaf Spot"->{
                val intent = Intent(this, DiseaseManagementActivityForFragments::class.java)
                intent.putExtra("title", title)
                intent.putExtra("image", image)
                startActivity(intent)
            }
            "Root Rot, Stem Rot & Foliage/Aerial Blight" ->{
                val intent = Intent(this, DiseaseManagementActivityForFragments::class.java)
                intent.putExtra("title", title)
                intent.putExtra("image", image)
                startActivity(intent)
            }
            "Brown Spot" ->{
                val intent = Intent(this, DiseaseManagementActivityForFragments::class.java)
                intent.putExtra("title", title)
                intent.putExtra("image", image)
                startActivity(intent)
            }
            "Phyllosticta Leaf Spot" -> {
                val intent = Intent(this, DiseaseManagementActivityForFragments::class.java)
                intent.putExtra("title", title)
                intent.putExtra("image", image)
                startActivity(intent)
            }
            "Choanephora Leaf Blight"->{
                val intent = Intent(this, DiseaseManagementActivityForFragments::class.java)
                intent.putExtra("title", title)
                intent.putExtra("image", image)
                startActivity(intent)
            }
            "Aristastoma Leaf"->{
                val intent = Intent(this, DiseaseManagementActivityForFragments::class.java)
                intent.putExtra("title", title)
                intent.putExtra("image", image)
                startActivity(intent)
            }
            "Powdery Mildew"->{
                val intent = Intent(this, DiseaseManagementActivityForFragments::class.java)
                intent.putExtra("title", title)
                intent.putExtra("image", image)
                startActivity(intent)
            }
            "Target Leaf Spot"->{
                val intent = Intent(this, DiseaseManagementActivityForFragments::class.java)
                intent.putExtra("title", title)
                intent.putExtra("image", image)
                startActivity(intent)
            }
            "SoyBean Mosaic"->{
                val intent = Intent(this, DiseaseManagementActivityForFragments::class.java)
                intent.putExtra("title", title)
                intent.putExtra("image", image)
                startActivity(intent)
            }
            "Yellow Mosaic"->{
                val intent = Intent(this, DiseaseManagementActivityForFragments::class.java)
                intent.putExtra("title", title)
                intent.putExtra("image", image)
                startActivity(intent)
            }
            "Indian Bud Blight"->{
                val intent = Intent(this, DiseaseManagementActivityForFragments::class.java)
                intent.putExtra("title", title)
                intent.putExtra("image", image)
                startActivity(intent)
            }
            "Phyllody Associated No Podding Syndrome"->{
                val intent = Intent(this, DiseaseManagementActivityForFragments::class.java)
                intent.putExtra("title", title)
                intent.putExtra("image", image)
                startActivity(intent)
            }
        }
    }
}
