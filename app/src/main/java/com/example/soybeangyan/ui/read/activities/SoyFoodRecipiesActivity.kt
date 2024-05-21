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
            "Soy Nuts" ->{
                recipeDetail.text = getString(R.string.soynuts)
            }
            "Soy Milk" ->{
                recipeDetail.text = getString(R.string.soymilk)
            }
            "Soy Curd"->{
                recipeDetail.text = getString(R.string.soycurd)
            }
            "Tofu"->{
                recipeDetail.text = getString(R.string.tofu)
            }
            "Soy Flour"->{
                recipeDetail.text = getString(R.string.soyflour)
            }
            "Soy Chakli"->{
                recipeDetail.text = getString(R.string.soychakli)
            }
            "Soy Mathari"->{
                recipeDetail.text = getString(R.string.soymathari)
            }
            "Soy Laddo"->{
                recipeDetail.text = getString(R.string.soyladdo)
            }
            "Soy Nankhatai"->{
                recipeDetail.text = getString(R.string.soynankhattai)
            }
            "Soy Upma"->{
                recipeDetail.text = getString(R.string.soyupma)
            }
            "Soy Halwa"->{
                recipeDetail.text = getString(R.string.soyhalwa)
            }
            "Soy Pakora"->{
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
