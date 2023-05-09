package com.example.smartagenda.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.smartagenda.R
import com.example.smartagenda.databinding.ActivityCollaborativeTasksBinding
import com.example.smartagenda.databinding.ActivityTasksBinding

class CollaborativeTasksActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCollaborativeTasksBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCollaborativeTasksBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbarTasks)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title="Collaborative Tasks"
        binding.toolbarTasks.setNavigationOnClickListener {
            onBackPressedDispatcher.onBackPressed()
        }

    }
}