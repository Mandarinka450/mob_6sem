package com.example.currencyconverter.database

import androidx.room.TypeConverter
import com.google.gson.Gson

class Convertors {

    @TypeConverter
    fun toJsonCurrency(currency: String): String {
        return Gson().toJson(currency)
    }

    @TypeConverter
    fun toList(currency: String) = Gson().fromJson(currency, Array<CurrenciesSell>::class.java).toMutableList()
}