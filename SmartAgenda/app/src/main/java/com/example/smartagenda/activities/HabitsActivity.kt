package com.example.smartagenda.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.smartagenda.databinding.ActivityHabitsBinding

class HabitsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHabitsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHabitsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbarHabits)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title="Habits"
        binding.toolbarHabits.setNavigationOnClickListener {
            onBackPressedDispatcher.onBackPressed()
        }
    }
}