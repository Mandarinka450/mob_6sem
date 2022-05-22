package com.example.currencyconverter.ui.main

import android.app.Application
import android.content.SharedPreferences
import androidx.lifecycle.*
import com.example.currencyconverter.data.CurrencyResponse
import com.example.currencyconverter.data.LocalDataSource
import com.example.currencyconverter.database.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class MainViewModel(application: Application):ViewModel(){
    var oldTime = 0
    var prefs: SharedPreferences? = null

    fun isFirstRun(): Boolean? {
        if (prefs?.getBoolean("first", true) == true) {
            prefs!!.edit().putBoolean("first", false).commit();
            return true
        }else {
            return false
        }
    }

    val data = MutableLiveData<CurrencyResponse>()

    private val currenciesAllRepository: CurrenciesAllRepository
    private val currenciesHistoryRepository: CurrenciesHistoryRepository
    val getAllCurr: LiveData<MutableList<CurrenciesAll>>
    val getAllHistoryCurr: LiveData<MutableList<CurrenciesHistory>>

    fun insertCurrDb(values: CurrenciesHistory)
            = viewModelScope.launch(Dispatchers.IO) { currenciesHistoryRepository.insertCurrDb(values) }

    fun insertCurr(currenciesAll: CurrenciesAll)
            = viewModelScope.launch(Dispatchers.IO) {
        currenciesAllRepository.insertAllCurr(currenciesAll)
            }

//    fun updateCurrLike(name: String, like: Boolean)
//            = viewModelScope.launch(Dispatchers.IO) {
//        currenciesAllRepository.updateAllCurr(name, like)
//            }

    fun updateCurr(name: String, cost: Double)
            = viewModelScope.launch(Dispatchers.IO) { currenciesAllRepository.updateAllCostCurr(name, cost) }

    init {
        val currenciesAllDao = CurrenciesDatabase.getDatabase(application).CurrenciesAllDao()
        currenciesAllRepository = CurrenciesAllRepository(currenciesAllDao)
        getAllCurr = currenciesAllRepository.getAllCurr.asLiveData()
        val currenciesHistoryDao = CurrenciesDatabase.getDatabase(application).CurrenciesHistoryDao()
        currenciesHistoryRepository = CurrenciesHistoryRepository(currenciesHistoryDao)
        getAllHistoryCurr = currenciesHistoryRepository.getAllCurrencies.asLiveData()
    }

    suspend fun changeValues() {
        if (isFirstRun() == true){
            firstStart()
        }
//        firstStart()


        var time = System.currentTimeMillis().toInt()
        if ((time - oldTime)>300000){
            val rates = CurrencyHolder.getCurr().toList()
            for (i in rates){
                updateCurr(i.first, i.second)
            }
            oldTime = time
        }
    }

    suspend fun firstStart(){
        val rates = CurrencyHolder.getCurr().toList()
        for (i in rates){
            var save = CurrenciesAll(i.first, i.second, false)
            insertCurr(save)
        }
    }


}