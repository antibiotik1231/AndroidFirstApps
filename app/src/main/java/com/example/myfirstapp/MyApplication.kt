package com.example.myfirstapp

import com.github.terrakok.cicerone.Router
import com.github.terrakok.cicerone.NavigatorHolder
import com.github.terrakok.cicerone.Cicerone
import android.app.Application
import com.github.terrakok.cicerone.androidx.FragmentScreen

class MyApplication : Application() {
    companion object {
        internal lateinit var INSTANCE: MyApplication
            private set
    }

    private val cicerone: Cicerone<Router> = Cicerone.create()

    override fun onCreate() {
        super.onCreate()
        INSTANCE = this
    }

    fun getNavigatorHolder(): NavigatorHolder {
        return cicerone!!.getNavigatorHolder()
    }

    fun getRouter(): Router {
        return cicerone!!.router
    }
}