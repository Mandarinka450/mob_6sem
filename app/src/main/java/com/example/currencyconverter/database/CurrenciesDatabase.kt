package com.example.currencyconverter.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters


@Database(entities = [CurrenciesHistory::class, CurrenciesAll::class], version = 4)
@TypeConverters(Convertors::class)
abstract class CurrenciesDatabase: RoomDatabase() {

    abstract fun CurrenciesHistoryDao(): CurrenciesHistoryDao
    abstract fun CurrenciesAllDao(): CurrenciesAllDao

    companion object {
        @Volatile
        private var db: CurrenciesDatabase? = null

        fun getDatabase(context: Context): CurrenciesDatabase {
            val tempInstance = db
            if(tempInstance != null){ return tempInstance }
            synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    CurrenciesDatabase::class.java, "currencies_database")
                    .fallbackToDestructiveMigration()
                    .build()
                db = instance
                return instance
            }
        }
    }

}