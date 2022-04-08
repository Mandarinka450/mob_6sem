package com.example.currencyconverter.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow


@Dao
interface CurrenciesDao {

    @Query("SELECT * FROM `CurrenciesSell`")
    fun getAllCurrenciesSell(): Flow<MutableList<CurrenciesSell>>
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertNode(values: CurrenciesSell)

}