package com.example.currencyconverter.ui.main

import androidx.lifecycle.ViewModel
import com.example.currencyconverter.data.repository.CurrencyRepository


class MainViewModel(private val currencyRepository: CurrencyRepository) : ViewModel() {
//    val currencyResponse: MutableLiveData<CurrencyResponse> = MutableLiveData()
//
//    fun getCurrency() {
//        viewModelScope.launch {
//            val currency = currencyRepository.getRemoteData()
//            currencyResponse.value = currency
//        }
//    }
}