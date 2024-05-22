package com.example.soybeangyan.ui.read.activities

import android.os.Bundle
import android.view.MenuItem
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.soybeangyan.R

class SoyFoodRecipiesActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
//        setTheme(R.style.Theme_SoybeanGyan)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_soy_food_recipies)
        val title = intent.getStringExtra("childTitle")
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = title
        val image = intent.getIntExtra("image", 0)

        val recipeImage = findViewById<ImageView>(R.id.recipeImage)
        val recipeDetail = findViewById<TextView>(R.id.recipeDetail)

        recipeImage.setImageResource(image)

        when (title){
            getString(R.string.soy_nutsx) ->{
                recipeDetail.text = getString(R.string.soynuts)
            }
            getString(R.string.soy_milkx) ->{
                recipeDetail.text = getString(R.string.soymilk)
            }
            getString(R.string.soy_curdx)->{
                recipeDetail.text = getString(R.string.soycurd)
            }
            getString(R.string.tofux)->{
                recipeDetail.text = getString(R.string.tofu1)
            }
            getString(R.string.soy_flourx)->{
                recipeDetail.text = getString(R.string.soyflour)
            }
            getString(R.string.soy_chaklix)->{
                recipeDetail.text = getString(R.string.soychakli)
            }
            getString(R.string.soy_matharix)->{
                recipeDetail.text = getString(R.string.soymathari)
            }
            getString(R.string.soy_laddox)->{
                recipeDetail.text = getString(R.string.soyladdo)
            }
            getString(R.string.soy_nankhataix)->{
                recipeDetail.text = getString(R.string.soynankhattai)
            }
            getString(R.string.soy_upmax)->{
                recipeDetail.text = getString(R.string.soyupma)
            }
            getString(R.string.soy_halwax)->{
                recipeDetail.text = getString(R.string.soyhalwa)
            }
            getString(R.string.soy_pakorax)->{
                recipeDetail.text = getString(R.string.soypakora)
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
}
