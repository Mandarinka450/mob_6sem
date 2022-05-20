package com.example.currencyconverter.database

class CurrenciesHistoryRepository(private val currenciesDao: CurrenciesHistoryDao) {

    var getAllCurrencies = currenciesDao.getAllCurrenciesHistory();
    suspend fun insertCurrDb(currenciesHistory: CurrenciesHistory){
        currenciesDao.insertCurrenciesHistory(currenciesHistory)
    }
}