package com.example.soybeangyan.ui.read.activities

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.soybeangyan.R
import com.example.soybeangyan.ui.read.fragments.InsectManagementActivityForFragments
import com.example.soybeangyan.ui.read.dataclasses.ChildData
import com.example.soybeangyan.ui.read.fragments.FarmMachineryActivityForFragments

class ContentActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()

        val parentName = intent.getStringExtra("parentName")

        @Suppress("DEPRECATION")
        val childItem = intent.getParcelableExtra<ChildData>("childItem")
        val childItemName = childItem?.title
        val childImage = childItem?.image

        if (parentName != null && childItemName != null) {
            when (parentName) {
                getString(R.string.crop_management) -> {
                    when (childItemName) {
                        getString(R.string.soil_requirement),
                        getString(R.string.tillage),
                        getString(R.string.selection_of_varieties),
                        getString(R.string.seed_treatment_inoculation),
                        getString(R.string.sowing_time_spacing_seed_rate),
                        getString(R.string.manures_fertilizers),
                        getString(R.string.intercropping_in_soybean),
                        getString(R.string.water_management),
                        getString(R.string.harvesting_threshing)
                        -> {
                            val intent = Intent(this, CropManagementActivity::class.java)
                            intent.putExtra("childTitle", childItemName)
                            startActivity(intent)
                            finish()
                        }

                        getString(R.string.suggestions_selection_of_varietiesz) -> {
                            val intent = Intent(this, PDFActivity::class.java)
                            intent.putExtra("childTitle", childItemName)
                            startActivity(intent)
                            finish()
                        }
                    }
                }

                getString(R.string.insect_management) ->
                    when (childItemName) {
                        getString(R.string.blue_beetle),
                        getString(R.string.bihar_hairy_caterpillar),
                        getString(R.string.girdle_beetle),
                        getString(R.string.gram_pod_borer),
                        getString(R.string.green_semiloopers),
                        getString(R.string.green_stink_bug),
                        getString(R.string.leaf_folder),
                        getString(R.string.leaf_miner),
                        getString(R.string.stem_fly),
                        getString(R.string.tobacco_caterpillar),
                        getString(R.string.white_fly),
                        getString(R.string.white_grub),
                        getString(R.string.brown_stripped_semilooper)
                        -> {
                            val intent =
                                Intent(this, InsectManagementActivityForFragments::class.java)
                            intent.putExtra("childTitle", childItemName)
                            intent.putExtra("image", childImage)
                            startActivity(intent)
                            finish()
                        }
                    }

                getString(R.string.disease_management) ->
                    when (childItemName) {
                        getString(R.string.bacterial_diseases),
                        getString(R.string.fungal_diseases),
                        getString(R.string.viral_diseases)
                        -> {
                            val intent = Intent(this, DiseaseManagementActivity::class.java)
                            intent.putExtra("childTitle", childItemName)
                            startActivity(intent)
                            finish()
                        }
                    }

                getString(R.string.weed_management) ->
                    when (childItemName) {
                        getString(R.string.losses_due_to_weed),
                        getString(R.string.weed_management_practices),
                        getString(R.string.general_precautions)
                        -> {
                            val intent = Intent(this, WeedManagementActivity::class.java)
                            intent.putExtra("childTitle", childItemName)
                            startActivity(intent)
                            finish()
                        }

                        getString(R.string.types_of_weed) -> {
                            val intent = Intent(this, TypesOfWeedActivity::class.java)
                            intent.putExtra("childTitle", childItemName)
                            startActivity(intent)
                            finish()
                        }

                        getString(R.string.recommended_herbicides) -> {
                            val intent = Intent(this, TableActivity::class.java)
                            intent.putExtra("childTitle", childItemName)
                            startActivity(intent)
                            finish()
                        }
                    }

                getString(R.string.soyfood_recipe) -> {
                    when (childItemName) {
                        getString(R.string.soy_nuts),
                        getString(R.string.soy_milk),
                        getString(R.string.soy_curd),
                        getString(R.string.tofu),
                        getString(R.string.soy_flour),
                        getString(R.string.soy_chakli),
                        getString(R.string.soy_mathari),
                        getString(R.string.soy_laddo),
                        getString(R.string.soy_nankhatai),
                        getString(R.string.soy_upma),
                        getString(R.string.soy_halwa),
                        getString(R.string.soy_pakora)
                        -> {
                            val intent = Intent(this, SoyFoodRecipiesActivity::class.java)
                            intent.putExtra("childTitle", childItemName)
                            intent.putExtra("image", childImage)
                            startActivity(intent)
                            finish()
                        }
                    }
                }

                getString(R.string.farm_machinery) -> {
                    when (childItemName) {
                        getString(R.string.broad_bed_furrow),
                        getString(R.string.furrow_irrigated_raised_bed_system),
                        getString(R.string.subsoiler),
                        getString(R.string.sweep_seed_drill),
                        getString(R.string.ridge_fertilizer_drill_cum_seed_planter),
                        getString(R.string.single_ridge_seed_planter),
                        getString(R.string.soybean_seed_drill_cum_planter)
                        -> {
                            val intent = Intent(this, FarmMachineryActivityForFragments::class.java)
                            intent.putExtra("childTitle", childItemName)
                            intent.putExtra("image", childImage)
                            startActivity(intent)
                            finish()
                        }
                    }
                }

                getString(R.string.important_information) -> {
                    when (childItemName) {
                        getString(R.string.recommended_sowing_time) -> {
                            val intent = Intent(this, SowingTimeTableActivity::class.java)
                            intent.putExtra("childTitle", childItemName)
                            startActivity(intent)
                            finish()
                        }

                        getString(R.string.seed_rate_spacing) -> {
                            val intent = Intent(this, SeedRateTableActivity::class.java)
                            intent.putExtra("childTitle", childItemName)
                            startActivity(intent)
                            finish()
                        }

                        getString(R.string.recommended_soybean_varieties) -> {
                            val intent = Intent(this, SoybeanVarietiesTableActivity::class.java)
                            intent.putExtra("childTitle", childItemName)
                            startActivity(intent)
                            finish()
                        }
                    }
                }
            }
        }
    }
}