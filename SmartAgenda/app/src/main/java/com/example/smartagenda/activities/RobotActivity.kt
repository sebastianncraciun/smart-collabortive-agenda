package com.example.smartagenda.activities

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.speech.RecognizerIntent
import android.speech.tts.TextToSpeech
import android.text.Editable
import android.text.method.ScrollingMovementMethod
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.smartagenda.AssistantViewModel
import com.example.smartagenda.AssistantViewModelFactory
import com.example.smartagenda.R
import com.example.smartagenda.databinding.ActivityFirstBinding
import com.example.smartagenda.databinding.ActivityRobotBinding
import com.example.smartagenda.model.Question
import com.example.smartagenda.repository.Repository
import java.util.*

class RobotActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRobotBinding
    private lateinit var viewModel: AssistantViewModel
    private lateinit var resultSpeech: CharSequence

    private val REQUEST_CODE_SPEECH_INOUT = 100

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

        binding.btnRecord.setOnClickListener {
            speak()
        }

        binding.textView2.setMovementMethod(ScrollingMovementMethod())
    }

    private fun speak() {
        val intent = Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH)
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, RecognizerIntent.LANGUAGE_MODEL_FREE_FORM)
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE, Locale.getDefault())
        intent.putExtra(RecognizerIntent.EXTRA_PROMPT, "Hi speak something")

        try{
            // if there is no error show Speech To Text dialog
            startActivityForResult(intent, REQUEST_CODE_SPEECH_INOUT)
        }catch(e:java.lang.Exception){
            // if there is any error get error message and show in toast
            //Toast.makeText(this, e.message, Toast.LENGTH_SHORT).show()
        }
    }
    // receive voice input
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        when(requestCode){
            REQUEST_CODE_SPEECH_INOUT -> {
                if(resultCode == Activity.RESULT_OK && null != data){
                    // get text from result
                    val result = data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS)
                    val speechText = result?.get(0) ?: ""
                    // set the text to textView
                    resultSpeech = Editable.Factory.getInstance().newEditable(speechText)
                    var question = Question(resultSpeech.toString())

                    val repository = Repository()
                    val viewModelFactory = AssistantViewModelFactory(repository)
                    viewModel = ViewModelProvider(this, viewModelFactory).get(AssistantViewModel::class.java)

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
        }
    }
}