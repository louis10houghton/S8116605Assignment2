package com.example.s8116605assignment2.network.services

import com.example.s8116605assignment2.network.model.DashboardResponse
import com.example.s8116605assignment2.network.model.LoginRequest
import com.example.s8116605assignment2.network.model.LoginResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface Nit3213Api {
    @POST("footscray/auth")
    suspend fun login(@Body request: LoginRequest): Response<LoginResponse>

    @GET("dashboard/{keypass}")
    suspend fun getDashboard(@Path("keypass") keypass: String): Response<DashboardResponse>
}
