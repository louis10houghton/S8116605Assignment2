package com.example.s8116605assignment2.network.data

import com.example.s8116605assignment2.network.model.LoginRequest
import com.example.s8116605assignment2.network.services.Nit3213Api

class AuthRepository(private val api: Nit3213Api) {
    suspend fun login(username: String, password: String) =
        api.login(LoginRequest(username, password))
}