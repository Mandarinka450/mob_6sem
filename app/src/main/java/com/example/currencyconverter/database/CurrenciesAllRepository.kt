package com.example.currencyconverter.database

class CurrenciesAllRepository(private val currenciesAllDao: CurrenciesAllDao) {
    var getAllCurr = currenciesAllDao.getCurrenciesAll()

    suspend fun insertAllCurr(currenciesAll: CurrenciesAll){
        currenciesAllDao.insertCurrenciesAll(currenciesAll)
    }

    suspend fun updateAllCurr(currenciesAll: CurrenciesAll){
        currenciesAllDao.updateCurrenciesAll(currenciesAll)
    }

    suspend fun updateAllCostCurr(name: String, cost: Double){
        currenciesAllDao.updateCostCurr(name, cost)
    }


}