package com.example.myfirstapp

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import com.example.myfirstapp.di.getAppComponent
import com.github.terrakok.cicerone.Router
import java.util.*
import javax.inject.Inject

class ExFragment : Fragment() {

    companion object {
        const val ARG_NUMBER = "number"
        fun newInstance(number: Int) = ExFragment().apply {
            arguments = bundleOf(
                ARG_NUMBER to number
            )
        }
    }

    private val number get() = arguments?.getInt(ARG_NUMBER, -1) ?: -1

    @Inject
    lateinit var router: Router

    override fun onAttach(context: Context) {
        context.getAppComponent().inject(this)
        super.onAttach(context)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View? = inflater.inflate(R.layout.example_fragment, container, false)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(view.findViewById<TextView>(R.id.textView3)) {
            text = (activity as MainActivity).getChain()
        }
        with(view.findViewById<Button>(R.id.button2)) {
            setOnClickListener {
                router.navigateTo(Screens.ExScreen(number + 1))
            }
        }
        with(view.findViewById<Button>(R.id.button3)) {
            setOnClickListener {
                router.exit()
            }
        }
        with(view.findViewById<Button>(R.id.button4)) {
            setOnClickListener {
                var message: String = view.findViewById<TextView>(R.id.textView3).text.toString()
                router.navigateTo(Screens.StartScreen(message))
            }
        }
        with(view.findViewById<Button>(R.id.button5)) {
            setOnClickListener {
                val num = activity?.supportFragmentManager?.backStackEntryCount!!.toString()
                val randomNumber = let { Random().nextInt(num.toInt()) }.toString()
                router.navigateTo(Screens.RandomScreen(randomNumber, num))
            }
        }
    }
}
