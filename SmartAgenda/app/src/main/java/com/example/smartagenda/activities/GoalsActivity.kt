package com.example.smartagenda.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.smartagenda.databinding.ActivityGoalsBinding

class GoalsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityGoalsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGoalsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbarGoals)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title="Goals"
        binding.toolbarGoals.setNavigationOnClickListener {
            onBackPressedDispatcher.onBackPressed()
        }


    }
}