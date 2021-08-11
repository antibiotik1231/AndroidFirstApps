package com.example.myfirstapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.myfirstapp.di.getAppComponent
import com.github.terrakok.cicerone.NavigatorHolder
import com.github.terrakok.cicerone.Router
import com.github.terrakok.cicerone.androidx.AppNavigator
import javax.inject.Inject


const val EXTRA_MESSAGE = "com.example.myfirstapp.MESSAGE"
const val TOTAL_COUNT = "com.example.myfirstapp.TOTAL_COUNT"


class MainActivity() : AppCompatActivity() {
    @Inject
    lateinit var navigatorHolder: NavigatorHolder
    @Inject
    lateinit var router: Router
    private val navigator = AppNavigator(this, R.id.exampleFragment)
    override fun onCreate(savedInstanceState: Bundle?) {
        getAppComponent().inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (supportFragmentManager.fragments.isEmpty()) {
            router.newRootScreen(Screens.ExScreen(0))
        }
    }

    override fun onResumeFragments() {
        super.onResumeFragments()
        navigatorHolder.setNavigator(navigator)
    }

    override fun onPause() {
        super.onPause()
        navigatorHolder.removeNavigator()
    }

    fun getChain(): String {
        var chain = ""
        supportFragmentManager.fragments.forEach {
            val number = it.arguments?.getInt(ExFragment.ARG_NUMBER)
            chain += "-> $number "
        }
        return chain
    }
}