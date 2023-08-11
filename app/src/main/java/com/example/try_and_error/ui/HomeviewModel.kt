package com.example.try_and_error.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class HomeviewModel :ViewModel(){

    private var _score = MutableLiveData(0)

    val score: LiveData<Int>
        get() = _score


    fun increaseScore(){
        _score.value = _score.value?.plus(1)
    }

    fun decreaseScore(){
        _score.value = _score.value?.minus(1)
    }
}