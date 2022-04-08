package com.example.currencyconverter.database

import androidx.annotation.NonNull
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class CurrenciesSell(
    @PrimaryKey(autoGenerate = true) @NonNull
    val id: Int,
    var value: String,
    val cost: Double,
    val finalCost: Double,
    val date: String
) {
}