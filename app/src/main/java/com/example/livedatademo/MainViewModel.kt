package com.example.livedatademo

import android.os.CountDownTimer
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel: ViewModel() {
    private lateinit var timer: CountDownTimer

    private val _seconds = MutableLiveData<Int>()

    val finished = MutableLiveData<Boolean>()

    fun seconds() : LiveData<Int>{
        return _seconds
    }

    fun startTimer(){
        timer = object : CountDownTimer(10000, 1000){
            override fun onTick(millisUntilFinished: Long) {
                val timeLeft = millisUntilFinished/1000
                _seconds.value = timeLeft.toInt()
            }

            override fun onFinish() {
                finished.value = true
            }

        }.start()
    }

    fun stopTimer(){
        timer.cancel()
    }
}