package com.example.myfirstapp

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import java.util.*

const val EXTRA_MESSAGE2 = "com.example.myfirstapp.MESSAGE2"
const val EXTRA_MESSAGE3 = "com.example.myfirstapp.MESSAGE3"
const val EXTRA_MESSAGE4 = "com.example.myfirstapp.MESSAGE4"
class ExFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View? = inflater.inflate(R.layout.example_fragment, container, false)
        return view
    }

    private fun createChain(number: Int?): String {
        var chain = "[0]"
        val n : Int = number!!.toInt()
        for (i in 0 until n) {
            chain += "➔" + (i + 1)
        }
        return chain
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(view.findViewById<TextView>(R.id.textView3)) {
            //text = activity?.supportFragmentManager?.fragments?.size.toString()
            text = createChain(activity?.supportFragmentManager?.backStackEntryCount)
        }
        with(view.findViewById<Button>(R.id.button2)) {
            setOnClickListener {
                MyApplication.INSTANCE.getRouter().navigateTo(Screens.ExScreen())
                //(activity as MainActivity).addNewFragment()
            }
        }
        with(view.findViewById<Button>(R.id.button3)) {
            setOnClickListener {
                (activity as MainActivity).onBackPressed()
            }
        }
        with(view.findViewById<Button>(R.id.button4)) {
            setOnClickListener {
                // MyApplication.INSTANCE.getRouter().navigateTo(Screens.StartScreen())
                val intent =
                    Intent((activity as MainActivity).baseContext, DisplayMessageActivity::class.java).apply {
                        putExtra(
                            EXTRA_MESSAGE2,
                            view.findViewById<TextView>(R.id.textView3).text.toString()
                        )
                    }
                startActivity(intent)
            }
        }
        with(view.findViewById<Button>(R.id.button5)) {
            setOnClickListener {
                // MyApplication.INSTANCE.getRouter().navigateTo(Screens.RandomScreen())
                val num = activity?.supportFragmentManager?.backStackEntryCount!!
                var RandomNumber = let { Random().nextInt(num) }
                val intent =
                    Intent((activity as MainActivity).baseContext, RandomNumberActivity::class.java).apply {
                        putExtra(
                            EXTRA_MESSAGE3,
                            RandomNumber.toString()
                        )
                        putExtra(
                            EXTRA_MESSAGE4,
                            num.toString()
                        )
                    }
                startActivity(intent)
            }
        }
    }
}
