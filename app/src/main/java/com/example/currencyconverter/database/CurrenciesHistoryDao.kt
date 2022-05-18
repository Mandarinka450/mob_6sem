package com.example.currencyconverter.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow


@Dao
interface CurrenciesHistoryDao {

    @Query("SELECT * FROM CurrenciesHistory")
    fun getAllCurrenciesHistory(): Flow<MutableList<CurrenciesHistory>>
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCurrenciesHistory(currenciesHistory: CurrenciesHistory)

}