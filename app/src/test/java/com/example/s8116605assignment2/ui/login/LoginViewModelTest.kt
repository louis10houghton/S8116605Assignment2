package com.example.s8116605assignment2.ui.login

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.s8116605assignment2.network.data.AuthRepository
import com.example.s8116605assignment2.network.model.LoginResponse
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.advanceUntilIdle
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import retrofit2.Response

@OptIn(ExperimentalCoroutinesApi::class)
class LoginViewModelTest {

    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    private lateinit var viewModel: LoginViewModel
    private lateinit var authRepository: AuthRepository
    private val testDispatcher = StandardTestDispatcher()

    @Before
    fun setUp() {
        authRepository = mockk()
        Dispatchers.setMain(testDispatcher)
        viewModel = LoginViewModel(authRepository)
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
    }

    @Test
    fun `login with valid credentials posts success with keypass`() = runTest(testDispatcher) {
        // Given
        coEvery { authRepository.login("8116605", "Louis") } returns
                Response.success(LoginResponse(keypass = "photography"))

        // When
        viewModel.login("8116605", "Louis")
        advanceUntilIdle()

        // Then
        assertEquals("photography", viewModel.loginResult.value?.success?.keypass)
    }
}