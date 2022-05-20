package com.example.currencyconverter.ui.main

import com.example.currencyconverter.data.DependencyInjection



object CurrencyHolder {

    suspend fun getCurr(): Map<String,Double> {
        val cur = DependencyInjection.repository.getRemoteData()
        return cur.rates
    }
}