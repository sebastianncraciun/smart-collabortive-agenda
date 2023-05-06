package com.example.smartagenda.activities

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.smartagenda.R
import com.example.smartagenda.databinding.ActivityFirstBinding
import java.text.SimpleDateFormat
import java.util.*

class FirstActivity : AppCompatActivity() {

    private lateinit var binding: ActivityFirstBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFirstBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar.toolbar)
        supportActionBar?.title = ""


        binding.goals.setOnClickListener {
            val intent = Intent(this@FirstActivity, GoalsActivity::class.java)
            startActivity(intent)
        }

        binding.habits.setOnClickListener {
            val intent = Intent(this@FirstActivity, HabitsActivity::class.java)
            startActivity(intent)
        }

        binding.tasks.setOnClickListener {
            val intent = Intent(this@FirstActivity, TasksActivity::class.java)
            startActivity(intent)
        }

        binding.robot.setOnClickListener {
            val intent = Intent(this@FirstActivity, RobotActivity::class.java)
            startActivity(intent)
        }

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.nav_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.miMyProfile -> {
                val intent = Intent(this@FirstActivity, MyProfileActivity::class.java)
                startActivity(intent)
                return true
            }
            R.id.miNotifications -> {
                Toast.makeText(this, "You clicked on Notifications.", Toast.LENGTH_SHORT).show()
                return true
            }
            R.id.miCalendar -> {
                Toast.makeText(this, "You clicked on Calendar.", Toast.LENGTH_SHORT).show()
                return true
            }
            R.id.miSearch -> {
                Toast.makeText(this, "You clicked on Search.", Toast.LENGTH_SHORT).show()
                return true
            }
            R.id.miShare -> {
                Toast.makeText(this, "You clicked on Share.", Toast.LENGTH_SHORT).show()
                return true
            }
            R.id.miSettings -> {
                Toast.makeText(this, "You clicked on Settings.", Toast.LENGTH_SHORT).show()
                return true
            }
            R.id.miClose -> {
                finish()
                return true
            }else -> return super.onOptionsItemSelected(item)
        }
    }

    fun clickDatePicker() {
        val myCalendar = Calendar.getInstance()
        val year = myCalendar.get(Calendar.YEAR)
        val month = myCalendar.get(Calendar.MONTH)
        val day = myCalendar.get(Calendar.DAY_OF_MONTH)

        val sdf = SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH)


    }
}