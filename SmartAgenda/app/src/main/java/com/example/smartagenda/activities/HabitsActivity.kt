package com.example.smartagenda.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.smartagenda.HabitsViewModel
import com.example.smartagenda.HabitsViewModelFactory
import com.example.smartagenda.databinding.ActivityHabitsBinding
import com.example.smartagenda.model.UserId
import com.example.smartagenda.repository.Repository

class HabitsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHabitsBinding
    private lateinit var viewModel: HabitsViewModel

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

        val repository = Repository()
        val viewModelFactory = HabitsViewModelFactory(repository)
        viewModel = ViewModelProvider(this, viewModelFactory).get(HabitsViewModel::class.java)
        val userId = UserId("craciunnicolae20@stud.ase.ro")
        viewModel.getHabits(userId)
        viewModel.myResponse.observe(this, Observer { response ->
            if(response.isSuccessful){
                binding.textView.text = response.body()?.message!!.joinToString("\n")
            }else{
                binding.textView.text = response.code().toString()
            }

        })
    }
}