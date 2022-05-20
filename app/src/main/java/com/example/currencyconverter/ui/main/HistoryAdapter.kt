package com.example.currencyconverter.ui.main

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.currencyconverter.database.CurrenciesHistory
import com.example.currencyconverter.databinding.ItemOfHistoryBinding

class HistoryAdapter(private val datacurr : MutableList<CurrenciesHistory>): RecyclerView.Adapter<HistoryAdapter.HistoryHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HistoryAdapter.HistoryHolder {
        val binding = ItemOfHistoryBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return HistoryHolder(binding)
    }

    override fun onBindViewHolder(holder: HistoryHolder, position: Int) {
        val history: MutableList<CurrenciesHistory> = datacurr
        val currency = history[position]

        holder.bind(currency)
    }

    override fun getItemCount(): Int {
        return datacurr.size
    }

    inner class HistoryHolder internal constructor(private val binding: ItemOfHistoryBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(history: CurrenciesHistory) = binding.run {
            binding.curr.text = history.name
            binding.cost.text = history.cost.toString()
            binding.date.text = java.text.SimpleDateFormat("yyyy-MM-dd").format(history.date)
        }
    }
}