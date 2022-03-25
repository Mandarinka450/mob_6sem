package com.example.currencyconverter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.currencyconverter.data.DependencyInjection
import com.example.currencyconverter.data.repository.CurrencyRepository
import com.example.currencyconverter.ui.main.MainFragment
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, MainFragment.newInstance())
                .commitNow()
        }

        GlobalScope.launch(Dispatchers.Default) {
            DependencyInjection.repository.getRemoteData()
        }

    }
}