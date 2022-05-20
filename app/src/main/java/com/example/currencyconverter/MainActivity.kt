package com.example.currencyconverter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.example.currencyconverter.ui.main.MainFragment
import com.example.currencyconverter.ui.main.MainViewModel
import com.example.currencyconverter.ui.main.ModelFactory



class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)

        val provider = ViewModelProvider(this, ModelFactory(application))[MainViewModel::class.java]
        val mainFragment = MainFragment(provider)

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, mainFragment)
                .commitNow()
        }

    }
}