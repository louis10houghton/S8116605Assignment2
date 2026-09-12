package com.example.s8116605assignment2.network.data
import com.example.s8116605assignment2.network.services.Nit3213Api

class DashboardRepository(private val api: Nit3213Api) {
    suspend fun getDashboard(keypass: String) = api.getDashboard(keypass)
}