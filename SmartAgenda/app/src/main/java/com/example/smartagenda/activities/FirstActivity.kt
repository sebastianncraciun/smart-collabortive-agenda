package com.example.smartagenda.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Spannable
import android.text.SpannableString
import android.text.style.ForegroundColorSpan
import com.example.smartagenda.R
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.core.content.ContextCompat
import com.example.smartagenda.databinding.ActivityFirstBinding
import java.text.SimpleDateFormat
import java.util.*

class FirstActivity : AppCompatActivity() {

    private lateinit var binding: ActivityFirstBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFirstBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)
        supportActionBar?.title=""


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

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.nav_menu, menu)

        // Iterate through the menu items and apply color black
        for(i in 0 until menu?.size()!!){
            val menuItem = menu?.getItem(i)
            val spannableString = SpannableString(menuItem?.title)
            spannableString.setSpan(ForegroundColorSpan(ContextCompat.getColor(this, R.color.black)), 0, spannableString.length, Spannable.SPAN_INCLUSIVE_INCLUSIVE)
            menuItem?.title = spannableString
        }
        return super.onCreateOptionsMenu(menu)
    }

    fun onMenuItemClicked(view: View){
        when (view.id){
            R.id.miMyProfile -> {
                val intent = Intent(this@FirstActivity, MyProfileActivity::class.java)
                startActivity(intent)
            }
            R.id.miNotifications -> Toast.makeText(this, "You clicked on Notifications.", Toast.LENGTH_SHORT).show()
            R.id.miCalendar -> Toast.makeText(this, "You clicked on Calendar.", Toast.LENGTH_SHORT).show()
            R.id.miSearch -> Toast.makeText(this, "You clicked on Search.", Toast.LENGTH_SHORT).show()
            R.id.miSettings -> Toast.makeText(this, "You clicked on Settings.", Toast.LENGTH_SHORT).show()
            R.id.miClose -> finish()
        }
    }



    fun clickDatePicker(){
        val myCalendar = Calendar.getInstance()
        val year = myCalendar.get(Calendar.YEAR)
        val month = myCalendar.get(Calendar.MONTH)
        val day = myCalendar.get(Calendar.DAY_OF_MONTH)

        val sdf = SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH)


    }
}