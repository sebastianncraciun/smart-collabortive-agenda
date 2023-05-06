package com.example.smartagenda.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.smartagenda.databinding.ActivityMyProfileBinding

class MyProfileActivity : AppCompatActivity() {

    private lateinit var binding:ActivityMyProfileBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMyProfileBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbarMyProfile)
        supportActionBar?.title=""
    }
}