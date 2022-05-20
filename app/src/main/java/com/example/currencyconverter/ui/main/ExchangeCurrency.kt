package com.example.currencyconverter.ui.main

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.currencyconverter.database.CurrenciesHistory
import com.example.currencyconverter.databinding.ExchangeCurrenciesBinding

class ExchangeCurrency(private var viewModel: MainViewModel,
                       private val name: String,
                       private val cost: Double) : Fragment() {
    lateinit var binding: ExchangeCurrenciesBinding

    private fun insertCurrenciesDB(viewModel: MainViewModel, values: CurrenciesHistory){
        viewModel.insertCurrDb(values)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = ExchangeCurrenciesBinding.inflate(layoutInflater,container,false)
        binding.titleTwoCurrency.setText(name)
        binding.value.setText(cost.toString())
        binding.titleCurrency.setText("EUR")

        binding.quantity.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

            }

            override fun afterTextChanged(s: Editable) {
                if (binding.quantity.getText().toString() == "") {
                    binding.value.setText("%.2f".format(cost))
                } else {
                    var final = "%.2f".format(
                        Integer.parseInt(
                            binding.quantity.getText().toString()
                        ) * cost
                    )
                    binding.value.setText(final)
                }

            }
        })

        binding.changeCurr.setOnClickListener{
            val id = System.currentTimeMillis().toInt()
            val values = CurrenciesHistory(id, name, cost, System.currentTimeMillis())
            insertCurrenciesDB(viewModel, values)
        }
        return binding.root
    }
}