package com.example.soybeangyan.ui.read.activities

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.soybeangyan.R
import com.example.soybeangyan.ui.read.adapters.ParentAdapter
import com.example.soybeangyan.ui.read.dataclasses.ChildData
import com.example.soybeangyan.ui.read.dataclasses.ParentData

class RohitDekateReadActivity : AppCompatActivity(), ParentAdapter.OnParentItemClickListener {

    private lateinit var parentRecyclerView: RecyclerView
    private lateinit var parentList: ArrayList<ParentData>
    private lateinit var searchview: SearchView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        enableEdgeToEdge()
        setContentView(R.layout.activity_rohit_dekate_read)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        supportActionBar?.hide()

        parentRecyclerView = findViewById(R.id.parentRecyclerView)
        searchview = findViewById(R.id.searchView)
        searchview.requestFocus()
        searchview.clearFocus()
        searchview.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String): Boolean {
                filterList(newText)
                return true
            }
        })

        parentRecyclerView.setHasFixedSize(true)
        parentRecyclerView.layoutManager = LinearLayoutManager(this)
        parentList = ArrayList()
        prepareData()

        val adapter = ParentAdapter(parentList, this, this)
        parentRecyclerView.adapter = adapter
    }

    private fun filterList(newText: String) {
        val trimmedText = newText.trim()
        val filteredParentList = ArrayList<ParentData>()

        val originalParentList = ArrayList(parentList)

        for (parent in originalParentList) {
            val filteredChildren = ArrayList<ChildData>()
            for (child in parent.childItemList) {
                if (child.getChildName().lowercase().contains(trimmedText.lowercase())) {
                    filteredChildren.add(child)
                }
            }

            val isParentExpanded = filteredChildren.isNotEmpty()
            if (filteredChildren.isNotEmpty()) {
                filteredParentList.add(
                    ParentData(
                        parent.getParentName(),
                        parent.image,
                        filteredChildren,
                        isExpandable = isParentExpanded
                    )
                )
            }
        }
        filteredParentList.sortByDescending { it.isExpandable }

        if (filteredParentList.isEmpty())
            Toast.makeText(this, getString(R.string.no_data_found), Toast.LENGTH_SHORT).show()
        else
            (parentRecyclerView.adapter as ParentAdapter).setFilterList(filteredParentList)
    }

    override fun onParentItemClick(
        parentAdapter: ParentAdapter,
        parentTitle: String,
        childPosition: Int,
        childItem: ChildData
    ) {
        val intent = Intent(parentAdapter.context, ContentActivity::class.java)

        intent.putExtra("parentName", parentTitle)
        intent.putExtra("childPosition", childPosition)
        intent.putExtra("childItem", childItem)

        parentAdapter.context.startActivity(intent)

    }


    private fun prepareData() {
        val childItems1 = ArrayList<ChildData>()
        childItems1.add(ChildData(getString(R.string.soil_requirementzz), R.drawable.soilrequirement))
        childItems1.add(ChildData(
            getString(R.string.tillagezz), R.drawable.tillage
        ))
        childItems1.add(ChildData(getString(R.string.selection_of_varietieszz), R.drawable.vaarieties))
        childItems1.add(ChildData(getString(R.string.suggestions_selection_of_varietieszz), R.drawable.suggestions))
        childItems1.add(ChildData(getString(R.string.seed_treatment_inoculationzz), R.drawable.seedtreatement))
        childItems1.add(ChildData(getString(R.string.sowing_time_spacing_seed_ratezz), R.drawable.time))
        childItems1.add(ChildData(getString(R.string.manures_fertilizerszz), R.drawable.fertilizers))
        childItems1.add(ChildData(getString(R.string.intercropping_in_soybeanzz), R.drawable.intercropping))
        childItems1.add(ChildData(getString(R.string.water_managementzz),R.drawable.watermanagement))
        childItems1.add(ChildData(getString(R.string.harvesting_threshingzz),R.drawable.harvesting))
        parentList.add(ParentData(getString(R.string.crop_managementz), R.drawable.cropmanage, childItems1))

        val childItems2 = ArrayList<ChildData>()
        childItems2.add(ChildData(getString(R.string.blue_beetlez), R.drawable.blue_beetle))
        childItems2.add(ChildData(getString(R.string.bihar_hairy_caterpillarz), R.drawable.biharhairyketerpiller_adlt1))
        childItems2.add(ChildData(getString(R.string.girdle_beetlez), R.drawable.gb_adult17))
        childItems2.add(ChildData(getString(R.string.gram_pod_borerz), R.drawable.grampodborrerheliolarvae1))
        childItems2.add(ChildData(getString(R.string.green_semiloopersz), R.drawable.semilooper_calarva1))
        childItems2.add(ChildData(getString(R.string.green_stink_bugz), R.drawable.greenstingbugadlt2))
        childItems2.add(ChildData(getString(R.string.leaf_folderz), R.drawable.if_adult))
        childItems2.add(ChildData(getString(R.string.leaf_minerz), R.drawable.leafminorlarva1))
        childItems2.add(ChildData(getString(R.string.stem_flyz), R.drawable.stemfly_adult2))
        childItems2.add(ChildData(getString(R.string.tobacco_caterpillarz), R.drawable.tobaccoketerpilleradlt2))
        childItems2.add(ChildData(getString(R.string.white_flyz), R.drawable.whiteflyadlts1))
        childItems2.add(ChildData(getString(R.string.white_grubz), R.drawable.white_grub16))
        childItems2.add(ChildData(getString(R.string.brown_stripped_semilooperzz), R.drawable.semilooper7))
        parentList.add(ParentData(getString(R.string.insect_managementz), R.drawable.pest_management_concept, childItems2))

        val childItems3 = ArrayList<ChildData>()
        childItems3.add(ChildData(getString(R.string.bacterial_diseaseszz), R.drawable.bacteria))
        childItems3.add(ChildData(getString(R.string.fungal_diseaseszz), R.drawable.fungi))
        childItems3.add(ChildData(getString(R.string.viral_diseaseszz), R.drawable.virus_fellodi))
        parentList.add(ParentData(getString(R.string.disease_managementzz), R.drawable.brown_spot_disease, childItems3))

        val childItems4 = ArrayList<ChildData>()
        childItems4.add(ChildData(getString(R.string.losses_due_to_weedz), R.drawable.lossduetoweed))
        childItems4.add(ChildData(getString(R.string.types_of_weedz), R.drawable.typesofweed))
        childItems4.add(ChildData(getString(R.string.weed_management_practicesz), R.drawable.weedmgmt))
        childItems4.add(ChildData(getString(R.string.recommended_herbicidesz), R.drawable.herbicides))
        childItems4.add(ChildData(getString(R.string.general_precautionsz), R.drawable.precaution_exclamation))
        parentList.add(ParentData(getString(R.string.weed_managementz), R.drawable.weed_img, childItems4))

        val childItems5 = ArrayList<ChildData>()
        childItems5.add(ChildData(getString(R.string.soy_nutsz), R.drawable.soynuts))
        childItems5.add(ChildData(getString(R.string.soy_milkz), R.drawable.soya_dudh))
        childItems5.add(ChildData(getString(R.string.soy_curdz), R.drawable.dahi))
        childItems5.add(ChildData(getString(R.string.tofuz), R.drawable.tofu))
        childItems5.add(ChildData(getString(R.string.soy_flourz), R.drawable.soya_flour))
        childItems5.add(ChildData(getString(R.string.soy_chakliz), R.drawable.chakli))
        childItems5.add(ChildData(getString(R.string.soy_mathariz), R.drawable.mathari))
        childItems5.add(ChildData(getString(R.string.soy_laddoz), R.drawable.ladoo))
        childItems5.add(ChildData(getString(R.string.soy_nankhataiz), R.drawable.nankhattai))
        childItems5.add(ChildData(getString(R.string.soy_upmaz), R.drawable.upma))
        childItems5.add(ChildData(getString(R.string.soy_halwaz), R.drawable.halwa))
        childItems5.add(ChildData(getString(R.string.soy_pakoraz), R.drawable.onion))
        parentList.add(ParentData(getString(R.string.soyfood_recipez), R.drawable.soy_products, childItems5))

        val childItems6 = ArrayList<ChildData>()
        childItems6.add(ChildData(getString(R.string.broad_bed_furrowz), R.drawable.bbf))
        childItems6.add(ChildData(getString(R.string.furrow_irrigated_raised_bed_systemz), R.drawable.firbs))
        childItems6.add(ChildData(getString(R.string.subsoilerz), R.drawable.subsoiler_machine))
        childItems6.add(ChildData(getString(R.string.sweep_seed_drillz), R.drawable.sweep_seed_drill_machine))
        childItems6.add(ChildData(getString(R.string.ridge_fertilizer_drill_cum_seed_planterz), R.drawable.rfdcsp))
        childItems6.add(ChildData(getString(R.string.single_ridge_seed_planterz), R.drawable.single_ridge_seed_planter))
        childItems6.add(ChildData(getString(R.string.soybean_seed_drill_cum_planterz), R.drawable.soybean_seed_drill_cum_planter))
        parentList.add(ParentData(getString(R.string.farm_machineryz), R.drawable.farm_machine, childItems6))

        val childItems7 = ArrayList<ChildData>()
        childItems7.add(ChildData(getString(R.string.recommended_sowing_timez), R.drawable.recommendedsowingtime))
        childItems7.add(ChildData(getString(R.string.seed_rate_spacingz), R.drawable.sowingtime))
        childItems7.add(ChildData(getString(R.string.recommended_soybean_varietiesz), R.drawable.soybeanvarietieties))
        parentList.add(ParentData(getString(R.string.important_informationz), R.drawable.imp_info, childItems7))
    }
}