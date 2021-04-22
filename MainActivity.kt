package com.example.coroutinecontexts

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.*

class MainActivity : AppCompatActivity() {

    val TAG = "MainActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        GlobalScope.launch(Dispatchers.IO) {
            Log.d(TAG, "Starting coroutines in thread, ${Thread.currentThread().name}")
            val answer = doNetWorkCall()
            withContext(Dispatchers.Main){
                Log.d(TAG, "Setting text in thread, ${Thread.currentThread().name}")
                tvDummy.text = answer

            }

        }
    }

    suspend fun doNetWorkCall(): String{
        delay(3000L)
        return "This is the answer"
    }
}