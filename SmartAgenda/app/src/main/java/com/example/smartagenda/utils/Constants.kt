package com.example.smartagenda.utils

import android.app.Activity
import android.content.Intent
import android.provider.MediaStore

object Constants {

    // A unique code for asking the Read Storage Permission using this we will check and identify in the method onRequestPermissionsResult
    const val READ_STORAGE_PERMISSION_CODE = 1
    // A unique code of image selection from Phone Storage.
    const val PICK_IMAGE_REQUEST_CODE = 2

    const val BASE_URL = "http://192.168.1.251:3000"

    const val AI_BASE_URL = "http://192.168.1.251:8080"

    fun showImageChooser(activity: Activity){
        val galleryIntent = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
        activity.startActivityForResult(galleryIntent, PICK_IMAGE_REQUEST_CODE)
    }


}