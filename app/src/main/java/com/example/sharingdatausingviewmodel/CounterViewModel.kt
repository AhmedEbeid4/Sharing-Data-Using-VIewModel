package com.example.sharingdatausingviewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class CounterViewModel:ViewModel() {
    private val counter = MutableLiveData<Int>()

    init {
        counter.value=0
    }
    fun inc(){
        counter.value=counter.value!! + 1
    }
    fun dec(){
        counter.value=counter.value!! - 1
    }
    fun getCounter():LiveData<Int>{
        return counter
    }
}