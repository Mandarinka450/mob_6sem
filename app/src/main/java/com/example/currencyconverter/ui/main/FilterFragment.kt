package com.example.currencyconverter.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.currencyconverter.databinding.FiltersBinding
import com.example.currencyconverter.databinding.HistoryOfCurrenciesBinding

class FilterFragment : Fragment() {
    companion object {
        fun newInstance() = FilterFragment()
    }

    lateinit var binding: FiltersBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FiltersBinding.inflate(layoutInflater,container,false)
        return binding.root

    }
}