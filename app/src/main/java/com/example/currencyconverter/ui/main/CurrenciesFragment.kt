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
import com.example.currencyconverter.database.CurrenciesAll
import com.example.currencyconverter.databinding.CurrenciesFragmentBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

class CurrenciesFragment(private var viewModel: MainViewModel) : Fragment() {
    lateinit var binding: CurrenciesFragmentBinding


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = CurrenciesFragmentBinding.inflate(layoutInflater,container,false)

        fun main() = runBlocking {
            launch {
                setupRecycleView()
            }
        }
        main()
        return binding.root

    }
    suspend fun setupRecycleView() {
        binding.recyclerCurrencies.layoutManager = LinearLayoutManager(activity)
        viewModel.changeValues()
        viewModel.getAllCurr.observe(viewLifecycleOwner) { values ->
            binding.recyclerCurrencies.adapter = CurrencyAdapter(values, ::showEchangeCurr) }

    }

    private  fun showEchangeCurr(name: String, cost: Double): Unit{
        fragmentManager?.beginTransaction()?.replace(R.id.list_of_currencies, ExchangeCurrency(viewModel, name, cost), ExchangeCurrency::class.java.simpleName)
            ?.commit()
    }
}