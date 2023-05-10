package com.example.smartagenda.api

import com.example.smartagenda.model.Habit
import com.example.smartagenda.model.Message
import com.example.smartagenda.model.Question
import com.example.smartagenda.model.UserId
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface SimpleApi {

    @POST("sca-db-microservice/v1/getHabits")
    suspend fun getHabits(@Body userId: UserId): Response<List<Habit>>

    @POST("sca-ai-assistant-microservice/v1/sendMessage")
    suspend fun sendMessage(@Body question: Question): Response<Message>

    @POST("sca-db-microservice/v1/postHabit")
    suspend fun postHabit(@Body userId: UserId, @Body habit: Habit): Response<Message>
}