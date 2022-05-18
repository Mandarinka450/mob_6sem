package com.example.currencyconverter.ui.main

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.currencyconverter.R
import com.example.currencyconverter.databinding.MainFragmentBinding


class MainFragment(private var viewModel: MainViewModel) : Fragment() {
    lateinit var binding: MainFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = MainFragmentBinding.inflate(layoutInflater, container, false)


        binding.change.setOnClickListener {
            fragmentManager?.beginTransaction()
                ?.replace(R.id.list_of_currencies, CurrenciesFragment(viewModel))?.commitNow()
        }

        binding.history.setOnClickListener {
            fragmentManager?.beginTransaction()
                ?.replace(R.id.list_of_currencies, HistoryFragment(viewModel))?.commitNow()
        }

        binding.analytics.setOnClickListener {
            fragmentManager?.beginTransaction()
                ?.replace(R.id.list_of_currencies, AnalyticsFragment(viewModel))?.commitNow()
        }

        return binding.root
    }
}