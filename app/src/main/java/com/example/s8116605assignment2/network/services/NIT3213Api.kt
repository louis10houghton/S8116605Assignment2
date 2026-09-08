package com.example.s8116605assignment2.network.services

import com.example.s8116605assignment2.network.model.LoginRequest
import com.example.s8116605assignment2.network.model.LoginResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface Nit3213Api {
    @POST("footscray/auth")
    suspend fun login(@Body request: LoginRequest): Response<LoginResponse>
}