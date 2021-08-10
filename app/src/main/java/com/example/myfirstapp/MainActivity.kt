package com.example.myfirstapp

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.*
import java.util.*
import com.github.terrakok.cicerone.Command
import com.github.terrakok.cicerone.Navigator
import com.github.terrakok.cicerone.androidx.AppNavigator
import com.github.terrakok.cicerone.androidx.FragmentScreen


const val EXTRA_MESSAGE = "com.example.myfirstapp.MESSAGE"
const val TOTAL_COUNT = "com.example.myfirstapp.TOTAL_COUNT"


class MainActivity() : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (supportFragmentManager.fragments.isEmpty()) {
            MyApplication.INSTANCE.getRouter().newRootScreen(Screens.ExScreen())
        }
    }


    fun addNewFragment() {
        supportFragmentManager.commit {
            replace<ExFragment>(R.id.exampleFragment)
            addToBackStack(null)
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

    fun sendMessageFragment(view: View) {

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


    private val navigator = AppNavigator(this, R.id.exampleFragment)

    override fun onPause() {
        super.onPause()
        MyApplication.INSTANCE.getNavigatorHolder()?.removeNavigator()
    }

    override fun onResumeFragments() {
        super.onResumeFragments()
        MyApplication.INSTANCE.getNavigatorHolder()?.setNavigator(navigator)
    }

}