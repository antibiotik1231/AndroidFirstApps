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
import com.example.myfirstapp.databinding.ExampleFragmentBinding
import com.example.myfirstapp.di.getAppComponent
import com.github.terrakok.cicerone.Router
import java.util.*
import javax.inject.Inject

class ExFragment : Fragment(R.layout.example_fragment) {

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

    private lateinit var binding: ExampleFragmentBinding

    override fun onAttach(context: Context) {
        context.getAppComponent().inject(this)
        super.onAttach(context)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val chainText = (activity as MainActivity).getChain()
        binding = ExampleFragmentBinding.bind(view)
        with(binding) {
            textView3.text = chainText
            button2.setOnClickListener {
                router.navigateTo(Screens.ExScreen(number + 1))
            }
            button3.setOnClickListener {
                router.exit()
            }
            button4.setOnClickListener {
                router.navigateTo(Screens.StartScreen(chainText))
            }
            button5.setOnClickListener {
                val num = (number + 1).toString()
                val randomNumber = let { Random().nextInt(num.toInt()) }.toString()
                router.navigateTo(Screens.RandomScreen(randomNumber, num))
            }
        }
    }
}
