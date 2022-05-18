package com.example.currencyconverter.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.currencyconverter.R
import com.example.currencyconverter.databinding.HistoryOfCurrenciesBinding

class HistoryFragment(private var viewModel: MainViewModel) : Fragment() {



    lateinit var binding: HistoryOfCurrenciesBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = HistoryOfCurrenciesBinding.inflate(layoutInflater,container,false)

        binding.filter.setOnClickListener {
            fragmentManager?.beginTransaction()?.replace(R.id.list_of_currencies, FilterFragment.newInstance())?.commitNow()
        }
        return binding.root

    }

}