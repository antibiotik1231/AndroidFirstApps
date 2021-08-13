package com.example.myfirstapp.di

import com.example.myfirstapp.DisplayMessageActivity
import com.example.myfirstapp.ExFragment
import com.example.myfirstapp.MainActivity
import com.example.myfirstapp.RandomNumberActivity
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        NavigationModule::class,
        NetworkModule::class
    ]
)
interface AppComponent {
    fun inject(activity: MainActivity)

    fun inject(fragment: ExFragment)

    fun inject(activity: DisplayMessageActivity)

    fun inject(activity: RandomNumberActivity)
}
