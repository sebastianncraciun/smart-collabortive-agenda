package com.example.smartagenda.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.smartagenda.R
import com.example.smartagenda.databinding.ActivityPersonalTasksBinding
import com.example.smartagenda.databinding.ActivityTasksBinding

class PersonalTasksActivity : AppCompatActivity() {

    private lateinit var binding: ActivityPersonalTasksBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPersonalTasksBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbarTasks)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title="Personal Tasks"
        binding.toolbarTasks.setNavigationOnClickListener {
            onBackPressedDispatcher.onBackPressed()
        }

    }
}