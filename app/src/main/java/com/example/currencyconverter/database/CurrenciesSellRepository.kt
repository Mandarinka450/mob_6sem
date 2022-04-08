package com.example.currencyconverter.database

class CurrenciesSellRepository(private val currenciesDao: CurrenciesDao) {

    var getAllCurrencies = currenciesDao.getAllCurrenciesSell();
    suspend fun insertValue(values: CurrenciesSell){
        currenciesDao.insertNode(values)
    }
}