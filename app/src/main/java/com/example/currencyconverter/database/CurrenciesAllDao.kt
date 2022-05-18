package com.example.currencyconverter.database

import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface CurrenciesAllDao {
    @Query("SELECT * FROM `CurrenciesAll` ORDER BY `like`=0")
    fun getCurrenciesAll(): Flow<MutableList<CurrenciesAll>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCurrenciesAll(currenciesAll: CurrenciesAll)

    @Update
    suspend fun updateCurrenciesAll(currenciesAll: CurrenciesAll)

    @Query("UPDATE `CurrenciesAll` SET 'cost'=:cost WHERE 'value'=:name")
    fun updateCostCurr(name: String, cost: Double)


}