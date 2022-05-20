package com.example.currencyconverter.ui.main

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.currencyconverter.database.CurrenciesAll
import com.example.currencyconverter.databinding.CurrencyItemListBinding

class CurrencyAdapter(private val datacurr : MutableList<CurrenciesAll>,
                      private val showExchangeCurr: (String, Double)->Unit) : RecyclerView.Adapter<CurrencyAdapter.CurrencyHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CurrencyHolder {
        val binding = CurrencyItemListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CurrencyHolder(binding, showExchangeCurr)
    }

    override fun onBindViewHolder(holder: CurrencyHolder, position: Int) {
        val curr: MutableList<CurrenciesAll> = datacurr
        val currency = curr[position]

        holder.bind(currency)
    }

    override fun getItemCount(): Int {
        return datacurr.size
    }

    inner class CurrencyHolder internal constructor(private val binding: CurrencyItemListBinding,
                                                    private val showExchangeCurr: (String, Double) -> Unit): RecyclerView.ViewHolder(binding.root) {
        fun bind(currency: CurrenciesAll) = binding.run {
            binding.textCurrency.text = currency.name

            binding.textCurrency.setOnClickListener {
                showExchangeCurr(currency.name, currency.cost)
            }
        }
    }

}