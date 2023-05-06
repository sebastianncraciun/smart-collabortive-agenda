package com.example.smartagenda.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.smartagenda.R
import com.example.smartagenda.databinding.ActivityFirstBinding
import com.example.smartagenda.databinding.ActivityRobotBinding

class RobotActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRobotBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRobotBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbarRobot)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title="My AI Assistant"
        binding.toolbarRobot.setNavigationOnClickListener {
            onBackPressedDispatcher.onBackPressed()
        }

    }
}