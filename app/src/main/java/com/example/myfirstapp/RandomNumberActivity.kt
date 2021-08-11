package com.example.myfirstapp

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.example.myfirstapp.di.getAppComponent
import com.github.terrakok.cicerone.NavigatorHolder
import com.github.terrakok.cicerone.Router
import java.util.*
import javax.inject.Inject

class RandomNumberActivity : AppCompatActivity() {
    companion object {
        private const val EXTRA_MESSAGE3 = "com.example.myfirstapp.MESSAGE3"
        private const val EXTRA_MESSAGE4 = "com.example.myfirstapp.MESSAGE4"
        fun getIntent(packageContext: Context, message1: String, message2: String): Intent {
            return Intent(packageContext, RandomNumberActivity::class.java).apply {
                putExtra(EXTRA_MESSAGE3, message1)
                putExtra(EXTRA_MESSAGE4, message2)
            }
        }
    }

    @Inject
    lateinit var navigateHolder: NavigatorHolder

    @Inject
    lateinit var router: Router

    override fun onCreate(savedInstanceState: Bundle?) {
        getAppComponent().inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_random_number)
        val textView = findViewById<TextView>(R.id.randomNumberText).apply {
            text = intent.getStringExtra(EXTRA_MESSAGE3)
        }
        val labelView = findViewById<TextView>(R.id.randomNumber).apply {
            text = "Случайное число между 0 и ${intent.getStringExtra(EXTRA_MESSAGE4)}"
        }
    }
}

