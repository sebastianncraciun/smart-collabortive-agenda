package com.example.smartagenda.activities

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.smartagenda.R
import com.example.smartagenda.databinding.ActivityTasksBinding

class TasksActivity : AppCompatActivity() {

    private lateinit var binding: ActivityTasksBinding

    private val rotateOpen: Animation by lazy {AnimationUtils.loadAnimation(this, R.anim.rotate_open_anim)}
    private val rotateClose: Animation by lazy {AnimationUtils.loadAnimation(this, R.anim.rotate_close_anim)}
    private val fromBottom: Animation by lazy {AnimationUtils.loadAnimation(this, R.anim.from_bottom_anim)}
    private val toBottom: Animation by lazy {AnimationUtils.loadAnimation(this, R.anim.to_bottom_anim)}

    private var clicked = false

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

        binding.addBtn.setOnClickListener {
            onAddButtonClicked()
        }
        binding.addCollaborativeTaskBtn.setOnClickListener {

        }
        binding.addPersonalTaskBtn.setOnClickListener {

        }
        binding.collaborativeTasksTv.setOnClickListener {
            val intent2 = Intent(this@TasksActivity,CollaborativeTasksActivity::class.java)
            startActivity(intent2)
        }
        binding.personalTasksTv.setOnClickListener {
            val intent2 = Intent(this@TasksActivity,PersonalTasksActivity::class.java)
            startActivity(intent2)
        }

    }

    private fun onAddButtonClicked(){
        setVisibility(clicked)
        setAnimation(clicked)
        setClickable(clicked)
        clicked = !clicked
    }

    private fun setVisibility(clicked: Boolean){
        if(!clicked){
            binding.addCollaborativeTaskBtn.visibility = View.VISIBLE
            binding.addPersonalTaskBtn.visibility = View.VISIBLE
        }else{
            binding.addCollaborativeTaskBtn.visibility = View.INVISIBLE
            binding.addPersonalTaskBtn.visibility = View.INVISIBLE
        }
    }

    private fun setAnimation(clicked: Boolean){
        if(!clicked){
            binding.addCollaborativeTaskBtn.startAnimation(fromBottom)
            binding.addPersonalTaskBtn.startAnimation(fromBottom)
            binding.addBtn.startAnimation(rotateOpen)
        }else{
            binding.addCollaborativeTaskBtn.startAnimation(toBottom)
            binding.addPersonalTaskBtn.startAnimation(toBottom)
            binding.addBtn.startAnimation(rotateClose)
        }
    }

    private fun setClickable(clicked: Boolean){
        if(!clicked){
            binding.addCollaborativeTaskBtn.isClickable = true
            binding.addPersonalTaskBtn.isClickable = true
        }else{
            binding.addCollaborativeTaskBtn.isClickable = false
            binding.addPersonalTaskBtn.isClickable = false
        }
    }
}