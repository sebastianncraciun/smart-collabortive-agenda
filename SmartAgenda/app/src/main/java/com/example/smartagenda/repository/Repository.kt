package com.example.smartagenda.repository

import com.example.smartagenda.api.RetrofitInstance
import com.example.smartagenda.model.Habit
import com.example.smartagenda.model.Message
import com.example.smartagenda.model.Question
import com.example.smartagenda.model.UserId
import com.google.gson.Gson
import retrofit2.Response

class Repository {

    suspend fun getHabits(userId: UserId): Response<List<Habit>> {
        return RetrofitInstance.api.getHabits(userId)
    }

    suspend fun askAssistant(question: Question): Response<Message>{
        return RetrofitInstance.apiAI.sendMessage(question)
    }

    suspend fun postHabit(userId: UserId, habit: Habit): Response<Message>{
        return RetrofitInstance.api.postHabit(userId,habit)
    }

}