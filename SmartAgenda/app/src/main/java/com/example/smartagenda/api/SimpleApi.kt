package com.example.smartagenda.api

import com.example.smartagenda.model.*
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
    suspend fun postHabit(@Body postHabitRequest: PostHabitRequest): Response<Message>

    @POST("sca-db-microservice/v1/deleteHabit")
    suspend fun deleteHabit(@Body request: DeleteHabitRequest):Response<Message>
}