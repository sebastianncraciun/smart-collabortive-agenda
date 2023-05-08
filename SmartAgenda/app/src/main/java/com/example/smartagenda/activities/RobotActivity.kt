package com.example.smartagenda.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.smartagenda.AssistantViewModel
import com.example.smartagenda.AssistantViewModelFactory
import com.example.smartagenda.R
import com.example.smartagenda.databinding.ActivityFirstBinding
import com.example.smartagenda.databinding.ActivityRobotBinding
import com.example.smartagenda.model.Question
import com.example.smartagenda.repository.Repository

class RobotActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRobotBinding
    private lateinit var viewModel: AssistantViewModel

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

        val repository = Repository()
        val viewModelFactory = AssistantViewModelFactory(repository)
        viewModel = ViewModelProvider(this, viewModelFactory).get(AssistantViewModel::class.java)
        val question = Question("How to wake up early?")
        viewModel.sendMessage(question)
        viewModel.myResponse.observe(this, Observer { response ->
            if(response.isSuccessful){
                binding.textView2.text = response.body()?.message
            }else{
                binding.textView2.text = response.code().toString()
            }
        })

    }
}