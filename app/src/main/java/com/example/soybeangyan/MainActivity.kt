package com.example.soybeangyan

import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Build
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import androidx.appcompat.app.AlertDialog
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.example.soybeangyan.databinding.ActivityMainBinding
import com.example.soybeangyan.pages.AdviceActivity

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    private fun getBackgroundColor(): Int {
        // Here you can dynamically fetch the background color
        val rootView = window.decorView.findViewById<View>(android.R.id.content)
        val backgroundDrawable = rootView.background

        return if (backgroundDrawable is ColorDrawable) {
            // If the background is a color drawable, return the color
            backgroundDrawable.color
        } else {
            // If the background is not a color drawable, return a default color
            // You can adjust this default color based on your requirements

            Color.BLACK //color of flags
        }
    }

    private fun isLightColor(color: Int): Boolean {
        // Calculate the perceived brightness of the color
        val darkness = 1 - (0.299 * android.graphics.Color.red(color) + 0.587 * android.graphics.Color.green(color) + 0.114 * android.graphics.Color.blue(color)) / 255
        return darkness < 0.5 // Return true if perceived brightness is less than 0.5, indicating a light color
    }

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Apply window insets
//        ViewCompat.setOnApplyWindowInsetsListener(binding.root) { v, insets ->
//            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
//            insets
//        }

        // Make the status bar transparent
        @Suppress("DEPRECATION")
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN

        // Check if the device's SDK version is greater than or equal to Android 5.0 (API level 21)

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            // Make the status bar translucent
            @Suppress("DEPRECATION")
            window.addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)

            // Make the navigation bar translucent
            @Suppress("DEPRECATION")
            window.addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION)

            val backgroundColor = getBackgroundColor()
            val isLightBackground = isLightColor(backgroundColor)

            if (isLightBackground) {
                @Suppress("DEPRECATION")
                window.decorView.systemUiVisibility = window.decorView.systemUiVisibility and View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR.inv()
            } else {
                @Suppress("DEPRECATION")
                window.decorView.systemUiVisibility = window.decorView.systemUiVisibility or View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
            }
        }


//        also remove padding from bottom and adjust as per bars

        val navView: BottomNavigationView = binding.navView

        val navController = findNavController(R.id.nav_host_fragment_activity_main)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        supportActionBar?.hide()
//        val appBarConfiguration = AppBarConfiguration(
//            setOf(
//                R.id.navigation_saved, R.id.navigation_home, R.id.navigation_settings, R.id.navigation_settings
//            )
//        )
//        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)

    }
//    override fun onBackPressed() {
//        AlertDialog.Builder(this)
//            .setMessage("Are you sure, you want to exit ?")
//            .setPositiveButton("Yes") { dialog, which ->
//                @Suppress("DEPRECATION")
//                super.onBackPressed()
//            }
//            .setNegativeButton("No", null)
//            .show()
//    }
}