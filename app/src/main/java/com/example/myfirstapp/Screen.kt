package com.example.myfirstapp

import android.content.Intent
import com.github.terrakok.cicerone.androidx.ActivityScreen
import com.github.terrakok.cicerone.androidx.FragmentScreen

object Screens {
    fun ExScreen() = FragmentScreen { ExFragment() }
}