package com.example.myfirstapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment

/**
 * A simple [Fragment] subclass.
 * Use the [ExFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ExFragment : Fragment() {

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
            //text = activity?.supportFragmentManager?.fragments?.size.toString()
            text = activity?.supportFragmentManager?.backStackEntryCount.toString()
        }
        with(view.findViewById<Button>(R.id.button2)) {
            setOnClickListener {
                (activity as MainActivity).addNewFragment()
            }
        }
        with(view.findViewById<Button>(R.id.button3)) {
            setOnClickListener {
                (activity as MainActivity).onBackPressed()
            }
        }
    }
}