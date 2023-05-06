package com.example.smartagenda.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.smartagenda.databinding.ActivityTasksBinding

class TasksActivity : AppCompatActivity() {

    private lateinit var binding: ActivityTasksBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTasksBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbarTasks)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title="Tasks"
        binding.toolbarTasks.setNavigationOnClickListener {
            onBackPressedDispatcher.onBackPressed()
        }
    }
}