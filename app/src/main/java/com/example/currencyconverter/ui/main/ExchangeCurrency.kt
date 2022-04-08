package com.example.currencyconverter.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.currencyconverter.databinding.ExchangeCurrenciesBinding

class ExchangeCurrency : Fragment() {
    companion object {
        fun newInstance() = ExchangeCurrency()
    }

    lateinit var binding: ExchangeCurrenciesBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = ExchangeCurrenciesBinding.inflate(layoutInflater,container,false)
        return binding.root

    }
}