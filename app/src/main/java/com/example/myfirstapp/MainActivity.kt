package com.example.myfirstapp

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.add
import androidx.fragment.app.commit
import java.util.*


const val EXTRA_MESSAGE = "com.example.myfirstapp.MESSAGE"
const val TOTAL_COUNT = "com.example.myfirstapp.TOTAL_COUNT"


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (savedInstanceState == null) {
            addNewFragment()
        }
    }


    fun addNewFragment() {
        Toast.makeText(this, "asdasd", Toast.LENGTH_SHORT).show()
        supportFragmentManager.commit {
            add<ExFragment>(R.id.exampleFragment, UUID.randomUUID().toString())
        }
    }

    fun removeFragment() {
        supportFragmentManager.commit {
            remove(supportFragmentManager.fragments.last())
        }
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