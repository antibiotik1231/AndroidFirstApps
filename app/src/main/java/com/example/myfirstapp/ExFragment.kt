package com.example.myfirstapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

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
        view.findViewById<TextView>(R.id.textView3).setText("0")
        val button2: Button = view.findViewById<Button>(R.id.button2)
        button2.setOnClickListener(object : View.OnClickListener {
           override fun onClick(v: View?) {
                val textView = v?.findViewById<TextView>(R.id.textView3)
                var number = Integer.parseInt(textView?.text.toString())
                number++
                val newTextView = v?.findViewById<TextView>(R.id.textView3)?.apply {
                    text = number.toString()
                }
            }
        })


        val button: Button = view.findViewById<Button>(R.id.button3)
        button.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View) {
                val MyToast = Toast.makeText(activity,"Hi!", Toast.LENGTH_LONG)
                MyToast.show()
            }
        })


    }

    fun counterFragment(view: View) {
        val textView = view.findViewById<TextView>(R.id.textView3)
        var number = Integer.parseInt(textView.text.toString())
        number++
        val newTextView = view.findViewById<TextView>(R.id.textView3).apply {
            text = number.toString()
        }
    }
}