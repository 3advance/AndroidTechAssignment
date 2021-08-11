package com.threeadvance.android.app

import android.app.Application
import com.threeadvance.android.di.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class AndroidApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@AndroidApplication)
            modules(listOf(appModule))
        }
    }
}