package com.example.currencyconverter.ui.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.currencyconverter.data.CurrencyRepository
import com.example.currencyconverter.data.CurrencyResponse
import kotlinx.coroutines.launch
import retrofit2.Response
import java.util.*


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