package com.example.myfirstapp

import com.github.terrakok.cicerone.Router
import com.github.terrakok.cicerone.NavigatorHolder
import com.github.terrakok.cicerone.Cicerone
import android.app.Application

class MyApplication : Application() {
    companion object {
        internal lateinit var INSTANCE: MyApplication
            private set
    }
    private var cicerone: Cicerone<Router>? = null

    override fun onCreate() {
        super.onCreate()
        INSTANCE = this
        cicerone = Cicerone.create()
    }

    fun getNavigatorHolder(): NavigatorHolder? {
        return cicerone!!.getNavigatorHolder()
    }

    fun getRouter(): Router? {
        return cicerone!!.router
    }
}