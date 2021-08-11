package com.example.myfirstapp

import android.content.Intent
import com.github.terrakok.cicerone.androidx.ActivityScreen
import com.github.terrakok.cicerone.androidx.FragmentScreen

object Screens {
    fun ExScreen(number: Int) = FragmentScreen(clearContainer = false) { ExFragment.newInstance(number) }
    fun StartScreen(message: String) = ActivityScreen {
        DisplayMessageActivity.getIntent(it, message)
    }
    fun RandomScreen(message1: String, message2: String) = ActivityScreen {
        RandomNumberActivity.getIntent(it, message1, message2)
    }
}