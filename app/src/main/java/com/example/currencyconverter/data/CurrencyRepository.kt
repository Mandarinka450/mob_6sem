package com.example.currencyconverter.data

import kotlinx.coroutines.Job

class CurrencyRepository {
    suspend fun getRemoteData():Job {
        return RemoteDataSource().getRemoteData()
    }
}