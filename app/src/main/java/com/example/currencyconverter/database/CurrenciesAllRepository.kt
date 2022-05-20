package com.example.currencyconverter.database

class CurrenciesAllRepository(private val currenciesAllDao: CurrenciesAllDao) {
    var getAllCurr = currenciesAllDao.getCurrenciesAll()

    suspend fun insertAllCurr(currenciesAll: CurrenciesAll){
        currenciesAllDao.insertCurrenciesAll(currenciesAll)
    }

//    suspend fun updateAllCurr(currenciesAll: CurrenciesAll){
//        currenciesAllDao.updateCurrenciesAll(currenciesAll)
//    }

    suspend fun updateAllCurr(name: String, like: Boolean){
        currenciesAllDao.updateCurrenciesAll(name, like)
    }

    suspend fun updateAllCostCurr(name: String, cost: Double){
        currenciesAllDao.updateCostCurr(name, cost)
    }



}