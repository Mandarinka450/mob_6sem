package com.example.currencyconverter.database

import androidx.annotation.NonNull
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class CurrenciesHistory(
    @PrimaryKey(autoGenerate = true) @NonNull
    val id: Int,
    var name: String,
    val cost: Double,
    val date: Long
) {
}