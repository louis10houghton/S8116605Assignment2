package com.example.s8116605assignment2.di
import com.example.s8116605assignment2.network.data.AuthRepository
import com.example.s8116605assignment2.network.data.DashboardRepository
import com.example.s8116605assignment2.network.services.Nit3213Api
import com.example.s8116605assignment2.network.utilities.RetrofitUtility
import com.example.s8116605assignment2.ui.dashboard.DashboardViewModel
import com.example.s8116605assignment2.ui.login.LoginViewModel
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module
import org.koin.core.scope.get

val appModule = module {
    // the API (interface)
    single<Nit3213Api> {
        RetrofitUtility.createRetrofit("https://nit3213apinew.onrender.com/")
            .create(Nit3213Api::class.java)
    }
    // repositories — get() pulls the Nit3213Api from above
    single { AuthRepository(get()) }
    single { DashboardRepository(get()) }
    // viewmodels — get() pulls the repository
    viewModel { LoginViewModel(get()) }
    viewModel { DashboardViewModel(get()) }
}