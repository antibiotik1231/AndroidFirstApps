package com.example.myfirstapp

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.core.os.bundleOf
import androidx.fragment.app.*
import com.example.myfirstapp.di.getAppComponent
import com.github.terrakok.cicerone.NavigatorHolder
import com.github.terrakok.cicerone.Router
import javax.inject.Inject

class DisplayMessageActivity : AppCompatActivity() {
    companion object {
        private const val EXTRA_MESSAGE2 = "com.example.myfirstapp.MESSAGE2"
        fun getIntent(packageContext: Context, message: String): Intent {
            return Intent(packageContext, DisplayMessageActivity::class.java).apply {
                putExtra(EXTRA_MESSAGE2, message)
            }
        }
    }

    @Inject
    lateinit var navigatorHolder: NavigatorHolder

    @Inject
    lateinit var router: Router

    override fun onCreate(savedInstanceState: Bundle?) {
        getAppComponent().inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_display_message)
        val textView = findViewById<TextView>(R.id.textView).apply {
            text = intent.getStringExtra(EXTRA_MESSAGE2)
        }
    }
}