package com.example.myfirstapp

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class PriceAdapter : RecyclerView.Adapter<PriceViewHolder>() {
    private val items = mutableListOf<Map.Entry<String, Valute>>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PriceViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_price, parent, false)
        return PriceViewHolder(view)
    }

    override fun onBindViewHolder(holder: PriceViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int {
        return items.size
    }

    fun setData(items: Map<String, Valute>) {
        this.items.clear()
        this.items.addAll(items.entries)
        notifyDataSetChanged()
    }
}
