package com.example.smartagenda.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.smartagenda.HabitsViewModel
import com.example.smartagenda.HabitsViewModelFactory
import com.example.smartagenda.R
import com.example.smartagenda.adapter.HabitsAdapter
import com.example.smartagenda.databinding.ActivityHabitsBinding
import com.example.smartagenda.model.UserId
import com.example.smartagenda.repository.Repository
import com.google.firebase.auth.FirebaseAuth

class HabitsActivity : AppCompatActivity(),HabitsAdapter.OnHabitsClickListener {

    private lateinit var binding: ActivityHabitsBinding
    private lateinit var viewModel: HabitsViewModel
    private lateinit var habitsAdapter: HabitsAdapter

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

        setupRecyclerview()

        val repository = Repository()
        val viewModelFactory = HabitsViewModelFactory(repository)
        viewModel = ViewModelProvider(this, viewModelFactory).get(HabitsViewModel::class.java)
        val userId = UserId(intent.getStringExtra("email").toString())
        viewModel.getHabits(userId)
        viewModel.myResponse.observe(this, Observer { response ->
            if(response.isSuccessful) {
                Log.d("test", response.body().toString())
                response.body()?.let { habitsAdapter.setData(it) }
            }else{
                Toast.makeText(this, response.code(), Toast.LENGTH_SHORT).show()
            }
        })
//        viewModel.myResponse.observe(this, Observer { response ->
//            if(response.isSuccessful){
//                binding.textView.text = response.body()?.message!!.joinToString("\n")
//            }else{
//                binding.textView.text = response.code().toString()
//            }
//
//        })
        binding.btnAdd.setOnClickListener {
            val intent = Intent(this,AddHabitActivity::class.java)
            startActivity(intent)
        }
    }

    private fun setupRecyclerview(){
        habitsAdapter = HabitsAdapter(this)
        //binding.habitsRecyclerView.adapter = habitsAdapter
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        binding.recyclerView.adapter = habitsAdapter
    }

    override fun onItemDelete(id: String) {
       // viewModel.deleteHabit()
    }
}