package com.example.soybeangyan

import android.content.Intent
import android.content.pm.ActivityInfo
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.Build
import android.os.Bundle
import android.provider.MediaStore
import android.view.MenuItem
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import android.widget.Button
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.result.contract.ActivityResultContracts
import java.io.IOException

class DetectionMainActivity : AppCompatActivity() {
    private lateinit var mClassifier: DetectionClassifier
    private lateinit var mBitmap: Bitmap

    private val mInputSize = 224
    private val mModelPath = "plant_disease_model.tflite"
    private val mLabelPath = "detection_plant_labels.txt"
    private val mSamplePath = "detection_soybean.JPG"


    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = "Leaf Disease Detection"

        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
        setContentView(R.layout.detection_activity_main)
        mClassifier = DetectionClassifier(assets, mModelPath, mLabelPath, mInputSize)

        resources.assets.open(mSamplePath).use {
            mBitmap = BitmapFactory.decodeStream(it)
            mBitmap = Bitmap.createScaledBitmap(mBitmap, mInputSize, mInputSize, true)
            val mPhotoImageView = findViewById<ImageView>(R.id.mPhotoImageView)
            mPhotoImageView.setImageBitmap(mBitmap)
        }

        val takePictureLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            if (result.resultCode == RESULT_OK && result.data != null) {
                val data: Intent? = result.data
                @Suppress("DEPRECATION")
                mBitmap = data?.extras?.get("data") as Bitmap
                mBitmap = scaleImage(mBitmap)
                val mPhotoImageView = findViewById<ImageView>(R.id.mPhotoImageView)
                mPhotoImageView.setImageBitmap(mBitmap)
                val mResultTextView = findViewById<TextView>(R.id.mResultTextView)
                mResultTextView.text = "Your photo image set now."
            } else {
                showToast("Camera cancel..")
            }
        }

        val pickImageLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            if (result.resultCode == RESULT_OK && result.data != null) {
                val data: Intent? = result.data
                val uri = data?.data
                try {
                    uri?.let {
                        @Suppress("DEPRECATION")
                        mBitmap = MediaStore.Images.Media.getBitmap(this.contentResolver, it)
                        mBitmap = scaleImage(mBitmap)
                        val mPhotoImageView = findViewById<ImageView>(R.id.mPhotoImageView)
                        mPhotoImageView.setImageBitmap(mBitmap)
                    }
                } catch (e: IOException) {
                    e.printStackTrace()
                }
            }
        }

        val mCameraButton = findViewById<ImageButton>(R.id.mCameraButton)
        mCameraButton.setOnClickListener {
            val callCameraIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            takePictureLauncher.launch(callCameraIntent)
        }

        val mGalleryButton = findViewById<Button>(R.id.mGalleryButton)
        mGalleryButton.setOnClickListener {
            val callGalleryIntent = Intent(Intent.ACTION_PICK)
            callGalleryIntent.type = "image/*"
            pickImageLauncher.launch(callGalleryIntent)
        }
        mGalleryButton.setOnClickListener {
            val callGalleryIntent = Intent(Intent.ACTION_PICK)
            callGalleryIntent.type = "image/*"
            pickImageLauncher.launch(callGalleryIntent)
        }

        val mDetectButton = findViewById<ImageButton>(R.id.mDetectButton)
        mDetectButton.setOnClickListener {
//            val results = mClassifier.recognizeImage(mBitmap).firstOrNull()
//            val mResultTextView = findViewById<TextView>(R.id.mResultTextView)
//            mResultTextView.text= results?.title+"\n Confidence:"+results?.confidence
            val results = mClassifier.recognizeImage(mBitmap).firstOrNull()
            val mResultTextView = findViewById<TextView>(R.id.mResultTextView)
            val confidencePer = results?.confidence?.times(100) // Calculate confidence percentage
            mResultTextView.text = "${results?.title}\n Confidence: ${confidencePer?.toInt()}%"
        }
    }

//    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
//        if(requestCode == mCameraRequestCode){
//            //Considérons le cas de la caméra annulée
//            if(resultCode == RESULT_OK && data != null) {
//                mBitmap = data.extras!!.get("data") as Bitmap
//                mBitmap = scaleImage(mBitmap)
//                val toast = Toast.makeText(this, ("Image crop to: w= ${mBitmap.width} h= ${mBitmap.height}"), Toast.LENGTH_LONG)
//                toast.setGravity(Gravity.BOTTOM, 0, 20)
//                toast.show()
//                val mPhotoImageView = findViewById<ImageView>(R.id.mPhotoImageView)
//                mPhotoImageView.setImageBitmap(mBitmap)
//                val mResultTextView = findViewById<TextView>(R.id.mResultTextView)
//                mResultTextView.text= "Your photo image set now."
//            } else {
//                Toast.makeText(this, "Camera cancel..", Toast.LENGTH_LONG).show()
//            }
//        } else if(requestCode == mGalleryRequestCode) {
//            if (data != null) {
//                val uri = data.data
//
//                try {
//                    mBitmap = MediaStore.Images.Media.getBitmap(this.contentResolver, uri)
//                } catch (e: IOException) {
//                    e.printStackTrace()
//                }
//
//                println("Success!!!")
//                mBitmap = scaleImage(mBitmap)
//                val mPhotoImageView = findViewById<ImageView>(R.id.mPhotoImageView)
//                mPhotoImageView.setImageBitmap(mBitmap)
//
//            }
//        } else {
//            Toast.makeText(this, "Unrecognized request code", Toast.LENGTH_LONG).show()
//
//        }
//    }


    private fun scaleImage(bitmap: Bitmap?): Bitmap {
        val originalWidth = bitmap!!.width
        val originalHeight = bitmap.height
        val scaleWidth = mInputSize.toFloat() / originalWidth
        val scaleHeight = mInputSize.toFloat() / originalHeight
        val matrix = android.graphics.Matrix()
        matrix.postScale(scaleWidth, scaleHeight)
        return Bitmap.createBitmap(bitmap, 0, 0, originalWidth, originalHeight, matrix, true)
    }

    private fun showToast(message: String) {
        android.widget.Toast.makeText(this, message, android.widget.Toast.LENGTH_LONG).show()
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
