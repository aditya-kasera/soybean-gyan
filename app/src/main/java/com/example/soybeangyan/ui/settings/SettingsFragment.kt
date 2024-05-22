package com.example.soybeangyan.ui.settings

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatDelegate
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.soybeangyan.R
import android.content.Context
import android.widget.AdapterView
import android.widget.ArrayAdapter

import com.example.soybeangyan.databinding.FragmentSettingsBinding

class SettingsFragment : Fragment() {

    private var _binding: FragmentSettingsBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    private lateinit var currentFontSize: String

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val settingsViewModel =
            ViewModelProvider(this).get(SettingsViewModel::class.java)

        _binding = FragmentSettingsBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.textSettings
        settingsViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }

        binding.btnLightMode.setOnClickListener {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
//            Log.d("ThemeChange", "Theme to be set")
//            setTheme(AppCompatDelegate.MODE_NIGHT_NO)
//            requireActivity().setTheme(R.style.)
//            Log.d("ThemeChange", "Theme setting")
//            requireActivity().recreate()
//            Log.d("ThemeChange", "Theme set")
//            setTheme(R.style.Theme_SoybeanGyan)
//            super.onCreateView(inflater, container, savedInstanceState)

        }

        binding.btnDarkMode.setOnClickListener {
//            Log.d("ThemeChange", "Theme to be set")
//            requireActivity().setTheme(R.style.Theme_SoybeanGyanDark)
//            Log.d("ThemeChange", "Theme setting")
//            requireActivity().recreate()
//            Log.d("ThemeChange", "Theme set")
//            setTheme(AppCompatDelegate.MODE_NIGHT_YES)
//              setTheme(R.style.Theme_SoybeanGyanDark)
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
//            setTheme(R.style.Theme_SoybeanGyanDark)
//            super.onCreateView(inflater, container, savedInstanceState)
        }


        // Set up font size spinner
        val fontSizeOptions = resources.getStringArray(R.array.font_size_options)
        val adapter = ArrayAdapter(requireContext(), android.R.layout.simple_spinner_item, fontSizeOptions)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        binding.fontSizeSpinner.adapter = adapter

        // Load current font size preference
        val sharedPrefs = requireActivity().getPreferences(Context.MODE_PRIVATE)
        currentFontSize = sharedPrefs.getString("font_size", "Medium") ?: "Medium"
        val position = fontSizeOptions.indexOf(currentFontSize)
        if (position != -1) {
            binding.fontSizeSpinner.setSelection(position)
        }

        // Handle font size selection
        binding.fontSizeSpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                val selectedFontSize = fontSizeOptions[position]
                applyFontSize(selectedFontSize)
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                // Do nothing
            }
        }

        binding.btnEng.setOnClickListener {
            setLocale("en")
        }

        binding.btnHin.setOnClickListener {
            setLocale("hi")
        }
//        Opening Important links


        return root
    }

    private fun setLocale(languageCode: String) {
        LocaleHelper.setLocale(requireContext(), languageCode)
        requireActivity().recreate() // Recreate activity to apply the new locale
    }

    private fun setTheme(mode: Int) {
        AppCompatDelegate.setDefaultNightMode(mode)
        requireActivity().recreate() // Recreate the activity to apply the new theme
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun applyFontSize(fontSize: String) {
        // Save the selected font size preference
        val sharedPrefs = requireActivity().getPreferences(Context.MODE_PRIVATE)
        with (sharedPrefs.edit()) {
            putString("font_size", fontSize)
            apply()
        }

        // Apply the selected font size to the app's text views
        @Suppress("DEPRECATION") val scaledDensity = resources.displayMetrics.scaledDensity
        val textSize = when (fontSize) {
            getString(R.string.small) -> scaledDensity * 8 // adjust the values as needed 12
            getString(R.string.medium) -> scaledDensity * 12
            getString(R.string.large) -> scaledDensity * 16  // default to medium size 20
            else -> scaledDensity * 12 // default to medium size
        }

        binding.fontSizeLabel.textSize = textSize

        // Apply the font size to other TextViews in your app similarly
    }

}
