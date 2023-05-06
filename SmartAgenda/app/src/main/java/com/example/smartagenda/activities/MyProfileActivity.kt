package com.example.smartagenda.activities

import android.Manifest
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.example.smartagenda.R
import com.example.smartagenda.databinding.ActivityMyProfileBinding
import model.User
import utils.Constants


class MyProfileActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMyProfileBinding

    // Add a global variable for URI of a selected image from phone storage.
    private var mSelectedImageFileUri: Uri? = null

    // A global variable for user details.
    private lateinit var mUserDetails: User

    // A global variable for a user profile image URL
    private var mProfileImageURL: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMyProfileBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbarMyProfile)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = "My Profile"
        binding.toolbarMyProfile.setNavigationOnClickListener {
            onBackPressedDispatcher.onBackPressed()
        }

        binding.ivProfileUserImage.setOnClickListener {

            if (ContextCompat.checkSelfPermission(
                    this,
                    Manifest.permission.READ_EXTERNAL_STORAGE
                ) == PackageManager.PERMISSION_GRANTED
            ) {
                Constants.showImageChooser(this@MyProfileActivity)
            } else {
                ActivityCompat.requestPermissions(
                    this,
                    arrayOf(Manifest.permission.READ_EXTERNAL_STORAGE),
                    Constants.READ_STORAGE_PERMISSION_CODE
                )
            }
        }

//        binding.btnUpdate.setOnClickListener {
//            // if the image is not selected then update the other details of the user
//            if (mSelectedImageFileUri != null) {
//                uploadUserImage()
//            } else {
//                showProgressDialog(getString(R.string.pleaseWait))
//
//                // Call a function to update user details in the database
//                updateUserProfileData()
//            }
//        }
    }

//    private fun uploadUserImage() {
//        showProgressDialog(getString(R.string.pleaseWait))
//
//        if(mSelectedImageFileUri != null){
//            // getting the storage reference
//            val sRef: StorageReference =
//        }
//    }
}