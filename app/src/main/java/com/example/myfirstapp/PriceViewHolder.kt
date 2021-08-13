package com.example.myfirstapp

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class PriceViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    private val valuteNameTextView = view.findViewById<TextView>(R.id.textview_valute)
    private val valuteValueTextView = view.findViewById<TextView>(R.id.textview_value)

    fun bind(valute: Map.Entry<String, Valute>) {
        valuteNameTextView.text = valute.value.name
        valuteValueTextView.text = valute.value.value.toString()
    }
}
