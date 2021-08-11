package com.example.myfirstapp

import android.app.Application
import com.example.myfirstapp.di.AppComponent
import com.example.myfirstapp.di.DaggerAppComponent

class MyApplication : Application() {

    lateinit var appComponent: AppComponent
        private set

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.create()
    }
}
