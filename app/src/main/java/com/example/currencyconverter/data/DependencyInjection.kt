package com.example.currencyconverter.data

import com.example.currencyconverter.data.api.CurrencyApi
import com.example.currencyconverter.data.repository.CurrencyRepository
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object DependencyInjection {
    private val interceptor = HttpLoggingInterceptor().also {
        it.setLevel(HttpLoggingInterceptor.Level.BODY)
    }

    private val client = OkHttpClient.Builder().addInterceptor(interceptor).build()

    private val retrofit = Retrofit.Builder()
        .client(client)
        .baseUrl("http://data.fixer.io/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    private val service = retrofit.create(CurrencyApi::class.java)

    private val remoteDataSource = RemoteDataSource(service)
    private val localDataSource = LocalDataSource()
    val repository = CurrencyRepository(remoteDataSource, localDataSource)


}