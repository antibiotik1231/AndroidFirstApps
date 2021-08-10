package com.example.myfirstapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import java.util.*

class RandomNumberActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_random_number)
        val message = intent.getStringExtra(TOTAL_COUNT)
        var random = Random()
        var messageInt = message?.toInt()?.let { random.nextInt(it) }
        val textView = findViewById<TextView>(R.id.randomNumberText).apply {
            text = messageInt.toString()
        }


        val labelView = findViewById<TextView>(R.id.randomNumber).apply {
            text = "Случайное число между 0 и $message"
        }
    }
}

