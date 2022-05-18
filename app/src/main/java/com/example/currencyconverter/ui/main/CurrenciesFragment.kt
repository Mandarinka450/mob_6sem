package com.example.currencyconverter.ui.main

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.currencyconverter.R
import com.example.currencyconverter.data.CurrencyResponse
import com.example.currencyconverter.data.DependencyInjection.repository
import com.example.currencyconverter.databinding.CurrenciesFragmentBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.launch

class CurrenciesFragment(private var viewModel: MainViewModel) : Fragment() {
    lateinit var binding: CurrenciesFragmentBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = CurrenciesFragmentBinding.inflate(layoutInflater,container,false)


        binding.recyclerCurrencies.layoutManager = LinearLayoutManager(activity)

        fun Data() = lifecycleScope.launch(Dispatchers.Main) {
            val rates = async(Dispatchers.IO) {
                repository.getRemoteData()
            }

            var data = rates.await()
            if(data.success) {
                binding.recyclerCurrencies.adapter = CurrencyAdapter(::onClickCard, data.rates)
            }
        }
        Data()
        return binding.root

    }

    private fun onClickCard(title: String, value: Double): Unit{
        fragmentManager?.beginTransaction()?.replace(R.id.list_of_currencies, ExchangeCurrency(title, value))?.commitNow()
    }

}