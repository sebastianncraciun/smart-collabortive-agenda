package com.example.smartagenda

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.smartagenda.model.Habit
import com.example.smartagenda.model.Message
import com.example.smartagenda.model.UserId
import com.example.smartagenda.repository.Repository
import kotlinx.coroutines.launch
import retrofit2.Response

class AddHabitViewModel(private val repository: Repository): ViewModel() {

    val myResponse: MutableLiveData<Response<Message>> = MutableLiveData()

    fun postHabit(userId: UserId, habit: Habit){
        viewModelScope.launch {
            val response = repository.postHabit(userId, habit)
            myResponse.value = response
        }
    }
}