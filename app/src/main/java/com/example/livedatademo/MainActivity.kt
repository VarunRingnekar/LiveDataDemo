package com.example.livedatademo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val timerText: TextView = findViewById(R.id.timer_text)

        val viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        viewModel.startTimer()
        viewModel.seconds().observe(this, Observer{
            timerText.text = it.toString()
        })

        viewModel.finished.observe(this, Observer {
            if(it){
                viewModel.stopTimer()
                Toast.makeText(this, "TIMER IS FINISHED!!", Toast.LENGTH_SHORT).show()
            }
        })
    }
}