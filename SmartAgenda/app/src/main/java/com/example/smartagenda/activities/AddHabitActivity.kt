package com.example.smartagenda.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.smartagenda.AddHabitViewModel
import com.example.smartagenda.AddHabitViewModelFactory
import com.example.smartagenda.databinding.ActivityAddHabitBinding
import com.example.smartagenda.model.Habit
import com.example.smartagenda.model.UserId
import com.example.smartagenda.repository.Repository
import com.google.firebase.auth.FirebaseAuth

class AddHabitActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAddHabitBinding
    private lateinit var viewModel: AddHabitViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddHabitBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbarHabits)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title="Add habit"
        binding.toolbarHabits.setNavigationOnClickListener {
            onBackPressedDispatcher.onBackPressed()
        }

        val repository = Repository()
        val viewModelFactory = AddHabitViewModelFactory(repository)
        viewModel = ViewModelProvider(this, viewModelFactory).get(AddHabitViewModel::class.java)

        binding.btnSave.setOnClickListener {
            if(binding.etHabit.text.isNotEmpty()) {
                val userId = UserId(FirebaseAuth.getInstance().currentUser?.email.toString())
                val habit = Habit(binding.etHabit.text.toString())
                viewModel.postHabit(userId, habit)
                        viewModel.myResponse.observe(this, Observer { response ->
            if(response.isSuccessful){
                finish()
            }else{
                Log.d("testez", response.code().toString())
            }

        })

            }
        }
    }
}