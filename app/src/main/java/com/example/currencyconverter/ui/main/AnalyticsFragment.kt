package com.example.currencyconverter.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.currencyconverter.databinding.AnaliticsBinding
import com.example.currencyconverter.databinding.ExchangeCurrenciesBinding
import com.example.currencyconverter.databinding.HistoryOfCurrenciesBinding

class AnalyticsFragment : Fragment() {
    companion object {
        fun newInstance() = AnalyticsFragment()
    }

    lateinit var binding: AnaliticsBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = AnaliticsBinding.inflate(layoutInflater,container,false)
        return binding.root

    }
}