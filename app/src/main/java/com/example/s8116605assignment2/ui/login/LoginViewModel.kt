package com.example.s8116605assignment2.ui.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.s8116605assignment2.R
import com.example.s8116605assignment2.network.data.AuthRepository
import kotlinx.coroutines.launch

class LoginViewModel(private val authRepository: AuthRepository) : ViewModel() {

    private val _loginForm = MutableLiveData<LoginFormState>()
    val loginFormState: LiveData<LoginFormState> = _loginForm

    private val _loginResult = MutableLiveData<LoginResult>()
    val loginResult: LiveData<LoginResult> = _loginResult

    fun login(username: String, password: String) {
        viewModelScope.launch {
            try {
                val response = authRepository.login(username, password)
                val body = response.body()
                if (response.isSuccessful && body != null) {
                    _loginResult.value = LoginResult(success = LoggedInUserView(keypass = body.keypass))
                } else {
                    _loginResult.value = LoginResult(error = R.string.login_failed)
                }
            } catch (e: Exception) {
                _loginResult.value = LoginResult(error = R.string.login_failed)
            }
        }
    }

    fun loginDataChanged(username: String, password: String) {
        if (!isUserNameValid(username)) {
            _loginForm.value = LoginFormState(usernameError = R.string.invalid_username)
        } else if (!isPasswordValid(password)) {
            _loginForm.value = LoginFormState(passwordError = R.string.invalid_password)
        } else {
            _loginForm.value = LoginFormState(isDataValid = true)
        }
    }

    private fun isUserNameValid(username: String): Boolean = username.isNotBlank()
    private fun isPasswordValid(password: String): Boolean = password.isNotBlank()
}