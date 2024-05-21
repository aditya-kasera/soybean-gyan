package com.example.soybeangyan.ui.read.activities

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
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
                "Crop\nManagement" -> {
                    when (childItemName) {
                        "Soil Requirement",
                        "Tillage",
                        "Selection of Varieties",
                        "Seed Treatment & Inoculation",
                        "Sowing Time, Spacing & Seed Rate",
                        "Manures & Fertilizers",
                        "Intercropping in Soybean",
                        "Water Management",
                        "Harvesting & Threshing"
                        -> {
                            val intent = Intent(this, CropManagementActivity::class.java)
                            intent.putExtra("childTitle", childItemName)
                            startActivity(intent)
                            finish()
                        }

                        "Suggestions (Selection of Varieties)" -> {
                            val intent = Intent(this, PDFActivity::class.java)
                            intent.putExtra("childTitle", childItemName)
                            startActivity(intent)
                            finish()
                        }
                    }
                }

                "Insect\nManagement" ->
                    when (childItemName) {
                        "Blue Beetle",
                        "Bihar Hairy Caterpillar",
                        "Girdle Beetle",
                        "Gram Pod Borer",
                        "Green Semiloopers",
                        "Green Stink Bug",
                        "Leaf Folder",
                        "Leaf Miner",
                        "Stem Fly",
                        "Tobacco Caterpillar",
                        "White Fly",
                        "White Grub",
                        "Brown Stripped Semilooper"
                        -> {
                            val intent =
                                Intent(this, InsectManagementActivityForFragments::class.java)
                            intent.putExtra("childTitle", childItemName)
                            intent.putExtra("image", childImage)
                            startActivity(intent)
                            finish()
                        }
                    }

                "Disease\nManagement" ->
                    when (childItemName) {
                        "Bacterial Diseases",
                        "Fungal Diseases",
                        "Viral Diseases"
                        -> {
                            val intent = Intent(this, DiseaseManagementActivity::class.java)
                            intent.putExtra("childTitle", childItemName)
                            startActivity(intent)
                            finish()
                        }
                    }

                "Weed\nManagement" ->
                    when (childItemName) {
                        "Losses Due to Weed",
                        "Weed Management Practices",
                        "General Precautions"
                        -> {
                            val intent = Intent(this, WeedManagementActivity::class.java)
                            intent.putExtra("childTitle", childItemName)
                            startActivity(intent)
                            finish()
                        }

                        "Types of Weed" -> {
                            val intent = Intent(this, TypesOfWeedActivity::class.java)
                            intent.putExtra("childTitle", childItemName)
                            startActivity(intent)
                            finish()
                        }

                        "Recommended Herbicides" -> {
                            val intent = Intent(this, TableActivity::class.java)
                            intent.putExtra("childTitle", childItemName)
                            startActivity(intent)
                            finish()
                        }
                    }

                "Soyfood\nRecipe" -> {
                    when (childItemName) {
                        "Soy Nuts",
                        "Soy Milk",
                        "Soy Curd",
                        "Tofu",
                        "Soy Flour",
                        "Soy Chakli",
                        "Soy Mathari",
                        "Soy Laddo",
                        "Soy Nankhatai",
                        "Soy Upma",
                        "Soy Halwa",
                        "Soy Pakora"
                        -> {
                            val intent = Intent(this, SoyFoodRecipiesActivity::class.java)
                            intent.putExtra("childTitle", childItemName)
                            intent.putExtra("image", childImage)
                            startActivity(intent)
                            finish()
                        }
                    }
                }

                "Farm\nMachinery" -> {
                    when (childItemName) {
                        "Broad Bed Furrow",
                        "Furrow Irrigated Raised Bed System",
                        "Subsoiler",
                        "Sweep Seed Drill",
                        "Ridge Fertilizer Drill Cum Seed Planter",
                        "Single Ridge Seed Planter",
                        "Soybean Seed Drill Cum Planter"
                        -> {
                            val intent = Intent(this, FarmMachineryActivityForFragments::class.java)
                            intent.putExtra("childTitle", childItemName)
                            intent.putExtra("image", childImage)
                            startActivity(intent)
                            finish()
                        }
                    }
                }

                "Important\nInformation" -> {
                    when (childItemName) {
                        "Recommended Sowing Time" -> {
                            val intent = Intent(this, SowingTimeTableActivity::class.java)
                            intent.putExtra("childTitle", childItemName)
                            startActivity(intent)
                            finish()
                        }

                        "Seed Rate & Spacing" -> {
                            val intent = Intent(this, SeedRateTableActivity::class.java)
                            intent.putExtra("childTitle", childItemName)
                            startActivity(intent)
                            finish()
                        }

                        "Recommended Soybean Varieties" -> {
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