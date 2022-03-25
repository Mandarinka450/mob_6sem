package com.example.currencyconverter.data.model

class Currencies(
    val timestamp: Long,
    val base: String,
    val rates: List<Currency>
)

data class Currency(
    val id: Int,
    val name: String,
    val value: Double
)