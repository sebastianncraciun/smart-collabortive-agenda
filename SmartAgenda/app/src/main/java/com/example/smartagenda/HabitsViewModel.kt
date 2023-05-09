package com.example.smartagenda

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.smartagenda.model.Habit
import com.example.smartagenda.model.UserId
import com.example.smartagenda.repository.Repository
import kotlinx.coroutines.launch
import retrofit2.Response

class HabitsViewModel(private val repository: Repository): ViewModel() {

    val myResponse: MutableLiveData<Response<Habit>> = MutableLiveData()

    fun getHabits(userId: UserId){
        viewModelScope.launch{
            val response = repository.getHabits(userId)
            myResponse.value = response
        }
    }

}