package com.example.myapplication

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class CalcViewModel :  ViewModel() {
    val num: MutableLiveData<Double> by lazy {
        MutableLiveData<Double>()
    }
}