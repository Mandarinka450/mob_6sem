package com.example.currencyconverter.ui.main

import android.app.Application
import android.content.SharedPreferences
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.currencyconverter.data.CurrencyResponse
import java.util.*


class MainViewModel(application: Application):ViewModel(){
    var oldTime = 0
    var prefs: SharedPreferences? = null
    var sharedEditor: SharedPreferences.Editor? = null

    fun isFirstRun(): Boolean? {
        if (prefs?.getBoolean("first", true) == true) {
            prefs!!.edit().putBoolean("first", false).commit();
            return true
        }else {
            return false
        }
    }

    val data = MutableLiveData<CurrencyResponse>()


    suspend fun changeValues() {
        if (isFirstRun() == true){
//            firstRun()
        }


        var time = System.currentTimeMillis().toInt()
        if ((time - oldTime)>300000){
            val rates = CurrencyHolder.getCurr().toList()
            for (i in rates){
                updateCost(i.first, i.second)
            }
            oldTime = time
        }
    }


}