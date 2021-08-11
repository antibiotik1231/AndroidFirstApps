package com.example.myfirstapp.di

import android.content.Context
import com.example.myfirstapp.MyApplication

fun Context.getAppComponent(): AppComponent {
    return (applicationContext as MyApplication).appComponent
}
