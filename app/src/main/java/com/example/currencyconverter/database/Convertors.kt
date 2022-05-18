package com.example.currencyconverter.database

import androidx.room.TypeConverter
import com.google.gson.Gson

class Convertors {
    @TypeConverter
    fun toList(currenciesAll: CurrenciesAll) = Gson().fromJson(
        currenciesAll.name, Array<CurrenciesAll>::class.java).toList()
}