package com.example.currencyconverter.ui.main

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.currencyconverter.databinding.ExchangeCurrenciesBinding

class ExchangeCurrency(private val title: String, private  val value: Double) : Fragment() {


    lateinit var binding: ExchangeCurrenciesBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = ExchangeCurrenciesBinding.inflate(layoutInflater,container,false)

        binding.titleTwoCurrency.setText(title)
        binding.value.setText(value.toString())
        binding.titleCurrency.setText("EUR")

        binding.quantity.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

            }

            override fun afterTextChanged(s: Editable) {
                if (binding.quantity.getText().toString() == "") {
                    binding.value.setText("%.2f".format(value))
                } else {
                    var final = "%.2f".format(
                        Integer.parseInt(
                            binding.quantity.getText().toString()
                        ) * value
                    )
                    binding.value.setText(final)
                }

            }
        })

        return binding.root
    }
}