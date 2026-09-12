package com.example.s8116605assignment2.ui.dashboard

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope

import com.example.s8116605assignment2.network.model.Entity
import com.example.s8116605assignment2.network.data.DashboardRepository
import com.example.s8116605assignment2.network.services.Nit3213Api
import com.example.s8116605assignment2.network.utilities.RetrofitUtility
import kotlinx.coroutines.launch

class DashboardViewModel : ViewModel() {

    private val repository = DashboardRepository(
        RetrofitUtility.createRetrofit("https://nit3213apinew.onrender.com/")
            .create(Nit3213Api::class.java)
    )

    private val _entities = MutableLiveData<List<Entity>>()
    val entities: LiveData<List<Entity>> = _entities

    private val _error = MutableLiveData<String?>()
    val error: LiveData<String?> = _error

    fun loadDashboard(keypass: String) {
        viewModelScope.launch {
            try {
                val response = repository.getDashboard(keypass)
                val body = response.body()
                if (response.isSuccessful && body != null) {
                    _entities.value = body.entities
                } else {
                    _error.value = "Failed to load dashboard (${response.code()})"
                }
            } catch (e: Exception) {
                _error.value = "Error: ${e.message}"
            }
        }
    }
}