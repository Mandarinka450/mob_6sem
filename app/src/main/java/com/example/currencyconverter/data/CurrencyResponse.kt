package com.example.currencyconverter.data

data class CurrencyResponse(
    val success: String,
    val timestamp: Long,
    val base: String,
    val date: String,
    val rates: Map<String, Double>
)