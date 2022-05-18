package com.example.currencyconverter.ui.main

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.currencyconverter.databinding.CurrencyItemListBinding

class CurrencyAdapter(private val onClickCard: (String, Double) -> Unit, private val data: Map<String,Double>): RecyclerView.Adapter<CurrencyAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CurrencyAdapter.ViewHolder {
        val binding = CurrencyItemListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val array: Array<Pair<String, Double>> = data.toList().toTypedArray()
        val rate = array[position]
        holder.bind(rate)

    }

    inner class ViewHolder internal constructor(private val binding: CurrencyItemListBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(rate: Pair<String, Double>) = binding.run {
            binding.textCurrency.text = rate.first
            binding.cardItem.setOnClickListener{
                onClickCard(rate.first, rate.second)
            }
        }
    }

}