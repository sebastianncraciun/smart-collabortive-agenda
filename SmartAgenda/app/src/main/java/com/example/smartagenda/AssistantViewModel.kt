package com.example.smartagenda

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.smartagenda.model.Message
import com.example.smartagenda.model.Question
import com.example.smartagenda.repository.Repository
import kotlinx.coroutines.launch
import retrofit2.Response

class AssistantViewModel(private val repository: Repository): ViewModel() {

    val myResponse: MutableLiveData<Response<Message>> = MutableLiveData()

    fun sendMessage(question: Question){
        viewModelScope.launch {
            val response = repository.askAssistant(question)
            myResponse.value = response
        }
    }
}