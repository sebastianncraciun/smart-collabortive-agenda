package com.example.smartagenda

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.smartagenda.model.*
import com.example.smartagenda.repository.Repository
import kotlinx.coroutines.launch
import retrofit2.Response

class HabitsViewModel(private val repository: Repository): ViewModel() {

    val myResponse: MutableLiveData<Response<List<Habit>>> = MutableLiveData()
    val responseDelete: MutableLiveData<Response<Message>> = MutableLiveData()

    fun getHabits(userId: UserId){
        viewModelScope.launch{
            val response = repository.getHabits(userId)
            myResponse.value = response
        }
    }

    fun deleteHabit(userId: UserId, habitIndex: HabitIndex){
        viewModelScope.launch {
            val response = repository.deleteHabit(DeleteHabitRequest( userId,habitIndex))
            responseDelete.value = response
        }
    }

}