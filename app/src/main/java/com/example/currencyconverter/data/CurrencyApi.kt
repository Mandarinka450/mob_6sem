package com.example.currencyconverter.data

import retrofit2.http.GET

interface CurrencyApi {

    @GET("/api/latest?access_key=1aa61fe118a2a78f82bb522da7b96872")
    suspend fun getCurrencies(): CurrencyResponse
}