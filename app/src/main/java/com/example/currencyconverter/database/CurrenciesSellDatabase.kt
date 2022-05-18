package com.example.currencyconverter.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters


@Database(entities = [CurrenciesHistory::class], version = 1)
@TypeConverters(Convertors::class)
abstract class CurrenciesSellDatabase: RoomDatabase() {

    abstract fun CurrenciesDao(): CurrenciesHistoryDao

    companion object {
        @Volatile
        private var db: CurrenciesSellDatabase? = null

        fun getDatabase(context: Context): CurrenciesSellDatabase {
            val tempInstance = db
            if(tempInstance != null){ return tempInstance }
            synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    CurrenciesSellDatabase::class.java, "currencies_database")
                    .build()
                db = instance
                return instance
            }
        }
    }

}