package com.example.s8116605assignment2.ui.dashboard

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope

import com.example.s8116605assignment2.network.model.Entity
import com.example.s8116605assignment2.network.data.DashboardRepository
import kotlinx.coroutines.launch

class DashboardViewModel(
    private val repository: DashboardRepository
) : ViewModel() {
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