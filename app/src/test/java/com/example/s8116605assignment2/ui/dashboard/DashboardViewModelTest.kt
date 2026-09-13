package com.example.s8116605assignment2.ui.dashboard

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.s8116605assignment2.network.data.DashboardRepository
import com.example.s8116605assignment2.network.model.DashboardResponse
import com.example.s8116605assignment2.network.model.Entity
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
class DashboardViewModelTest {

    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    private lateinit var viewModel: DashboardViewModel
    private lateinit var repository: DashboardRepository
    private val testDispatcher = StandardTestDispatcher()

    @Before
    fun setUp() {
        repository = mockk()
        Dispatchers.setMain(testDispatcher)
        viewModel = DashboardViewModel(repository)
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
    }

    @Test
    fun `loadDashboard posts entities on success`() = runTest(testDispatcher) {
        // Given
        val entity = Entity(
            technique = "Daguerreotype",
            equipment = "Camera obscura",
            subject = "Portrait",
            pioneeringPhotographer = "Louis Daguerre",
            yearIntroduced = 1839,
            description = "An early photographic process."
        )
        coEvery { repository.getDashboard("photography") } returns
                Response.success(DashboardResponse(entities = listOf(entity), entityTotal = 1))

        // When
        viewModel.loadDashboard("photography")
        advanceUntilIdle()

        // Then
        assertEquals(1, viewModel.entities.value?.size)
        assertEquals("Daguerreotype", viewModel.entities.value?.get(0)?.technique)
    }
}