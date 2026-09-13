package com.example.s8116605assignment2

import android.app.Application
import com.example.s8116605assignment2.di.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class S8116605Application : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@S8116605Application)
            modules(appModule)
        }
    }
}