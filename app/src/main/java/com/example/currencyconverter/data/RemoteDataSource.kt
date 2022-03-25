package com.example.currencyconverter.data

import android.util.Log
import com.example.currencyconverter.data.api.CurrencyApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import kotlin.coroutines.CoroutineContext

class RemoteDataSource(private val currencyApi : CurrencyApi) {
       suspend fun getRemoteData(): CurrencyResponse{
           val currency = currencyApi.getCurrencies()
           return currency
       }
}