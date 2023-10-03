package com.rdkn.piu_calc

import android.app.Application
import com.rdkn.piu_calc.common.*
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class App : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger()
            androidContext(this@App)
            modules(listOf(
                dbModule,
                vmModule
            ))
        }
    }
}