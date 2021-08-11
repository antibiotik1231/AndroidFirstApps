package com.example.myfirstapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import java.util.*

class RandomNumberActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_random_number)
        val message = intent.getStringExtra(EXTRA_MESSAGE3)
        val num = intent.getStringExtra(EXTRA_MESSAGE4)
        val textView = findViewById<TextView>(R.id.randomNumberText).apply {
            text = message
        }
        val labelView = findViewById<TextView>(R.id.randomNumber).apply {
            text = "Случайное число между 0 и $num"
        }
    }
}

