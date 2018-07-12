package com.alexmasson58.jsonplaceholdermvvmkotlin.view

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.alexmasson58.jsonplaceholdermvvmkotlin.R
import kotlinx.coroutines.experimental.delay
import kotlinx.coroutines.experimental.launch

class SplashActivity : AppCompatActivity() {

    private val mydelay: Int = 3000

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        launch() {
            delay(mydelay)

        }
    }
}
