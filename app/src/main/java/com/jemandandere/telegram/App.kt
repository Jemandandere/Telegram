package com.jemandandere.telegram

import android.app.Application
import androidx.navigation.NavController

class App: Application() {
    lateinit var navController: NavController

    companion object {
        @Volatile
        lateinit var instance: App
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
    }
}