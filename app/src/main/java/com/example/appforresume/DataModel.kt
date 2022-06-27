package com.example.appforresume

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

open class DataModel : ViewModel() {
    val messageToQuestFrag1: MutableLiveData<Boolean> by lazy {
        MutableLiveData<Boolean>()
    }
    val turnOnClickable: MutableLiveData<Boolean> by lazy {
        MutableLiveData<Boolean>()
    }
    val scoreToResult: MutableLiveData<Int> by lazy {
        MutableLiveData<Int>()
    }
}