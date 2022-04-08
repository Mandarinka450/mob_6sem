package com.example.currencyconverter.ui.main

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.currencyconverter.data.CurrencyRepository
import com.example.currencyconverter.data.CurrencyResponse
import com.example.currencyconverter.database.CurrenciesSell
import com.example.currencyconverter.database.CurrenciesSellRepository
import kotlinx.coroutines.launch
import retrofit2.Response
import java.util.*


class MainViewModel(private val repository: CurrenciesSellRepository, application: Application) : ViewModel() {
//    val data = MutableLiveData<CurrencyResponse>()

}