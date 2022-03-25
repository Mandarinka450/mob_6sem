package com.example.currencyconverter.data.repository

import com.example.currencyconverter.data.CurrencyResponse
import com.example.currencyconverter.data.LocalDataSource
import com.example.currencyconverter.data.RemoteDataSource

class CurrencyRepository(private val remoteDataSource: RemoteDataSource, private val localDataSource: LocalDataSource) {
    suspend fun getRemoteData():CurrencyResponse {
        return remoteDataSource.getRemoteData()
    }
}