package com.example.currencyconverter.data

import kotlinx.coroutines.Job

class CurrencyRepository(private val remoteDataSource: RemoteDataSource,
                         private val localDataSource: LocalDataSource) {
    suspend fun getRemoteData():CurrencyResponse {
        return remoteDataSource.getRemoteData()
    }
}