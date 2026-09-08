package com.example.s8116605assignment2.ui.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.s8116605assignment2.network.data.AuthRepository
import com.example.s8116605assignment2.network.services.Nit3213Api
import com.example.s8116605assignment2.network.utilities.RetrofitUtility

class LoginViewModelFactory : ViewModelProvider.Factory {

    private val baseUrl = "https://nit3213apinew.onrender.com/"

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(LoginViewModel::class.java)) {
            val api = RetrofitUtility.createRetrofit(baseUrl).create(Nit3213Api::class.java)
            return LoginViewModel(AuthRepository(api)) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}