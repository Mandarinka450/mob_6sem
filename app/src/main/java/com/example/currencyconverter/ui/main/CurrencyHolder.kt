package com.example.currencyconverter.ui.main

import com.example.currencyconverter.data.DependencyInjection

class CurrencyHolder {

    suspend fun getCurr(): Map<String,Double> {
        val cur = DependencyInjection.repository.getRemoteData()
        return cur.rates
    }
}