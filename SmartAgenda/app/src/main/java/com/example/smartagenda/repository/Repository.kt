package com.example.smartagenda.repository

import com.example.smartagenda.api.RetrofitInstance
import com.example.smartagenda.model.*
import com.google.gson.Gson
import retrofit2.Response

class Repository {

    suspend fun getHabits(userId: UserId): Response<List<Habit>> {
        return RetrofitInstance.api.getHabits(userId)
    }

    suspend fun askAssistant(question: Question): Response<Message>{
        return RetrofitInstance.apiAI.sendMessage(question)
    }

    suspend fun postHabit(request: PostHabitRequest): Response<Message>{
        return RetrofitInstance.api.postHabit(request)
    }

    suspend fun deleteHabit(request: DeleteHabitRequest): Response<Message>{
        return RetrofitInstance.api.deleteHabit(request)
    }

}