package com.example.myfirstapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast
import android.widget.TextView
import kotlin.random.Random


const val EXTRA_MESSAGE = "com.example.myfirstapp.MESSAGE"
const val TOTAL_COUNT = "com.example.myfirstapp.TOTAL_COUNT"


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun sendMessage(view: View) {
        val editText = findViewById<EditText>(R.id.editTextTextPersonName)
        val message = editText.text.toString()
        val intent = Intent(this, DisplayMessageActivity::class.java).apply {
            putExtra(EXTRA_MESSAGE, message)
        }
        startActivity(intent)
    }

    fun toastMe(view: View) {
        val MyToast = Toast.makeText(this, "Hello!", Toast.LENGTH_LONG)
        MyToast.show()
    }

    fun counterMe(view: View) {
        val textView = findViewById<TextView>(R.id.textView2)
        var number = Integer.parseInt(textView.text.toString())
        number++
        val newTextView = findViewById<TextView>(R.id.textView2).apply {
            text = number.toString()
        }
    }

    fun randomMe(view: View) {
        val random_intent = Intent(this, RandomNumberActivity::class.java)
        val countState = findViewById<TextView>(R.id.textView2).text.toString()
        random_intent.putExtra(TOTAL_COUNT, countState)
        startActivity(random_intent)
    }
}