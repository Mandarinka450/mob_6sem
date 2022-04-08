package com.example.currencyconverter.ui.main

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.currencyconverter.R
import com.example.currencyconverter.databinding.MainFragmentBinding


class MainFragment : Fragment() {


    companion object {
        fun newInstance() = MainFragment()
    }

    private lateinit var viewModel: MainViewModel
    lateinit var binding: MainFragmentBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = MainFragmentBinding.inflate(layoutInflater, container, false)


        binding.change.setOnClickListener {
            fragmentManager?.beginTransaction()?.replace(R.id.list_of_currencies, CurrenciesFragment.newInstance())?.commitNow()
        }

        binding.history.setOnClickListener {
            fragmentManager?.beginTransaction()?.replace(R.id.list_of_currencies, HistoryFragment.newInstance())?.commitNow()
        }

        binding.analytics.setOnClickListener {
            fragmentManager?.beginTransaction()?.replace(R.id.list_of_currencies, AnalyticsFragment.newInstance())?.commitNow()
        }

        binding.filter.setOnClickListener {
            fragmentManager?.beginTransaction()?.replace(R.id.list_of_currencies, FilterFragment.newInstance())?.commitNow()
        }
        return binding.root
    }

//    override fun onActivityCreated(savedInstanceState: Bundle?) {
//        super.onActivityCreated(savedInstanceState)
//        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
//        // TODO: Use the ViewModel
//    }

}