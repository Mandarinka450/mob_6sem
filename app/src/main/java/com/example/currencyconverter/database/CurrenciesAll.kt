package com.example.currencyconverter.database

import androidx.annotation.NonNull
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class CurrenciesAll(
    @PrimaryKey
    @NonNull
    var name: String,
    val cost: Double,
    var like: Boolean,
) {

}