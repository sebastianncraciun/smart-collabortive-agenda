package com.example.smartagenda

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.smartagenda.model.*
import com.example.smartagenda.repository.Repository
import kotlinx.coroutines.launch
import retrofit2.Response

class AddHabitViewModel(private val repository: Repository): ViewModel() {

    val myResponse: MutableLiveData<Response<Message>> = MutableLiveData()

    fun postHabit(userId: UserId, habit: Habit){
        viewModelScope.launch {
            val postHabit = PostHabitRequest(userId, habit)
            val response = repository.postHabit(postHabit)
            myResponse.value = response
        }
    }
}